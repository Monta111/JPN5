package com.monta.learnjpn5.adapter

import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import com.monta.learnjpn5.R
import com.monta.learnjpn5.base.BaseAdapter
import com.monta.learnjpn5.databinding.ItemWordBinding
import com.monta.learnjpn5.model.Word

class WordAdapter : BaseAdapter<Word, ItemWordBinding>() {

    override val resItemLayout = R.layout.item_word

    override val differ = AsyncListDiffer(this, object : DiffUtil.ItemCallback<Word>() {
        override fun areItemsTheSame(oldItem: Word, newItem: Word) =
            oldItem.word == newItem.word

        override fun areContentsTheSame(oldItem: Word, newItem: Word) =
            oldItem == newItem
    })

    override fun submitList(data: List<Word>) {
        super.submitList(data.map {
            it.copy()
        })
    }

    class WordHolder(override val binding: ItemWordBinding) :
        BaseViewHolder<ItemWordBinding>(binding) {

        interface OnWordClickListener : OnItemClickListener {
            fun onFavoriteClick(word: String)
            fun onSpeakerClick(word: String)
            fun onWordJapanClick(word: String)
            fun onWordVietnamClick(word: String)
        }
    }
}