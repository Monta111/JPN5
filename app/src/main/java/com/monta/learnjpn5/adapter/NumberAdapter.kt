package com.monta.learnjpn5.adapter

import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import com.monta.learnjpn5.R
import com.monta.learnjpn5.base.BaseAdapter
import com.monta.learnjpn5.databinding.ItemNumberBinding

class NumberAdapter : BaseAdapter<String, ItemNumberBinding>() {

    override val resItemLayout = R.layout.item_number

    override val differ = AsyncListDiffer(this, object : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    })

    class NumberHolder(override val binding: ItemNumberBinding) :
        BaseViewHolder<ItemNumberBinding>(binding)
}