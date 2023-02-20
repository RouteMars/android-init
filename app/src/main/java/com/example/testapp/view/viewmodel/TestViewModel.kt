package com.example.testapp.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp.common.util.LogUtil
import com.example.testapp.data.model.Album
import com.example.testapp.data.repository.TestRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TestViewModel @Inject constructor(
    private val testRepository: TestRepository
) : ViewModel() {

    private val _feeds = MutableStateFlow<Album?>(null)
    val feeds = _feeds.asStateFlow()

    fun loadTest(id: Int) {
        viewModelScope.launch {
            testRepository.getAlbum(id).let {
                it.data?.let { data ->
                    _feeds.value = data
                }
                LogUtil.debug(it.message)
            }
        }
    }

    // override fun onCleared() {
    //     super.onCleared()
    // }
}