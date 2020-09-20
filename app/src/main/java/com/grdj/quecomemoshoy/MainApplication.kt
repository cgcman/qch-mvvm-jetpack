package com.grdj.quecomemoshoy

import android.app.Application
import com.facebook.stetho.Stetho
import com.grdj.quecomemoshoy.utils.CrashReportingTree
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import timber.log.Timber.DebugTree

@HiltAndroidApp
class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
            Stetho.initializeWithDefaults(this);
        } else {
            Timber.plant(CrashReportingTree())
        }
    }
}