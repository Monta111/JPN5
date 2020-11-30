package com.monta.learnjpn5.ui

import androidx.lifecycle.MutableLiveData
import com.monta.learnjpn5.base.BaseViewModel
import com.monta.learnjpn5.ui.fragment.quiz.QuizFragment
import javax.inject.Inject

class ShareViewModel @Inject constructor() : BaseViewModel() {

    val lesson = MutableLiveData<String>()

    val numberOfQuiz = MutableLiveData(25)

    val selectedTopic = MutableLiveData(0)

    val selectedTopicString = MutableLiveData(QuizFragment.topic[0])

    val checkLuachon = MutableLiveData(false)

    val checkDungsai = MutableLiveData(false)

    val checkTuluan = MutableLiveData(false)
}