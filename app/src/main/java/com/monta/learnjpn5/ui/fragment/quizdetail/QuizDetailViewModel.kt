package com.monta.learnjpn5.ui.fragment.quizdetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.monta.learnjpn5.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class QuizDetailViewModel @Inject constructor() : BaseViewModel() {
    val orders = mutableListOf<Int>()

    val currentQuiz = MutableLiveData(0)

    val pageQuizNumber = MutableLiveData<String>()

    val done = MutableLiveData(false)

    val perfect = MutableLiveData<Boolean>()

    val pointString = MutableLiveData<String>()

    var point = 0

    var numberOfQuiz = 0

    fun onCreateOrderQuiz(
        numberOfQuiz: Int,
        checkLuachon: Boolean,
        checkDungsai: Boolean,
        checkTuluan: Boolean
    ) = viewModelScope.launch(exceptionHandler) {
        createOrderQuiz(numberOfQuiz, checkLuachon, checkDungsai, checkTuluan)
        loading.value = false
    }

    fun onNextQuiz() {
        if (currentQuiz.value == numberOfQuiz - 1) {
            done.value = true
            perfect.value = point == numberOfQuiz
            pointString.value = "$point / $numberOfQuiz"
        } else
            currentQuiz.value = currentQuiz.value?.plus(1)
    }

    private suspend fun createOrderQuiz(
        numberOfQuiz: Int,
        checkLuachon: Boolean,
        checkDungsai: Boolean,
        checkTuluan: Boolean
    ) = withContext(Dispatchers.Default) {
        val a = if (checkLuachon) 1 else 0
        val b = if (checkDungsai) 2 else 0
        val c = if (checkTuluan) 4 else 0

        val div2 = numberOfQuiz / 2
        val div3 = numberOfQuiz / 3

        orders.apply {
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
            shuffle()
        }
    }
}