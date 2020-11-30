package com.monta.learnjpn5.ui.fragment.quizdetail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.monta.learnjpn5.R
import com.monta.learnjpn5.base.BaseFragment
import com.monta.learnjpn5.databinding.FragmentQuizDetailBinding

class QuizDetailFragment : BaseFragment<FragmentQuizDetailBinding, QuizDetailViewModel>() {

    override val resLayoutId = R.layout.fragment_quiz_detail

    override val viewModel by viewModels<QuizDetailViewModel> { getViewModelFactory() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        shareViewModel.selectedTopic.observe(viewLifecycleOwner) {
            if (it == 0) {
                viewModel.onSelectVocabularyTopic()
            } else
                viewModel.onSelectKanjiTopic()
        }

        shareViewModel.let {
            viewModel.onCreateOrderQuiz(
                it.numberOfQuiz.value!!,
                it.checkLuachon.value!!,
                it.checkDungsai.value!!,
                it.checkTuluan.value!!
            )
        }
    }

    companion object {
        const val TAG = "QuizDetailFragment"
    }
}