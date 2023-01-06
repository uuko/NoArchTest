package com.example.noarchtest

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.isDialog
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import androidx.test.espresso.intent.Intents;
import org.junit.After

@LargeTest
class MainActivityTest {

    @Rule @JvmField
   public var activityScenarioRule = ActivityScenarioRule(
        MainActivity::class.java
    )

    @Before
    fun intentsInit() {
        // initialize Espresso Intents capturing
        Intents.init()
    }

    @After
    fun intentsTeardown() {
        // release Espresso Intents capturing
        Intents.release()
    }

    @Test
    fun rightPassword_should_startActivity() {
        inputRightRegisterData()
        //Click send button
        onView(withId(R.id.send)).perform(click())
        //verify screen should display "Sign Up Success"
//        onView(withText("Sign Up Success")).check(matches(isDisplayed()))
    }

    private fun inputRightRegisterData() {
        onView(withId(R.id.loginId)).perform(
            typeText("a123456789"),
            ViewActions.closeSoftKeyboard()
        )
        onView(withId(R.id.password)).perform(
            typeText("a111111111"),
            ViewActions.closeSoftKeyboard()
        )
    }

    @Test
    fun wrongPassword_should_alert() {
        inputWrongRegisterData()
    //點選註冊按鈕
        onView(withId(R.id.send)).perform(click())

        //register fail should alert
        onView(withText("Error"))
            .inRoot(isDialog())
            .check(matches(isDisplayed()))
    }

    private fun inputWrongRegisterData() {
        onView(withId(R.id.loginId)).perform(
            typeText("a123456789"),
            ViewActions.closeSoftKeyboard()
        )
        onView(withId(R.id.password)).perform(typeText("1234"), ViewActions.closeSoftKeyboard())
    }
}