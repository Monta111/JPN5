package com.monta.learnjpn5.base

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {
    var loading = MutableLiveData(true)
    var throwable = MutableLiveData(false)

    val exceptionHandler = CoroutineExceptionHandler { _, t ->
        throwable.value = true
        loading.value = false

        Log.e("Coroutine Exception", "Exception in ${javaClass.simpleName}: ${t.stackTrace}")

        viewModelScope.launch {
            delay(1000)
            throwable.value = false
        }
    }
}