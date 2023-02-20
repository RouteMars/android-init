package com.example.testapp.view.activity._base

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity

abstract class BaseActivity : ComponentActivity() {

    ////////////////////////////////////////////////
    // OVERRIDE
    ////////////////////////////////////////////////

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT
        } catch (e: Exception) {
        }
        setComposeContent()
        init()
    }

    ////////////////////////////////////////////////
    // ABSTRACT
    ////////////////////////////////////////////////

    // protected abstract fun getViewType(): ActivityType
    protected abstract fun setComposeContent()
    protected abstract fun init()

    ////////////////////////////////////////////////
}