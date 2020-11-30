package com.monta.learnjpn5.model

data class Word(
    var id: Int,
    var wordVN: String,
    var word: String,
    var wordRomanji: String,
    var isFavorite: Boolean,
    var lesson: String
) {

    companion object {
        const val TAG = "Ngữ pháp"
    }
}