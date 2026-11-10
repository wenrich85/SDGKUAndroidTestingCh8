package com.example.sdgkuandroidtestingch8

import android.os.Looper
import android.widget.CheckBox
import android.widget.TextView
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows.shadowOf
import org.robolectric.annotation.Config
import org.robolectric.annotation.LooperMode

/**
 * Activity 3, Part C: integration test that builds MainActivity in isolation with Robolectric
 * and verifies its behavior on the local JVM, without a device or emulator.
 */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [35])
@LooperMode(LooperMode.Mode.PAUSED)
class MainActivityRobolectricTests {

    private fun launchActivity(): MainActivity {
        val activity = Robolectric.buildActivity(MainActivity::class.java).setup().get()
        shadowOf(Looper.getMainLooper()).idle() // let Compose run its first frame
        return activity
    }

    @Test
    fun activityLaunches_withAppTitle() {
        val activity = launchActivity()

        assertFalse(activity.isFinishing)
        assertEquals("SDGKUAndroidTestingCh8", activity.title.toString())
    }

    @Test
    fun rememberMeCheckbox_isPresentAndUncheckedByDefault() {
        val activity = launchActivity()

        val checkbox = activity.findViewById<CheckBox>(R.id.remember_me_checkbox)
        val label = activity.findViewById<TextView>(R.id.remember_me_text)

        assertNotNull(checkbox)
        assertFalse(checkbox.isChecked)
        assertEquals("Remember me is unchecked", label.text.toString())
    }

    @Test
    fun checkingRememberMe_updatesLabel() {
        val activity = launchActivity()
        val checkbox = activity.findViewById<CheckBox>(R.id.remember_me_checkbox)
        val label = activity.findViewById<TextView>(R.id.remember_me_text)

        checkbox.performClick()
        shadowOf(Looper.getMainLooper()).idle() // recompose after state change

        assertTrue(checkbox.isChecked)
        assertEquals("Remember me is checked", label.text.toString())
    }
}
