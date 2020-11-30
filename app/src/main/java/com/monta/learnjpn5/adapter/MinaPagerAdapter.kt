package com.monta.learnjpn5.adapter

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.monta.learnjpn5.ui.fragment.grammar.GrammarFragment
import com.monta.learnjpn5.ui.fragment.word.WordFragment

class MinaPagerAdapter(fm: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fm, lifecycle) {

    override fun getItemCount() = 2

    override fun createFragment(position: Int) = when (position) {
        0 -> WordFragment()
        else -> GrammarFragment()
    }
}