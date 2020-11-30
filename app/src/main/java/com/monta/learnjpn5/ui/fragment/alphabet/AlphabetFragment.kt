package com.monta.learnjpn5.ui.fragment.alphabet

import androidx.fragment.app.viewModels
import com.google.android.material.tabs.TabLayoutMediator
import com.monta.learnjpn5.R
import com.monta.learnjpn5.adapter.AlphabetPagerAdapter
import com.monta.learnjpn5.base.BaseFragment
import com.monta.learnjpn5.databinding.FragmentAlphabetBinding
import com.monta.learnjpn5.model.Character

class AlphabetFragment : BaseFragment<FragmentAlphabetBinding, AlphabetViewModel>() {

    override val resLayoutId: Int = R.layout.fragment_alphabet

    override val viewModel by viewModels<AlphabetViewModel> { getViewModelFactory() }

    override fun setupView() {
        setToolbar(binding.toolbar)
        displayUpButton(true)
        setupPager()
    }

    private fun setupPager() {
        binding.viewpager.apply {
            adapter = AlphabetPagerAdapter(childFragmentManager, lifecycle)
            offscreenPageLimit = 2
        }
        TabLayoutMediator(
            binding.tablayout, binding.viewpager
        ) { tab, position ->
            when (position) {
                0 -> tab.text = Character.HIRAGANA_TYPE
                else -> tab.text = Character.KATAKANA_TYPE
            }
        }
            .attach()
    }

    companion object {
        const val TAG = "AlphabetFragment"
    }
}