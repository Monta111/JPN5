package com.monta.learnjpn5.ui.dialog

import com.monta.learnjpn5.R
import com.monta.learnjpn5.base.BaseBottomSheetDialogFragment
import com.monta.learnjpn5.databinding.DialogTopicBinding
import com.monta.learnjpn5.ui.fragment.quiz.QuizFragment

class TopicSelectionDialog : BaseBottomSheetDialogFragment<DialogTopicBinding>() {

    override val resLayoutId = R.layout.dialog_topic

    fun onSelectVocabularyTopic() = shareViewModel.apply {
        selectedTopicString.value = QuizFragment.topic[0]
        selectedTopic.value = 0
        dismiss()
    }


    fun onSelectKanjiTopic() = shareViewModel.apply {
        shareViewModel.selectedTopicString.value = QuizFragment.topic[1]
        selectedTopic.value = 1
        dismiss()
    }
}