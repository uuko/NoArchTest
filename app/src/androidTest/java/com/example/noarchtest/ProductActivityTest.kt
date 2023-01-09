package com.example.noarchtest

import android.view.View
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.withDecorView
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import com.example.noarchtest.product.ProductActivity
import org.hamcrest.Matchers
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@LargeTest
class ProductActivityTest {
    @Rule
    @JvmField
    public var activityScenarioRule = ActivityScenarioRule(
        ProductActivity::class.java
    )
    private lateinit var decorView: View;

    @Before
    fun setUp() {
        activityScenarioRule.scenario.onActivity {
            decorView = it.window.decorView
        }
    }


    @Test
    fun buy_click() {
        //Click send button
        Espresso.onView(ViewMatchers.withId(R.id.buy)).perform(ViewActions.click())
        Espresso.onView(withText("購買成功"))
            .inRoot(withDecorView(Matchers.not(decorView)))// Here we use decorView
            .check(matches(isDisplayed()));
    }


}