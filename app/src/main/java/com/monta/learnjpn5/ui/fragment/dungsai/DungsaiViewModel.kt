package com.monta.learnjpn5.ui.fragment.dungsai

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.monta.learnjpn5.base.BaseViewModel
import com.monta.learnjpn5.data.KanjiRepository
import com.monta.learnjpn5.data.WordRepository
import com.monta.learnjpn5.model.Kanji
import com.monta.learnjpn5.model.Word
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

class DungsaiViewModel @Inject constructor(
    private val wordRepository: WordRepository,
    private val kanjiRepository: KanjiRepository
) : BaseViewModel() {

    private val words = mutableListOf<Word>()

    private val kanjis = mutableListOf<Kanji>()

    private var bool = false

    val question = MutableLiveData<String>()

    val questionVN = MutableLiveData<String>()

    val awnser = MutableLiveData<String>()

    val background1 = MutableLiveData(-1)

    val background2 = MutableLiveData(-1)

    val point = MutableLiveData<Int>()

    val done = MutableLiveData<Boolean>()

    fun onCreateQuiz(topic: Int) {
        val i1 = Random.nextInt(2)
        val i2 = Random.nextInt(2)

        bool = i1 == i2

        viewModelScope.launch(exceptionHandler) {
            if (topic == 0) {
                words.addAll(wordRepository.getRandomWords(4))

                question.value = words[i1].word
                questionVN.value = words[i2].wordVN

                awnser.value = words[i1].wordVN
            } else {
                kanjis.addAll(kanjiRepository.getRandomKanjis(4))

                question.value = kanjis[i1].kanji
                questionVN.value = kanjis[i2].vn

                awnser.value = kanjis[i1].vn
            }

            loading.value = false
        }
    }

    fun onSelectAwnser(awnser: Boolean) {
        if (bool)
            background1.value = 1
        else {
            background2.value = 1
        }

        if (awnser == bool) {
            point.value = 1
        } else {
            if (bool) {
                background2.value = 0
            } else {
                background1.value = 0
            }
            point.value = 0
        }
        done.value = true
    }
}