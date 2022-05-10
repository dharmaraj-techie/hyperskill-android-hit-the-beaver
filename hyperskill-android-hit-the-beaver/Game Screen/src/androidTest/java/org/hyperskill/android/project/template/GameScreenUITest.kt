package org.hyperskill.android.project.template

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.hyperskill.hit.the.beaver.MainActivity
import org.hyperskill.hit.the.beaver.R
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class GameScreenUITest {

    @Test
    fun startGameActivity_startsButton_onClick() {

        Intents.init()

        val activityScenario: ActivityScenario<MainActivity> =
            ActivityScenario.launch(MainActivity::class.java)

        activityScenario.moveToState(Lifecycle.State.RESUMED)

        onView(withId(R.id.start_button)).perform(click())
        onView(withId(R.id.edit_text)).perform(typeText("t"))
        onView(withId(R.id.next_button)).perform(click())

        intended(hasComponent(GameScreenActivity::class.java.name))
        Intents.release()
        activityScenario.moveToState(Lifecycle.State.DESTROYED)
    }

}