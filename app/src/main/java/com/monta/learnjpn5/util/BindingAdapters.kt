package com.monta.learnjpn5.util

import android.webkit.WebView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.monta.learnjpn5.R

@BindingAdapter("content")
fun setWebContent(view: WebView, content: String) {
    view.loadDataWithBaseURL(null, content, "text/html", "utf-8", null)
}

@BindingAdapter("selected_topic")
fun isSelectedTopic(view: TextView, selected: Boolean) {
    if (selected) {
        view.setBackgroundColor(ContextCompat.getColor(view.context, R.color.colorAccent))
        view.setTextColor(ContextCompat.getColor(view.context, R.color.colorWhite))
    } else {
        view.setBackgroundColor(ContextCompat.getColor(view.context, R.color.colorWhite))
        view.setTextColor(ContextCompat.getColor(view.context, R.color.textColorSecondary))
    }
}

@BindingAdapter("choice_background")
fun setChoiceBackground(view: TextView, status: Int) {
    when (status) {
        1 -> {
            view.setTextColor(ContextCompat.getColor(view.context, R.color.colorWhite))
            view.setBackgroundResource(R.drawable.choice_quiz_background_correct)
            view.setCompoundDrawablesRelativeWithIntrinsicBounds(
                null,
                null,
                ContextCompat.getDrawable(view.context, R.drawable.ic_check),
                null
            )
        }
        0 -> {
            view.setBackgroundResource(R.drawable.choice_quiz_background_wrong)
            view.setCompoundDrawablesRelativeWithIntrinsicBounds(
                null,
                null,
                ContextCompat.getDrawable(view.context, R.drawable.ic_close),
                null
            )
        }
        else -> view.setBackgroundResource(R.drawable.choice_quiz_background)
    }
}