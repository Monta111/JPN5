package com.monta.learnjpn5.ui.fragment.favorite

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.monta.learnjpn5.base.BaseViewModel
import com.monta.learnjpn5.data.WordRepository
import com.monta.learnjpn5.model.Word
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class FavoriteViewModel @Inject constructor(private val repository: WordRepository) :
    BaseViewModel() {
    var words = MutableLiveData<List<Word>>()

    val empty = MutableLiveData<Boolean>()

    init {
        getFavoriteWords()
    }

    private fun getFavoriteWords() {
        viewModelScope.launch {
            repository.getFavoriteWords().collect {
                if (it.isEmpty()) {
                    empty.value = true
                    words.value = mutableListOf()
                } else
                    words.value = it
                loading.value = false
            }
        }
    }

    fun onFavoriteClick(word: String) {
        words.value?.let {
            for (w in it)
                if (w.word == word) {
                    w.isFavorite = !w.isFavorite
                    viewModelScope.launch(exceptionHandler) {
                        repository.updateFavoriteWord(w)
                    }
                    break
                }
        }
    }
}