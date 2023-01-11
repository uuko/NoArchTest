package com.example.noarchtest.stepdefinitions

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers
import com.example.noarchtest.MainActivityTest
import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

class RegisterSteps {
    private val register = MainActivityTest()

    @Given("我開啟註冊頁面")
    fun when_I_am_On_RegisterScreen() {
        register.launchScreen()
    }

    @When("我在帳號輸入 (\\S+)")
    fun i_type_loginId(loginId: String) {
        register.typeLoginId(loginId)
    }

    @And("我在密碼輸入 (\\S+)")
    fun i_type_password(password: String) {
        register.typePassword(password)
    }

    @And("點擊註冊按鈕")
    fun i_tap_register() {
        register.tapRegisterButton()
    }

    @Then("我會看到註冊成功的畫面")
    fun i_see_registerSuccess() {
        register.registerSuccess()
    }

    @Then("我會看到註冊失敗的提醒")
    fun i_see_registerFail() {
        register.wrongPasswordAlert()
    }
}