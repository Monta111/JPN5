package com.monta.learnjpn5.model

data class Character(
    var character: String,
    var type: String,
    var id: Int,
    var selected: Boolean = false
) {
    companion object {
        const val HIRAGANA_TYPE = "Hiragana"
        const val KATAKANA_TYPE = "Katakana"
        const val TYPE_FIELD = "type"
    }
}