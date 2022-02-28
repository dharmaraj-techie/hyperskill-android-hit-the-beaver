package org.hyperskill.hit.the.beaver

import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows
import org.robolectric.shadows.ShadowToast


@RunWith(RobolectricTestRunner::class)
class ToastMessageUnitTest {

    private val activityController = Robolectric.buildActivity(MainActivity::class.java)
    private val activity: MainActivity = activityController.setup().get()
    private val startBtn = activity.findViewById<Button>(R.id.start_button)
    private val editText = activity.findViewById<EditText>(R.id.edit_text)
    private val nextBtn = activity.findViewById<Button>(R.id.next_button)


    @Test
    fun Toast_LongerInput_showsAToast() {
        startBtn.performClick()
        editText.setText("sfdkgmdnjj")
        nextBtn.performClick()

        Shadows.shadowOf(Looper.getMainLooper()).idle()
        val toast = ShadowToast.getLatestToast()
        Assert.assertNotNull("Toast is not shown", toast)

        val toastMessage = ShadowToast.getTextOfLatestToast().trim().toLowerCase()
        junit.framework.Assert.assertEquals("the text in toast is wrong",toastMessage , "enter a valid name")
    }

    @Test
    fun Toast_2Input_showsAToast() {
        startBtn.performClick()
        editText.setText("sf")
        nextBtn.performClick()

        Shadows.shadowOf(Looper.getMainLooper()).idle()
        val toast = ShadowToast.getLatestToast()
        Assert.assertNotNull("Toast is not shown", toast)

        val toastMessage = ShadowToast.getTextOfLatestToast().trim().toLowerCase()
        junit.framework.Assert.assertEquals("the text in toast is wrong", toastMessage , "begin game")
    }

    @Test
    fun Toast_1Input_showsAToast() {
        startBtn.performClick()
        editText.setText("s")
        nextBtn.performClick()

        Shadows.shadowOf(Looper.getMainLooper()).idle()
        val toast = ShadowToast.getLatestToast()
        Assert.assertNotNull("Toast is not shown", toast)

        val toastMessage = ShadowToast.getTextOfLatestToast().trim().toLowerCase()
        junit.framework.Assert.assertEquals("the text in toast is wrong", toastMessage , "begin game")
    }

    @Test
    fun Toast_CorrectInput_ShowsAToast() {
        startBtn.performClick()
        editText.setText("sfdkgmdn")
        nextBtn.performClick()

        Shadows.shadowOf(Looper.getMainLooper()).idle()

        val toast: Toast?  = ShadowToast.getLatestToast()
        Assert.assertNotNull("Toast is not shown", toast)

        val toastMessage = ShadowToast.getTextOfLatestToast().trim().toLowerCase()
        junit.framework.Assert.assertEquals("the text in toast is wrong",toastMessage , "begin game")
    }


    @Test
    fun Toast_EmptyInput_showsAToast() {
        startBtn.performClick()
        editText.setText("")
        nextBtn.performClick()

        Shadows.shadowOf(Looper.getMainLooper()).idle()
        val toast = ShadowToast.getLatestToast()
        Assert.assertNotNull("Toast is not shown", toast)

        val toastMessage = ShadowToast.getTextOfLatestToast().trim().toLowerCase()
        junit.framework.Assert.assertEquals("the text in toast is wrong", toastMessage , "enter a valid name")
    }

    @Test
    fun EditText_NonTextInput_showsAToast() {
        startBtn.performClick()
        editText.setText("d123#*GF")
        nextBtn.performClick()

        Shadows.shadowOf(Looper.getMainLooper()).idle()
        val toast = ShadowToast.getLatestToast()
        Assert.assertNotNull("Toast is not shown", toast)

        val toastMessage = ShadowToast.getTextOfLatestToast().trim().toLowerCase()

        junit.framework.Assert.assertEquals("Name should only contains text",toastMessage , "enter a valid name")
    }

    @Test
    fun beginGame_callingMethod_showsAToast() {
        val method = MainActivity::class.java.declaredMethods
        var contains  = false
        method.forEach {
            if(it.name == "beginGame"){
                contains = true
            }
        }
        Assert.assertEquals("No method declared with name beginGame", true,contains)

        activity.beginGame()

        Shadows.shadowOf(Looper.getMainLooper()).idle()
        val toast = ShadowToast.getLatestToast()
        Assert.assertNotNull("Toast is not shown", toast)

        val toastMessage = ShadowToast.getTextOfLatestToast().trim().toLowerCase()
        junit.framework.Assert.assertEquals("Name should only contains text",toastMessage , "begin game")
    }





}


