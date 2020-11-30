package com.monta.learnjpn5.ui.fragment.word

import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.monta.learnjpn5.R
import com.monta.learnjpn5.adapter.WordAdapter
import com.monta.learnjpn5.base.TextToSpeechFragment
import com.monta.learnjpn5.databinding.FragmentWordBinding
import com.monta.learnjpn5.util.GridSpacingItemDecoration

class WordFragment : TextToSpeechFragment<FragmentWordBinding, WordViewModel>(),
    WordAdapter.WordHolder.OnWordClickListener {

    override val resLayoutId = R.layout.fragment_word

    override val viewModel by viewModels<WordViewModel> { getViewModelFactory() }

    private val adapter = WordAdapter().apply {
        onItemClickListener = this@WordFragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        shareViewModel.lesson.observe(viewLifecycleOwner) {
            viewModel.onSelectLesson(it)
        }
        viewModel.words.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    override fun setupView() {
        setupRecyclerView()
    }

    private fun setupRecyclerView() = binding.recyclerview.apply {
        this.adapter = this@WordFragment.adapter
        layoutManager = GridLayoutManager(activity, 2)
        addItemDecoration(GridSpacingItemDecoration(2, 20, true))
    }

    override fun onFavoriteClick(word: String) = viewModel.onFavoriteClick(word)

    override fun onSpeakerClick(word: String) = speakText(word)

    override fun onWordJapanClick(word: String) {
        showFullWord(word)
    }

    override fun onWordVietnamClick(word: String) {
        showFullWord(word)
    }

    private fun showFullWord(word: String) = activity?.let {
        AlertDialog.Builder(it, R.style.AlertDialogTheme).create().apply {
            setMessage(word)
            show()
            findViewById<TextView>(android.R.id.message)?.setTextSize(
                TypedValue.COMPLEX_UNIT_SP,
                18F
            )
        }
    }

}