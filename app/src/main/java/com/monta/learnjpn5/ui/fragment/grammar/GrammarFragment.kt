package com.monta.learnjpn5.ui.fragment.grammar

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.monta.learnjpn5.R
import com.monta.learnjpn5.base.BaseFragment
import com.monta.learnjpn5.databinding.FragmentGrammarBinding

class GrammarFragment : BaseFragment<FragmentGrammarBinding, GrammarViewModel>() {

    override val resLayoutId = R.layout.fragment_grammar

    override val viewModel by viewModels<GrammarViewModel> { getViewModelFactory() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        shareViewModel.lesson.value?.let {
            viewModel.onSelectLesson(it)
        }
    }
}