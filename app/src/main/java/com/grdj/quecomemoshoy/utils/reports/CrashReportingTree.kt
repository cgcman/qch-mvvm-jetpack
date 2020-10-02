package com.grdj.quecomemoshoy.utils.reports

import android.util.Log
import timber.log.Timber


class CrashReportingTree : Timber.Tree() {
    override fun log(
        priority: Int,
        tag: String?,
        message: String,
        t: Throwable?
    ) {
        if (priority == Log.VERBOSE || priority == Log.DEBUG) {
            return
        }

        // This can be for example Fiebase CrashLytics
        // FakeCrashLibrary.log(priority, tag, message)

        if (t != null) {
            if (priority == Log.ERROR) {
                // FakeCrashLibrary.logError(t)
            } else if (priority == Log.WARN) {
                // FakeCrashLibrary.logWarning(t)
            }
        }
    }
}