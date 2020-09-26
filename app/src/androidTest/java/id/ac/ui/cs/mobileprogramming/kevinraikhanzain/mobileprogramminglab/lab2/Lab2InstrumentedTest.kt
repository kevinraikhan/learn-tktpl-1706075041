package id.ac.ui.cs.mobileprogramming.kevinraikhanzain.mobileprogramminglab.lab2

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import id.ac.ui.cs.mobileprogramming.kevinraikhanzain.mobileprogramminglab.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class Lab2InstrumentedTest {
    @Rule
    @JvmField
    val rule: ActivityTestRule<Lab2Activity> = ActivityTestRule(Lab2Activity::class.java)

    @Test
    fun user_can_insert_first_number() {
        onView(withId(R.id.editTextFirstNumber)).perform(typeText("3"))
    }

    @Test
    fun user_can_insert_second_number() {
        onView(withId(R.id.editTextSecondNumber)).perform(typeText("4"))
    }

    @Test
    fun user_can_do_addition() {
        onView(withId(R.id.editTextFirstNumber)).perform(typeText("4"))
        onView(withId(R.id.editTextSecondNumber)).perform(typeText("3"))
        onView(withId(R.id.buttonPlus)).perform(click())
        onView(withId(R.id.textViewResult)).check(matches(withText("7.0")))
    }
}