package com.monta.learnjpn5.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.monta.learnjpn5.BR

abstract class BaseAdapter<T, B : ViewDataBinding> :
    RecyclerView.Adapter<BaseAdapter.BaseViewHolder<B>>() {

    abstract val resItemLayout: Int

    abstract val differ: AsyncListDiffer<T>

    var onItemClickListener: BaseViewHolder.OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        BaseViewHolder<B>(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                resItemLayout,
                parent,
                false
            )
        ).apply { setItemClickListener(binding) }

    override fun onBindViewHolder(holder: BaseViewHolder<B>, position: Int) {
        holder.binding.setVariable(BR.item, differ.currentList[position])
    }

    override fun getItemCount(): Int = differ.currentList.size

    open fun submitList(data: List<T>) {
        differ.submitList(data)
    }

    open fun setItemClickListener(binding: B) {
        binding.setVariable(BR.listener, onItemClickListener)
    }

    open class BaseViewHolder<B : ViewDataBinding>(open val binding: B) :
        RecyclerView.ViewHolder(binding.root) {

        interface OnItemClickListener
    }
}