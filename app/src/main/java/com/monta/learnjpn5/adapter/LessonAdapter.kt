package com.monta.learnjpn5.adapter

import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import com.monta.learnjpn5.R
import com.monta.learnjpn5.base.BaseAdapter
import com.monta.learnjpn5.databinding.ItemLessonBinding

class LessonAdapter : BaseAdapter<String, ItemLessonBinding>() {

    override val resItemLayout = R.layout.item_lesson

    override val differ: AsyncListDiffer<String> =
        AsyncListDiffer(this, object : DiffUtil.ItemCallback<String>() {
            override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }
        })

    class LessonHolder(override val binding: ItemLessonBinding) :
        BaseViewHolder<ItemLessonBinding>(binding) {

        interface OnLessonClickListener : OnItemClickListener {
            fun onLessonClick(lesson: String)
        }
    }
}