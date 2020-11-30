package com.monta.learnjpn5.ui.fragment.grammar

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.monta.learnjpn5.base.BaseViewModel
import com.monta.learnjpn5.data.GrammarRepository
import com.monta.learnjpn5.util.extractNumber
import kotlinx.coroutines.launch
import javax.inject.Inject

class GrammarViewModel @Inject constructor(private val repository: GrammarRepository) :
    BaseViewModel() {

    val content = MutableLiveData("")

    fun onSelectLesson(lesson: String) {
        if (content.value == null || content.value == "")
            getGrammar(lesson)
    }

    private fun getGrammar(lesson: String) = viewModelScope.launch(exceptionHandler) {
        content.value = repository.getGrammars(lesson.extractNumber())[0].content
        loading.value = false
    }

}