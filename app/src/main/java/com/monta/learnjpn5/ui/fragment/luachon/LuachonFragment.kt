package com.monta.learnjpn5.ui.fragment.luachon

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.monta.learnjpn5.R
import com.monta.learnjpn5.base.BaseFragment
import com.monta.learnjpn5.databinding.FragmentLuachonBinding
import com.monta.learnjpn5.ui.fragment.quizdetail.QuizDetailViewModel

class LuachonFragment : BaseFragment<FragmentLuachonBinding, LuachonViewModel>() {

    override val resLayoutId = R.layout.fragment_luachon

    override val viewModel by viewModels<LuachonViewModel> { getViewModelFactory() }

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
        const val TAG = "LuachonFragment"
    }
}