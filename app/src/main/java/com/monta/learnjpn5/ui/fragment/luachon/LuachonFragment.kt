package com.monta.learnjpn5.ui.fragment.luachon

import androidx.fragment.app.viewModels
import com.monta.learnjpn5.R
import com.monta.learnjpn5.base.BaseFragment
import com.monta.learnjpn5.databinding.FragmentLuachonBinding
import com.monta.learnjpn5.ui.fragment.quizdetail.QuizDetailViewModel

class LuachonFragment : BaseFragment<FragmentLuachonBinding, LuachonViewModel>() {

    override val resLayoutId = R.layout.fragment_luachon

    override val viewModel by viewModels<LuachonViewModel> { getViewModelFactory() }

    private val parentViewModel by viewModels<QuizDetailViewModel>({ requireParentFragment() })


    companion object {
        const val TAG = "LuachonFragment"
    }
}