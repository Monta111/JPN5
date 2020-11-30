package com.monta.learnjpn5.ui.fragment.character

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.monta.learnjpn5.base.BaseViewModel
import com.monta.learnjpn5.data.AlphabetRepository
import com.monta.learnjpn5.model.Character
import com.monta.learnjpn5.util.notifyObserver
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharacterViewModel @Inject constructor(private val repository: AlphabetRepository) :
    BaseViewModel() {

    var characters = MutableLiveData<List<Character>>()

    fun onSelectTypeAlphabet(type: String) {
        if (characters.value == null)
            getAlphabet(type)
    }

    private fun getAlphabet(type: String) = viewModelScope.launch(exceptionHandler) {
        characters.value = repository.getAlphabet(type)
        loading.value = false
    }

    fun onCharacterSelected(text: String) = viewModelScope.launch {
        characters.value?.find {
            it.character == text
        }?.apply {
            selected = true
            characters.notifyObserver()
            delay(2000)
            selected = false
            characters.notifyObserver()
        }
    }
}