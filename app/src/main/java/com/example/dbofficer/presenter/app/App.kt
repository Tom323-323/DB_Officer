package com.example.dbofficer.presenter.app

import android.app.Application
import com.example.dbofficer.presenter.di.appModule
import com.example.dbofficer.presenter.di.dataModule
import com.example.dbofficer.presenter.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@App)
            modules(listOf(appModule, domainModule, dataModule))
        }
    }
}