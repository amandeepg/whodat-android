package ca.amandeep.playernumber.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.withFrameNanos
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import ca.amandeep.playernumber.PlayerNumberViewModel
import ca.amandeep.playernumber.ui.theme.PlayerNumberTheme
import java.util.concurrent.atomic.AtomicBoolean

class MainActivity : ComponentActivity() {
    private val viewModel: PlayerNumberViewModel by viewModels()
    private val keepSplashOn = AtomicBoolean(true)

    override fun onCreate(savedInstanceState: Bundle?) {
        val splash = installSplashScreen()
        splash.setKeepOnScreenCondition { keepSplashOn.get() }
        splash.setOnExitAnimationListener { splashView ->
            splashView.view
                .animate()
                .alpha(0f)
                .setDuration(300)
                .withEndAction { splashView.remove() }
                .start()
        }
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val darkTheme = isSystemInDarkTheme()
            PlayerNumberTheme(darkTheme = darkTheme) {
                SideEffect {
                    val controller = WindowCompat.getInsetsController(window, window.decorView)
                    controller.isAppearanceLightStatusBars = !darkTheme
                    controller.isAppearanceLightNavigationBars = !darkTheme
                }
                LaunchedEffect(Unit) {
                    withFrameNanos { }
                    keepSplashOn.set(false)
                }
                MainScreen(viewModel = viewModel)
            }
        }
    }
}
