package com.monta.learnjpn5.adapter

import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.monta.learnjpn5.model.Character
import com.monta.learnjpn5.ui.fragment.character.CharacterFragment
import java.util.*

class AlphabetPagerAdapter(fragmentManager: FragmentManager, lifeCycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifeCycle) {

    override fun getItemCount() = 2

    override fun createFragment(position: Int) = when (position) {
        0 -> CharacterFragment().apply {
            arguments = Bundle().apply {
                putString(Character.TYPE_FIELD, Character.HIRAGANA_TYPE.toLowerCase(Locale.ROOT))
            }
        }
        else -> CharacterFragment().apply {
            arguments = Bundle().apply {
                putString(Character.TYPE_FIELD, Character.KATAKANA_TYPE.toLowerCase(Locale.ROOT))
            }
        }
    }
}

