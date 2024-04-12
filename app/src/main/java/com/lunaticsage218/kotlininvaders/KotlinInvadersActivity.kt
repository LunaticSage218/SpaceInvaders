package com.lunaticsage218.kotlininvaders

import android.app.Activity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.WindowManager

class KotlinInvadersActivity : Activity() {
    // kotlinInvadersView will be the view of the game
    // It will also hold the logic of the game
    // and respond to screen touches as well
    private var kotlinInvadersView: KotlinInvadersView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val displayMetrics = DisplayMetrics()
        val windowManager = getSystemService(WindowManager::class.java)

        @Suppress("DEPRECATION")
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
            // For SDK versions 30 and above
            val display = windowManager?.defaultDisplay
            display?.getRealMetrics(displayMetrics)
        } else {
            // For SDK versions below 30
            @Suppress("DEPRECATION")
            windowManager?.defaultDisplay?.getMetrics(displayMetrics)
        }

        // Initialize gameView with the display metrics and set it as the view
        kotlinInvadersView = KotlinInvadersView(this, displayMetrics)
        setContentView(kotlinInvadersView)
    }

    // This method executes when the player starts the game
    override fun onResume() {
        super.onResume()
        // Tell the gameView resume method to execute
        kotlinInvadersView?.resume()
    }

    // This method executes when the player quits the game
    override fun onPause() {
        super.onPause()
        // Tell the gameView pause method to execute
        kotlinInvadersView?.pause()
    }
}