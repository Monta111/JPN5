package com.monta.learnjpn5.ui.fragment.kanji

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.monta.learnjpn5.base.BaseViewModel
import com.monta.learnjpn5.data.KanjiRepository
import com.monta.learnjpn5.model.Kanji
import kotlinx.coroutines.launch
import javax.inject.Inject

class KanjiViewModel @Inject constructor(private val repository: KanjiRepository) :
    BaseViewModel() {
    var pageNumber = MutableLiveData<String>()

    var kanjis = MutableLiveData<List<Kanji>>()

    init {
        getKanjis()
    }

    fun onPageSelected(position: Int) {
        pageNumber.value = (position + 1).toString().plus("/").plus(kanjis.value?.size ?: 0)
    }

    private fun getKanjis() {
        viewModelScope.launch(exceptionHandler) {
            kanjis.value = repository.getKanjis()
            loading.value = false
        }
    }

}