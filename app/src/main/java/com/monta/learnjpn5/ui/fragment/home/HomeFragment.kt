package com.monta.learnjpn5.ui.fragment.home

import androidx.fragment.app.viewModels
import com.monta.learnjpn5.R
import com.monta.learnjpn5.base.BaseFragment
import com.monta.learnjpn5.databinding.FragmentHomeBinding
import com.monta.learnjpn5.ui.fragment.alphabet.AlphabetFragment
import com.monta.learnjpn5.ui.fragment.favorite.FavoriteFragment
import com.monta.learnjpn5.ui.fragment.kanji.KanjiFragment
import com.monta.learnjpn5.ui.fragment.lesson.LessonFragment
import com.monta.learnjpn5.ui.fragment.quiz.QuizFragment

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override val resLayoutId: Int = R.layout.fragment_home

    override val viewModel by viewModels<HomeViewModel> { getViewModelFactory() }

    fun goToAlphabet() =
        replaceFragment(AlphabetFragment(), R.id.fragment_container, true, AlphabetFragment.TAG)

    fun goToLesson() =
        replaceFragment(LessonFragment(), R.id.fragment_container, true, LessonFragment.TAG)

    fun goToFavorite() =
        replaceFragment(FavoriteFragment(), R.id.fragment_container, true, FavoriteFragment.TAG)

    fun goToKanji() =
        replaceFragment(KanjiFragment(), R.id.fragment_container, true, KanjiFragment.TAG)

    fun goToQuiz() =
        replaceFragment(QuizFragment(), R.id.fragment_container, true, QuizFragment.TAG)

    companion object {
        const val TAG = "HomeFragment"
    }
}