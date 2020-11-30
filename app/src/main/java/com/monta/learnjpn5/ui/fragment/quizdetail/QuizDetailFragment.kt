package com.monta.learnjpn5.ui.fragment.quizdetail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.monta.learnjpn5.R
import com.monta.learnjpn5.base.BaseFragment
import com.monta.learnjpn5.databinding.FragmentQuizDetailBinding
import com.monta.learnjpn5.ui.fragment.dungsai.DungsaiFragment
import com.monta.learnjpn5.ui.fragment.luachon.LuachonFragment
import com.monta.learnjpn5.ui.fragment.tuluan.TuluanFragment

class QuizDetailFragment : BaseFragment<FragmentQuizDetailBinding, QuizDetailViewModel>() {

    override val resLayoutId = R.layout.fragment_quiz_detail

    override val viewModel by viewModels<QuizDetailViewModel> { getViewModelFactory() }

    override fun setupView() {
        setToolbar(binding.toolbar)
        displayUpButton(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(shareViewModel) {
            viewModel.onCreateOrderQuiz(
                numberOfQuiz.value!!,
                checkLuachon.value!!,
                checkDungsai.value!!,
                checkTuluan.value!!
            )
            viewModel.numberOfQuiz = numberOfQuiz.value!!
        }

        with(viewModel) {
            loading.observe(viewLifecycleOwner) {
                if (!it)
                    currentQuiz.observe(viewLifecycleOwner) { current ->
                        pageQuizNumber.value = "${current + 1} / $numberOfQuiz"
                        when (orders[current]) {
                            1 -> replaceChildFragment(
                                LuachonFragment(),
                                R.id.child_fragment_container,
                                LuachonFragment.TAG
                            )
                            2 -> replaceChildFragment(
                                DungsaiFragment(),
                                R.id.child_fragment_container,
                                LuachonFragment.TAG
                            )
                            4 -> replaceChildFragment(
                                TuluanFragment(),
                                R.id.child_fragment_container,
                                TuluanFragment.TAG
                            )
                        }
                    }
            }
        }
    }

    companion object {
        const val TAG = "QuizDetailFragment"
    }
}