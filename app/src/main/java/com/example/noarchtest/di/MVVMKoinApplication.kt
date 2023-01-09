package com.example.noarchtest.di

import android.app.Application
import org.koin.core.context.startKoin

class MVVMKoinApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin { modules(listOf(appModule)) }
    }
}