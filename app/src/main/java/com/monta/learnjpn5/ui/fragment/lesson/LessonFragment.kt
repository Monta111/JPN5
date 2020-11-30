package com.monta.learnjpn5.ui.fragment.lesson

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.monta.learnjpn5.R
import com.monta.learnjpn5.adapter.LessonAdapter
import com.monta.learnjpn5.base.BaseFragment
import com.monta.learnjpn5.databinding.FragmentLessonBinding
import com.monta.learnjpn5.ui.fragment.mina.MinaFragment

class LessonFragment : BaseFragment<FragmentLessonBinding, LessonViewModel>(),
    LessonAdapter.LessonHolder.OnLessonClickListener {

    override val resLayoutId = R.layout.fragment_lesson

    override val viewModel by viewModels<LessonViewModel> { getViewModelFactory() }

    override fun setupView() {
        setToolbar(binding.toolbar)
        displayUpButton(true)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.recyclerview.apply {
            adapter = LessonAdapter().apply {
                submitList(List(25) {
                    "Lesson ${it + 1}"
                })
                onItemClickListener = this@LessonFragment
            }
            layoutManager = LinearLayoutManager(activity)
        }
    }

    override fun onLessonClick(lesson: String) {
        shareViewModel.lesson.value = lesson
        goToMina()
    }

    private fun goToMina() {
        replaceFragment(MinaFragment(), R.id.fragment_container, true, MinaFragment.TAG)
    }

    companion object {
        const val TAG = "LessonFragment"
    }
}