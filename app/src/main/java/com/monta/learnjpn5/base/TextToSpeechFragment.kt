package com.monta.learnjpn5.base

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Toast
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import java.util.*

abstract class TextToSpeechFragment<B : ViewDataBinding, T : ViewModel> : BaseFragment<B, T>(),
    TextToSpeech.OnInitListener {

    private lateinit var tts: TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onCreateTextToSpeech()
    }

    private fun onCreateTextToSpeech() {
        tts = TextToSpeech(activity?.applicationContext, this)
    }

    override fun onInit(status: Int) = when (status) {
        TextToSpeech.SUCCESS -> configureTextToSpeech()
        else -> {
            Toast.makeText(activity, "Text to speech error!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun configureTextToSpeech() {
        tts.apply {
            language = Locale.JAPAN
            setSpeechRate(0.5f)
        }
    }


    fun speakText(text: String) {
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, UUID.randomUUID().toString())
    }

    override fun onDestroy() {
        super.onDestroy()
        tts.shutdown()
    }
}