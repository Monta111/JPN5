package com.monta.learnjpn5.adapter

import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import com.monta.learnjpn5.R
import com.monta.learnjpn5.base.BaseAdapter
import com.monta.learnjpn5.databinding.ItemKanjiBinding
import com.monta.learnjpn5.model.Kanji

class KanjiAdapter : BaseAdapter<Kanji, ItemKanjiBinding>() {

    override val resItemLayout = R.layout.item_kanji

    override val differ = AsyncListDiffer(this, object : DiffUtil.ItemCallback<Kanji>() {
        override fun areItemsTheSame(oldItem: Kanji, newItem: Kanji) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Kanji, newItem: Kanji) =
            oldItem == newItem
    })

    override fun setItemClickListener(binding: ItemKanjiBinding) {
        super.setItemClickListener(binding)
        binding.root.setOnClickListener { binding.flipviewKanji.flipTheView() }
    }

    class KanjiHolder(override val binding: ItemKanjiBinding) :
        BaseViewHolder<ItemKanjiBinding>(binding) {

        interface OnKanjiClickListener : OnItemClickListener {
            fun onSpeakerClick(word: String)
        }
    }
}