package com.example.noarchtest

import android.content.Context
import android.content.SharedPreferences
import com.google.common.base.CharMatcher.any
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

class RepositoryTest {

    @Test
    fun saveUserId() {
        val sharedPrefs = mockk<SharedPreferences>(relaxed = true)
        val sharedPrefsEditor = mockk<SharedPreferences.Editor>(relaxed = true)
        val context = mockk<Context>(relaxed = true)

        every{context.getSharedPreferences(any(), any())}.returns(sharedPrefs)
        every{sharedPrefs.edit()}.returns(sharedPrefsEditor)
        every{sharedPrefsEditor.putString(any(), any())}.returns(sharedPrefsEditor)

        val userId = "A1234567"
        val preKey = "USER_ID"

        val repository = Repository(context)
        repository.saveUserId(userId)

        verify{sharedPrefsEditor.putString(eq(preKey), eq(userId)) }

        verify{sharedPrefsEditor.commit()}
    }
}