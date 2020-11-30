package com.monta.learnjpn5.ui.fragment.quiz

import android.widget.Toast
import androidx.fragment.app.viewModels
import com.monta.learnjpn5.R
import com.monta.learnjpn5.base.BaseFragment
import com.monta.learnjpn5.databinding.FragmentQuizBinding
import com.monta.learnjpn5.ui.dialog.NumberQuizSelectionDialog
import com.monta.learnjpn5.ui.dialog.TopicSelectionDialog
import com.monta.learnjpn5.ui.fragment.quizdetail.QuizDetailFragment

class QuizFragment : BaseFragment<FragmentQuizBinding, QuizViewModel>() {

    override val resLayoutId = R.layout.fragment_quiz

    override val viewModel by viewModels<QuizViewModel> { getViewModelFactory() }

    override fun setupView() {
        setToolbar(binding.toolbar)
        displayUpButton(true)
    }

    fun showNumberOfQuizSelectionDialog() =
        NumberQuizSelectionDialog().show(childFragmentManager, null)

    fun showTopicSelectionDialog() = TopicSelectionDialog().show(childFragmentManager, null)

    fun onSelectBoxLuachon() {
        shareViewModel.checkLuachon.value = !shareViewModel.checkLuachon.value!!
    }

    fun onSelectBoxDungsai() {
        shareViewModel.checkDungsai.value = !shareViewModel.checkDungsai.value!!
    }

    fun onSelectBoxTuluan() {
        shareViewModel.checkTuluan.value = !shareViewModel.checkTuluan.value!!
    }

    fun goToDetail() = with(shareViewModel) {
        if (checkLuachon.value == false && checkDungsai.value == false && checkTuluan.value == false)
            Toast.makeText(activity, "Chọn ít nhất 1 loại quiz!", Toast.LENGTH_SHORT).show()
        else
            replaceFragment(
                QuizDetailFragment(),
                R.id.fragment_container,
                true,
                QuizDetailFragment.TAG
            )
    }


    companion object {
        const val TAG = "QuizFragment"
        val topic = listOf("Từ vựng", "Kanji")
    }
}