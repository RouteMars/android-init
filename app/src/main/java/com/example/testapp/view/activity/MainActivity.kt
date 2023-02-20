package com.example.testapp.view.activity

import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.testapp.common.util.LogUtil
import com.example.testapp.view.activity._base.BaseActivity
import com.example.testapp.view.theme.TestAppTheme
import com.example.testapp.view.ui.MainScreen
import com.example.testapp.view.viewmodel.TestViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private val mTestViewModel: TestViewModel by viewModels()

    ////////////////////////////////////////////////
    // OVERRIDE
    ////////////////////////////////////////////////

    override fun setComposeContent() {
        setContent {
            TestAppTheme {
                MainScreen()
            }
        }
    }

    override fun init() {
        initViews()
        test()
    }

    ////////////////////////////////////////////////
    // PRIVATE
    ////////////////////////////////////////////////

    private fun initViews() {
    }

    private fun test() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                mTestViewModel.loadTest(3)
                mTestViewModel.feeds.collect {
                    LogUtil.debug("CALL~~")
                    it
                }
            }
        }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {

            }
        }
    }

    ////////////////////////////////////////////////
}