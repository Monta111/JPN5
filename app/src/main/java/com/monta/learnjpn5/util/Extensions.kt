package com.monta.learnjpn5.util

import androidx.lifecycle.MutableLiveData

fun String.extractNumber(): String = filter { it.isDigit() }

fun <T> MutableLiveData<T>.notifyObserver() {
    value = value
}
