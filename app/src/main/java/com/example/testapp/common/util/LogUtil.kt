package com.example.testapp.common.util

import android.util.Log
import com.example.testapp.BuildConfig

object LogUtil {

    private fun debug(tag: String, msg: String) {
        if (BuildConfig.DEBUG) {
            Log.d(tag, msg)
        }
    }

    fun debug(msg: String?) {
        msg?.let { debug("TESTAPP_", it) }
    }
}