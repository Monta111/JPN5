package com.monta.learnjpn5.ui.dialog

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.monta.learnjpn5.R
import com.monta.learnjpn5.adapter.NumberAdapter
import com.monta.learnjpn5.base.BaseBottomSheetDialogFragment
import com.monta.learnjpn5.databinding.DialogNumberQuizBinding
import com.monta.learnjpn5.util.ZoomCenterLayoutManager

class NumberQuizSelectionDialog : BaseBottomSheetDialogFragment<DialogNumberQuizBinding>() {

    override val resLayoutId = R.layout.dialog_number_quiz

    override fun setupView() {
        super.setupView()
        dialog?.setCanceledOnTouchOutside(true)
        setupRecyclerView()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        shareViewModel.numberOfQuiz.value?.let {
            binding.recyclerview.scrollToPosition(it - 1)
        }
    }

    private fun setupRecyclerView() = binding.recyclerview.apply {
        val snapHelper = LinearSnapHelper()
        layoutManager = ZoomCenterLayoutManager(activity as Context)
        adapter = NumberAdapter().apply {
            submitList(List(54) {
                if (it < 2 || it > 51)
                    ""
                else
                    (it - 1).toString()
            })
        }
        snapHelper.attachToRecyclerView(this)
        addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    snapHelper.findSnapView(layoutManager)?.let {
                        shareViewModel.numberOfQuiz.value =
                            (layoutManager as ZoomCenterLayoutManager).getPosition(it) - 1
                    }
                }
            }
        })
    }

}