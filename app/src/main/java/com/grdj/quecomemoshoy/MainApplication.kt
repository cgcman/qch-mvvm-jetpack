package com.grdj.quecomemoshoy

import android.app.Application
import com.facebook.stetho.Stetho
import com.grdj.quecomemoshoy.di.appModule
import com.grdj.quecomemoshoy.utils.CrashReportingTree
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber
import timber.log.Timber.DebugTree

class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this);
        startKoin {
            androidContext(this@MainApplication)
            androidLogger()
            modules(appModule)
        }
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        } else {
            Timber.plant(CrashReportingTree())
        }
    }
}