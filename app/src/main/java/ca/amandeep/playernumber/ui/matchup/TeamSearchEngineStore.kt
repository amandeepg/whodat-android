package ca.amandeep.playernumber.ui.matchup

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

internal object TeamSearchEngineStore {
    private val lock = Any()
    private var deferred: Deferred<TeamSearchEngine>? = null

    fun prewarm(
        scope: CoroutineScope,
        delayMs: Long = 1_000L,
        dispatcher: CoroutineDispatcher = Dispatchers.Default,
    ) {
        synchronized(lock) {
            val current = deferred
            if (current != null && !current.isCancelled) return
            deferred =
                scope.async(dispatcher) {
                    delay(delayMs)
                    TeamSearchEngine()
                }
        }
    }

    suspend fun await(dispatcher: CoroutineDispatcher = Dispatchers.Default): TeamSearchEngine =
        coroutineScope {
            val current =
                synchronized(lock) {
                    val existing = deferred
                    if (existing != null && !existing.isCancelled) {
                        existing
                    } else {
                        val created = async(dispatcher) { TeamSearchEngine() }
                        deferred = created
                        created
                    }
                }
            current.await()
        }
}
