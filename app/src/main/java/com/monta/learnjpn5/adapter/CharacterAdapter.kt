package com.monta.learnjpn5.adapter

import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import com.monta.learnjpn5.R
import com.monta.learnjpn5.base.BaseAdapter
import com.monta.learnjpn5.databinding.ItemCharacterBinding
import com.monta.learnjpn5.model.Character

class CharacterAdapter : BaseAdapter<Character, ItemCharacterBinding>() {

    override val resItemLayout = R.layout.item_character

    override val differ: AsyncListDiffer<Character> =
        AsyncListDiffer(this, object : DiffUtil.ItemCallback<Character>() {
            override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
                return oldItem == newItem
            }
        })

    override fun submitList(data: List<Character>) {
        super.submitList(data.map {
            it.copy()
        })
    }

    class CharacterHolder(override val binding: ItemCharacterBinding) :
        BaseViewHolder<ItemCharacterBinding>(binding) {

        interface OnCharacterClickListener : OnItemClickListener {
            fun onCharacterClick(text: String)
        }
    }
}