package com.monta.learnjpn5.ui.fragment.luachon

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

class LuachonViewModel @Inject constructor(
    private val wordRepository: WordRepository,
    private val kanjiRepository: KanjiRepository
) : BaseViewModel() {

    private val words = mutableListOf<Word>()

    private val kanjis = mutableListOf<Kanji>()

    private val i = Random.nextInt(4)

    val question = MutableLiveData<String>()

    val choice1 = MutableLiveData<String>()
    val background1 = MutableLiveData(-1)

    val choice2 = MutableLiveData<String>()
    val background2 = MutableLiveData(-1)

    val choice3 = MutableLiveData<String>()
    val background3 = MutableLiveData(-1)

    val choice4 = MutableLiveData<String>()
    val background4 = MutableLiveData(-1)

    val point = MutableLiveData<Int>()

    val done = MutableLiveData<Boolean>()

    fun onCreateQuiz(topic: Int) {
        viewModelScope.launch(exceptionHandler) {
            if (topic == 0) {
                words.addAll(wordRepository.getRandomWords(4))

                question.value = words[i].word
                choice1.value = words[0].wordVN
                choice2.value = words[1].wordVN
                choice3.value = words[2].wordVN
                choice4.value = words[3].wordVN
            } else {
                kanjis.addAll(kanjiRepository.getRandomKanjis(4))

                question.value = kanjis[i].kanji
                choice1.value = kanjis[0].vn
                choice2.value = kanjis[1].vn
                choice3.value = kanjis[2].vn
                choice4.value = kanjis[3].vn
            }

            loading.value = false
        }
    }

    fun onSelectAwnser(awnser: Int) {
        done.value = true
        when (awnser) {
            i -> point.value = 1
            else -> point.value = 0
        }
        when (awnser) {
            0 -> if (i == 0) background1.value = 1 else background1.value = 0
            1 -> if (i == 1) background2.value = 1 else background2.value = 0
            2 -> if (i == 2) background3.value = 1 else background3.value = 0
            3 -> if (i == 3) background4.value = 1 else background4.value = 0
        }
        when (i) {
            0 -> background1.value = 1
            1 -> background2.value = 1
            2 -> background3.value = 1
            3 -> background4.value = 1
        }
    }
}