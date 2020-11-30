package com.monta.learnjpn5.ui.fragment.favorite

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.monta.learnjpn5.R
import com.monta.learnjpn5.adapter.WordAdapter
import com.monta.learnjpn5.base.TextToSpeechFragment
import com.monta.learnjpn5.databinding.FragmentFavoriteBinding
import com.monta.learnjpn5.util.GridSpacingItemDecoration

class FavoriteFragment : TextToSpeechFragment<FragmentFavoriteBinding, FavoriteViewModel>(),
    WordAdapter.WordHolder.OnWordClickListener {

    override val resLayoutId = R.layout.fragment_favorite

    override val viewModel by viewModels<FavoriteViewModel> { getViewModelFactory() }

    private val adapter = WordAdapter().apply {
        onItemClickListener = this@FavoriteFragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.words.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    override fun setupView() {
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.recyclerview.apply {
            this.adapter = this@FavoriteFragment.adapter
            layoutManager = GridLayoutManager(activity, 2)
            addItemDecoration(GridSpacingItemDecoration(2, 20, true))
        }
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
        }
    }

    companion object {
        const val TAG = "FavoriteFragment"
    }
}