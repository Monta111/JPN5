package com.monta.learnjpn5.ui.fragment.tuluan

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.monta.learnjpn5.base.BaseViewModel
import com.monta.learnjpn5.data.KanjiRepository
import com.monta.learnjpn5.data.WordRepository
import com.monta.learnjpn5.model.Character
import com.monta.learnjpn5.model.Kanji
import com.monta.learnjpn5.model.Word
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

class TuluanViewModel @Inject constructor(
    private val wordRepository: WordRepository,
    private val kanjiRepository: KanjiRepository
) : BaseViewModel() {

    private val words = mutableListOf<Word>()

    private val kanjis = mutableListOf<Kanji>()

    private val i = Random.nextInt(4)

    val characters = MutableLiveData<List<Character>>()

    val question = MutableLiveData<String>()

    val awnser = MutableLiveData<String>()

    val point = MutableLiveData<Int>()

    val done = MutableLiveData<Boolean>()

    val perfect = MutableLiveData<Boolean>()

    fun onCreateQuiz(topic: Int) {
        viewModelScope.launch(exceptionHandler) {
            val split = mutableListOf<String>()

            if (topic == 0) {
                words.addAll(wordRepository.getRandomWords(4))

                question.value = words[i].word
                awnser.value = words[i].word

                for (word in words)
                    split.addAll(word.word.split("").filter { it.isNotBlank() })

            } else {
                kanjis.addAll(kanjiRepository.getRandomKanjis(4))

                question.value = kanjis[i].kanji
                awnser.value = kanjis[i].kanji

                for (kanji in kanjis)
                    split.addAll(kanji.kanji.split("").filter { it.isNotBlank() })
            }

            val chars = mutableListOf<Character>()

            with(split) {
                shuffle()
                add(0, " ")
                indices.forEach {
                    chars.add(Character(this[it], "", it))
                }
            }

            characters.value = chars
            loading.value = false
        }
    }

    fun submitAwnser(text: String) {
        done.value = true
        perfect.value = text.trim() == awnser.value
        if (text == awnser.value)
            point.value = 1
        else
            point.value = 0
    }
}