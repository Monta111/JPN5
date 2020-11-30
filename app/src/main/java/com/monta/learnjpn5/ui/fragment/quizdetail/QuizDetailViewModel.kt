package com.monta.learnjpn5.ui.fragment.quizdetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.monta.learnjpn5.base.BaseViewModel
import com.monta.learnjpn5.data.KanjiRepository
import com.monta.learnjpn5.data.WordRepository
import com.monta.learnjpn5.model.Kanji
import com.monta.learnjpn5.model.Word
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class QuizDetailViewModel @Inject constructor(
    private val wordRepository: WordRepository,
    private val kanjiRepository: KanjiRepository
) : BaseViewModel() {

    val words = MutableLiveData<MutableList<Word>>()

    val kanjis = MutableLiveData<MutableList<Kanji>>()

    val orders = MutableLiveData<MutableList<Int>>(mutableListOf())

    fun onSelectVocabularyTopic() = viewModelScope.launch(exceptionHandler) {
        words.value = wordRepository.getRandomWords(50).toMutableList()
        loading.value = false
    }

    fun onSelectKanjiTopic() = viewModelScope.launch(exceptionHandler) {
        kanjis.value = kanjiRepository.getRandomKanjis(50).toMutableList()
    }

    fun onCreateOrderQuiz(
        numberOfQuiz: Int,
        checkLuachon: Boolean,
        checkDungsai: Boolean,
        checkTuluan: Boolean
    ) = viewModelScope.launch {
        withContext(Dispatchers.Main) {
            val a = if (checkLuachon) 1 else 0
            val b = if (checkDungsai) 2 else 0
            val c = if (checkTuluan) 4 else 0

            val div2 = numberOfQuiz / 2
            val div3 = numberOfQuiz / 3

            orders.value?.apply {
                when (a + b + c) {
                    1 -> repeat(numberOfQuiz) { add(1) }
                    2 -> repeat(numberOfQuiz) { add(2) }
                    4 -> repeat(numberOfQuiz) { add(4) }
                    3 -> {
                        repeat(div2) { add(1) }
                        repeat(numberOfQuiz - div2) { add(2) }
                    }
                    5 -> {
                        repeat(div2) { add(1) }
                        repeat(numberOfQuiz - div2) { add(4) }
                    }
                    6 -> {
                        repeat(div2) { add(2) }
                        repeat(numberOfQuiz - div2) { add(4) }
                    }
                    7 -> {
                        repeat(div3) {
                            add(1)
                            add(2)
                        }
                        repeat(numberOfQuiz - 2 * div3) {
                            add(4)
                        }
                    }
                }
            }

            orders.value?.shuffle()
        }
    }
}