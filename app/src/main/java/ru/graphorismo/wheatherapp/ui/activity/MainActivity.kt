package ru.graphorismo.wheatherapp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.launch
import ru.graphorismo.wheatherapp.R
import ru.graphorismo.wheatherapp.ui.main.MainFragment
import ru.graphorismo.wheatherapp.ui.splash.SplashFragment

class MainActivity : AppCompatActivity() {

    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {
            // repeatOnLifecycle launches the block in a new coroutine every time the
            // lifecycle is in the STARTED state (or above) and cancels it when it's STOPPED.
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                // Trigger the flow and start listening for values.
                // Note that this happens when lifecycle is STARTED and stops
                // collecting when the lifecycle is STOPPED
                viewModel.uiState.collect { uiState ->
                    // New value received
                    when (uiState) {
                        UIState.SPLASH -> showSplashFragment()
                        UIState.MAIN -> showMainFragment()
                    }
                }
            }
        }
    }

    private fun showMainFragment() {
        val mainFragment = MainFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.mainFragmentContainerView, mainFragment)
            .commit()
    }

    private fun showSplashFragment() {
        val splash = SplashFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.mainFragmentContainerView, splash)
            .commit()
    }
}