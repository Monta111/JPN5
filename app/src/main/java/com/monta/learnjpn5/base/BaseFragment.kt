package com.monta.learnjpn5.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModel
import com.monta.learnjpn5.BR
import com.monta.learnjpn5.R
import com.monta.learnjpn5.ui.ShareViewModel

abstract class BaseFragment<B : ViewDataBinding, T : ViewModel> : Fragment() {

    lateinit var binding: B

    abstract val resLayoutId: Int
    abstract val viewModel: T

    val shareViewModel by activityViewModels<ShareViewModel> { getViewModelFactory() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, resLayoutId, container, false)
        bind()
        setupView()
        return binding.root
    }

    open fun setupView() {}

    private fun bind() {
        binding.setVariable(BR.shareVM, shareViewModel)
        binding.setVariable(BR.viewModel, viewModel)
        binding.setVariable(BR.listener, this)
        binding.lifecycleOwner = this
    }

    fun addFragment(
        fragment: Fragment,
        containerViewId: Int,
        addToBackStack: Boolean,
        tag: String
    ) =
        (activity as BaseActivity).addFragment(fragment, containerViewId, addToBackStack, tag)

    fun replaceFragment(
        fragment: Fragment,
        containerViewId: Int,
        addToBackStack: Boolean,
        tag: String
    ) =
        (activity as BaseActivity).replaceFragment(fragment, containerViewId, addToBackStack, tag)

    fun addChildFragment(
        fragment: Fragment,
        containerViewId: Int,
        tag: String
    ) =
        childFragmentManager.commit {
            setCustomAnimations(
                R.anim.slide_in_right,
                R.anim.slide_out_left,
                R.anim.slide_in_left,
                R.anim.slide_out_right
            )
            add(containerViewId, fragment, tag)
        }

    fun replaceChildFragment(
        fragment: Fragment,
        containerViewId: Int,
        tag: String
    ) =
        childFragmentManager.commit {
            setCustomAnimations(
                R.anim.slide_in_right,
                R.anim.slide_out_left,
                R.anim.slide_in_left,
                R.anim.slide_out_right
            )
            replace(containerViewId, fragment, tag)
        }

    fun findFragmentByTag(tag: String) = (activity as? BaseActivity)?.findFragmentByTag(tag)

    fun setToolbar(toolbar: Toolbar) {
        (activity as? BaseActivity)?.setSupportActionBar(toolbar)
        (activity as? BaseActivity)?.supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    fun displayUpButton(enabled: Boolean) =
        (activity as? BaseActivity)?.supportActionBar?.setDisplayHomeAsUpEnabled(enabled)

    fun onBackPressed() = activity?.onBackPressed()

    fun getViewModelFactory() = (activity as BaseActivity).getViewModelFactory()
}