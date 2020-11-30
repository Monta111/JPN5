package com.monta.learnjpn5.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.monta.learnjpn5.ViewModelFactory
import com.monta.learnjpn5.di.ViewModelKey
import com.monta.learnjpn5.ui.ShareViewModel
import com.monta.learnjpn5.ui.fragment.alphabet.AlphabetViewModel
import com.monta.learnjpn5.ui.fragment.character.CharacterViewModel
import com.monta.learnjpn5.ui.fragment.favorite.FavoriteViewModel
import com.monta.learnjpn5.ui.fragment.grammar.GrammarViewModel
import com.monta.learnjpn5.ui.fragment.home.HomeViewModel
import com.monta.learnjpn5.ui.fragment.kanji.KanjiViewModel
import com.monta.learnjpn5.ui.fragment.lesson.LessonViewModel
import com.monta.learnjpn5.ui.fragment.luachon.LuachonViewModel
import com.monta.learnjpn5.ui.fragment.mina.MinaViewModel
import com.monta.learnjpn5.ui.fragment.quiz.QuizViewModel
import com.monta.learnjpn5.ui.fragment.quizdetail.QuizDetailViewModel
import com.monta.learnjpn5.ui.fragment.word.WordViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun viewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ShareViewModel::class)
    abstract fun shareViewModel(viewModel: ShareViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun homeViewModel(viewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AlphabetViewModel::class)
    abstract fun alphabetViewModel(viewModel: AlphabetViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CharacterViewModel::class)
    abstract fun characterViewModel(viewModel: CharacterViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LessonViewModel::class)
    abstract fun lessonViewModel(viewModel: LessonViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MinaViewModel::class)
    abstract fun minaViewModel(viewModel: MinaViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(WordViewModel::class)
    abstract fun wordViewModel(viewModel: WordViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(GrammarViewModel::class)
    abstract fun grammarViewModel(viewModel: GrammarViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FavoriteViewModel::class)
    abstract fun favoriteViewModel(viewModel: FavoriteViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(KanjiViewModel::class)
    abstract fun kanjiViewModel(viewModel: KanjiViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(QuizViewModel::class)
    abstract fun quizViewModel(viewModel: QuizViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(QuizDetailViewModel::class)
    abstract fun quizDetailViewModel(viewModel: QuizDetailViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LuachonViewModel::class)
    abstract fun luachonViewModel(viewModel: LuachonViewModel): ViewModel
}