package com.example.noarchtest


import org.junit.Assert
import org.junit.Before
import org.junit.Test

class RegisterVerifyTest {
    lateinit var registerVerify:RegisterVerify
    @Before
    fun init(){
         registerVerify = RegisterVerify()
    }
    @Test
    fun loginVerifyTrue() {
        Assert.assertTrue(registerVerify.isLoginIdVerify("A123456"))
    }

    @Test
    fun loginVerifyFalse() {
        Assert.assertFalse(registerVerify.isLoginIdVerify("A1234"))
    }
}