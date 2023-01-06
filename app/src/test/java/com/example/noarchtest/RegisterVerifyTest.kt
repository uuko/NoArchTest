package com.example.noarchtest

import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
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
        assertTrue(registerVerify.isLoginIdVerify("A123456"))
    }

    @Test
    fun loginVerifyFalse() {
        assertFalse(registerVerify.isLoginIdVerify("A1234"))
    }
}