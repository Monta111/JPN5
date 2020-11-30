package com.monta.learnjpn5.ui.fragment.mina

import androidx.fragment.app.viewModels
import com.google.android.material.tabs.TabLayoutMediator
import com.monta.learnjpn5.R
import com.monta.learnjpn5.adapter.MinaPagerAdapter
import com.monta.learnjpn5.base.BaseFragment
import com.monta.learnjpn5.databinding.FragmentMinaBinding
import com.monta.learnjpn5.model.Grammar
import com.monta.learnjpn5.model.Word

class MinaFragment : BaseFragment<FragmentMinaBinding, MinaViewModel>() {

    override val resLayoutId = R.layout.fragment_mina

    override val viewModel by viewModels<MinaViewModel> { getViewModelFactory() }

    override fun setupView() {
        setupViewPager()
    }

    private fun setupViewPager() {
        binding.viewpager.apply {
            adapter = MinaPagerAdapter(childFragmentManager, lifecycle)
            offscreenPageLimit = 2
        }
        TabLayoutMediator(binding.tablayout, binding.viewpager) { tab, position ->
            when (position) {
                0 -> tab.text = Word.TAG
                else -> tab.text = Grammar.TAG
            }
        }.attach()
    }

    companion object {
        const val TAG = "MinaFragment"
    }
}