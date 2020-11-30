package com.monta.learnjpn5.ui.fragment.dungsai

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.monta.learnjpn5.R
import com.monta.learnjpn5.base.BaseFragment
import com.monta.learnjpn5.databinding.FragmentDungsaiBinding
import com.monta.learnjpn5.ui.fragment.quizdetail.QuizDetailViewModel

class DungsaiFragment : BaseFragment<FragmentDungsaiBinding, DungsaiViewModel>() {

    override val resLayoutId = R.layout.fragment_dungsai

    override val viewModel by viewModels<DungsaiViewModel> { getViewModelFactory() }

    private val parentViewModel by viewModels<QuizDetailViewModel>({ requireParentFragment() })

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        shareViewModel.selectedTopic.observe(viewLifecycleOwner) {
            viewModel.onCreateQuiz(it)
        }

        viewModel.point.observe(viewLifecycleOwner) {
            parentViewModel.point += it
        }
    }

    companion object {
        const val TAG = "DungsaiFragment"
    }
}