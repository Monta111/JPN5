package com.monta.learnjpn5.ui.fragment.tuluan

import android.content.Context
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.monta.learnjpn5.R
import com.monta.learnjpn5.adapter.CharacterAdapter
import com.monta.learnjpn5.base.BaseFragment
import com.monta.learnjpn5.databinding.FragmentTuluanBinding
import com.monta.learnjpn5.ui.fragment.quizdetail.QuizDetailViewModel
import com.monta.learnjpn5.util.GridSpacingItemDecoration

class TuluanFragment : BaseFragment<FragmentTuluanBinding, TuluanViewModel>(),
    CharacterAdapter.CharacterHolder.OnCharacterClickListener {

    override val resLayoutId = R.layout.fragment_tuluan

    override val viewModel by viewModels<TuluanViewModel> { getViewModelFactory() }

    private val parentViewModel by viewModels<QuizDetailViewModel>({ requireParentFragment() })

    private val adapter = CharacterAdapter().apply {
        onItemClickListener = this@TuluanFragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        shareViewModel.selectedTopic.observe(viewLifecycleOwner) {
            viewModel.onCreateQuiz(it)
        }

        viewModel.point.observe(viewLifecycleOwner) {
            parentViewModel.point += it
        }

        viewModel.characters.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        viewModel.perfect.observe(viewLifecycleOwner) {
            if (it)
                binding.textviewAnswer.setCompoundDrawablesWithIntrinsicBounds(
                    null,
                    null,
                    ContextCompat.getDrawable(activity as Context, R.drawable.ic_check2),
                    null
                )
            else
                binding.textviewAnswer.setCompoundDrawablesWithIntrinsicBounds(
                    null,
                    null,
                    ContextCompat.getDrawable(activity as Context, R.drawable.ic_close),
                    null
                )
        }
    }

    override fun setupView() {
        binding.recyclerview.apply {
            this.adapter = this@TuluanFragment.adapter
            layoutManager = GridLayoutManager(activity, 3)
            addItemDecoration(GridSpacingItemDecoration(3, 5, false))
        }

        binding.textviewAnswer.movementMethod = ScrollingMovementMethod()
    }

    override fun onCharacterClick(text: String) {
        binding.textviewAnswer.append(text)
    }

    fun clearText() {
        binding.textviewAnswer.text = ""
    }

    fun submitAwnser() {
        viewModel.submitAwnser(binding.textviewAnswer.text.toString())
    }

    companion object {
        const val TAG = "TuluanFragment"
    }
}