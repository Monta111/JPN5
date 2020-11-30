package com.monta.learnjpn5.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.activityViewModels
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.monta.learnjpn5.BR
import com.monta.learnjpn5.ui.ShareViewModel

abstract class BaseBottomSheetDialogFragment<B : ViewDataBinding> : BottomSheetDialogFragment() {

    lateinit var binding: B

    abstract val resLayoutId: Int

    val shareViewModel by activityViewModels<ShareViewModel> { getViewModelFactory() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, resLayoutId, container, false)
        binding.setVariable(BR.shareVM, shareViewModel)
        binding.setVariable(BR.listener, this)
        setupView()
        return binding.root
    }

    open fun setupView() {}

    fun getViewModelFactory() = (activity as BaseActivity).getViewModelFactory()
}