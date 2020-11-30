package com.monta.learnjpn5.model

data class Grammar(
    var lesson: String,
    var content: String,
    var id: Int = 0
) {

    companion object {
        const val TAG = "Ngữ pháp"
    }
}