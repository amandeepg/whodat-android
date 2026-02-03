package ca.amandeep.playernumber.data.api

import com.squareup.moshi.Moshi
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.time.LocalDate

internal object TodayGamesStore {
    private val lock = Any()
    private var deferred: Deferred<TodayGamesResult>? = null
    private val repository by lazy { createRepository() }

    fun prewarm(
        scope: CoroutineScope,
        delayMs: Long = 1_000L,
        dispatcher: CoroutineDispatcher = Dispatchers.IO,
    ) {
        synchronized(lock) {
            val current = deferred
            if (current != null && !current.isCancelled) return
            deferred =
                scope.async(dispatcher) {
                    delay(delayMs)
                    repository.fetchTodayGames()
                }
        }
    }

    suspend fun await(
        dispatcher: CoroutineDispatcher = Dispatchers.IO,
        force: Boolean = false,
    ): TodayGamesResult =
        coroutineScope {
            val current =
                synchronized(lock) {
                    val existing = deferred
                    if (!force && existing != null && !existing.isCancelled) {
                        existing
                    } else {
                        val created = async(dispatcher) { repository.fetchTodayGames() }
                        deferred = created
                        created
                    }
                }
            val result = current.await()
            val today = LocalDate.now()
            return@coroutineScope if (result.date != today) {
                synchronized(lock) {
                    if (deferred === current) {
                        deferred = null
                    }
                }
                await(dispatcher, force = true)
            } else {
                result
            }
        }

    private fun createRepository(): EspnTodayGamesRepository {
        val moshi = Moshi.Builder().build()
        val okHttpClient = OkHttpClient.Builder().build()
        val retrofit =
            Retrofit
                .Builder()
                .baseUrl("https://site.api.espn.com/")
                .client(okHttpClient)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()

        val service = retrofit.create(EspnScoreboardService::class.java)
        return EspnTodayGamesRepository(
            service = service,
            ioDispatcher = Dispatchers.IO,
        )
    }
}
