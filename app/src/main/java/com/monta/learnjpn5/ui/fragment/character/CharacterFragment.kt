package com.monta.learnjpn5.ui.fragment.character

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.monta.learnjpn5.R
import com.monta.learnjpn5.adapter.CharacterAdapter
import com.monta.learnjpn5.base.TextToSpeechFragment
import com.monta.learnjpn5.databinding.FragmentCharacterBinding
import com.monta.learnjpn5.model.Character
import com.monta.learnjpn5.util.GridSpacingItemDecoration

class CharacterFragment :
    TextToSpeechFragment<FragmentCharacterBinding, CharacterViewModel>(),
    CharacterAdapter.CharacterHolder.OnCharacterClickListener {

    override val resLayoutId: Int = R.layout.fragment_character

    override val viewModel by viewModels<CharacterViewModel> { getViewModelFactory() }

    private var adapter = CharacterAdapter().apply {
        onItemClickListener = this@CharacterFragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.getString(Character.TYPE_FIELD)?.let {
            viewModel.onSelectTypeAlphabet(it)
        }
        viewModel.characters.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    override fun setupView() {
        setupRecyclerView()
    }

    private fun setupRecyclerView() = binding.recyclerview.apply {
        this.adapter = this@CharacterFragment.adapter
        layoutManager = GridLayoutManager(activity, 5)
        addItemDecoration(GridSpacingItemDecoration(5, 10, true))
    }

    override fun onCharacterClick(text: String) {
        speakText(text)
        viewModel.onCharacterSelected(text)
    }
}