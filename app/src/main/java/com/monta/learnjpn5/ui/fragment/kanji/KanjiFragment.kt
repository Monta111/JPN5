package com.monta.learnjpn5.ui.fragment.kanji

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.monta.learnjpn5.R
import com.monta.learnjpn5.adapter.KanjiAdapter
import com.monta.learnjpn5.base.TextToSpeechFragment
import com.monta.learnjpn5.databinding.FragmentKanjiBinding
import kotlin.math.abs
import kotlin.math.max

class KanjiFragment : TextToSpeechFragment<FragmentKanjiBinding, KanjiViewModel>(),
    KanjiAdapter.KanjiHolder.OnKanjiClickListener {

    override val resLayoutId = R.layout.fragment_kanji

    override val viewModel by viewModels<KanjiViewModel> { getViewModelFactory() }

    private val adapter = KanjiAdapter().apply {
        onItemClickListener = this@KanjiFragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.kanjis.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    override fun setupView() {
        setToolbar(binding.toolbar)
        displayUpButton(true)
        setupPager()
    }

    private fun setupPager() = binding.viewpager.apply {
        this.adapter = this@KanjiFragment.adapter
        offscreenPageLimit = 2
        orientation = ViewPager2.ORIENTATION_HORIZONTAL
        registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                viewModel.onPageSelected(position)
            }
        })
        setPageTransformer { page, position ->
            val pageMargin = resources.getDimensionPixelOffset(R.dimen.page_margin)
            val pageOffset = resources.getDimensionPixelOffset(R.dimen.offset)
            val offset = position * (-(2 * pageOffset + pageMargin))
            when {
                position < -1 -> page.translationX = -offset
                position <= 1 -> {
                    val scaleFactor = max(0.9f, 1 - abs(position))
                    page.translationX = offset
                    page.scaleY = scaleFactor
                }
                else -> page.translationX = offset
            }
        }
    }

    override fun onSpeakerClick(word: String) {
        speakText(word)
    }

    companion object {
        const val TAG = "KanjiFragment"
    }
}