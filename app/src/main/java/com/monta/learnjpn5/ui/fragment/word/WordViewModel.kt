package com.monta.learnjpn5.ui.fragment.word

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.monta.learnjpn5.base.BaseViewModel
import com.monta.learnjpn5.data.WordRepository
import com.monta.learnjpn5.model.Word
import com.monta.learnjpn5.util.extractNumber
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class WordViewModel @Inject constructor(private val repository: WordRepository) : BaseViewModel() {

    val words = MutableLiveData<List<Word>>()

    fun onSelectLesson(lesson: String) {
        if (words.value == null)
            getWords(lesson)
    }

    private fun getWords(lesson: String) = viewModelScope.launch(exceptionHandler) {
        repository.getWords(lesson.extractNumber()).collect {
            words.value = it
            loading.value = false
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