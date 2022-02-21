package org.hyperskill.hit.the.beaver

import android.os.Handler
import android.os.Looper
import android.os.Looper.getMainLooper
import android.text.InputType
import android.view.View
import android.widget.Button
import android.widget.EditText
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows.shadowOf
import org.robolectric.annotation.LooperMode


@RunWith(RobolectricTestRunner::class)
class StartScreenUnitTest {

    private val activityController = Robolectric.buildActivity(MainActivity::class.java)


    @Test
    fun testShouldCheckEditTextExist() {
        val activity = activityController.setup().get()
        val editText = activity.findViewById<EditText>(R.id.edit_text)

        val message = "EditText with id \"edit_text\" not found in activity"
        assertNotNull(message, editText)

        val message2 = "edit_text should have proper inputType attribute"
        assertEquals(message2, editText.inputType, InputType.TYPE_CLASS_TEXT)

        val errorMessage = "Initially EditText must be Invisible "
        assertEquals(errorMessage, View.INVISIBLE, editText.visibility)
    }

    @Test
    fun testShouldCheckNextExist() {
        val activity = activityController.setup().get()
        val nextBtn = activity.findViewById<Button>(R.id.next_button)

        val message = "does view with id \"edit_text\" placed in activity?"
        assertNotNull(message, nextBtn)

        val errorMessage = "Initially start button must be set to visible "
        assertEquals(errorMessage, View.INVISIBLE, nextBtn.visibility)
    }


    @Test
    fun testShouldCheckStartButtonExist() {
        val activity = activityController.setup().get()
        val startBtn = activity.findViewById<Button>(R.id.start_button)

        val message = "does view with id \"start_button\" placed in activity?"
        assertNotNull(message, startBtn)

        val errorMessage = "Initially start button must be set to visible "
        assertEquals(errorMessage, View.VISIBLE, startBtn.visibility)
    }

    @Test
    fun testCheckStartButtonClick() {
        val activity = activityController.setup().get()
        val startBtn = activity.findViewById<Button>(R.id.start_button)
        val editText = activity.findViewById<EditText>(R.id.edit_text)
        val nextBtn = activity.findViewById<Button>(R.id.next_button)

        startBtn.performClick()

        val errorMessage1 = "After clicking start button it must be Invisible "
        assertEquals(errorMessage1, View.INVISIBLE, startBtn.visibility)

        val errorMessage2 = "After clicking start button the EditText must be Visible "
        assertEquals(errorMessage2, View.VISIBLE, editText.visibility)

        val errorMessage3 = "After clicking start button it must be set to visible "
        assertEquals(errorMessage3, View.VISIBLE, nextBtn.visibility)
    }


}


