package org.hyperskill.hit.the.beaver

import android.text.InputType
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.google.common.truth.Truth.assertWithMessage
import junit.framework.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner


@RunWith(RobolectricTestRunner::class)
class StartScreenUnitTest {

    private val activityController = Robolectric.buildActivity(MainActivity::class.java)


    @Test
    fun testShouldCheckEditTextExist() {
        val activity = activityController.setup().get()
        val editText = activity.findViewById<EditText>(R.id.edit_text)

        val message = "EditText with id \"edit_text\" not found in activity"
        assertNotNull(message, editText)

        assertWithMessage(message).that(editText).isNotNull()

        val message2 = "edit_text should have proper inputType attribute"
        assertEquals(message2, editText.inputType, InputType.TYPE_CLASS_TEXT)

        val errorMessage = "Initially EditText must not be visible "
        assertEquals(errorMessage, View.INVISIBLE, editText.visibility)
    }


    @Test
    fun testShouldCheckNextExist() {
        val activity = activityController.setup().get()
        val nextBtn = activity.findViewById<Button>(R.id.next_button)

        val message = "Next Button with id \"next_button\" not found in activity"
        assertNotNull(message, nextBtn)

        val errorMessage = "Initially next button must not be visible "
        assertNotSame(errorMessage, View.VISIBLE, nextBtn.visibility)
    }


    @Test
    fun testShouldCheckStartButtonExist() {
        val activity = activityController.setup().get()
        val startBtn = activity.findViewById<Button>(R.id.start_button)

        val message = "Start Button with id \"start_button\" not found in activity"
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

        val errorMessage1 = "After clicking start button it must not be visible "
        assertNotSame(errorMessage1, View.VISIBLE, startBtn.visibility)

        val errorMessage2 = "After clicking start button the EditText must be Visible "
        assertEquals(errorMessage2, View.VISIBLE, editText.visibility)

        val errorMessage3 = "After clicking start button it must be set to visible "
        assertEquals(errorMessage3, View.VISIBLE, nextBtn.visibility)
    }


}


