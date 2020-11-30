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