package com.sftech.onboarding_presentation.age

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sftech.core.domain.preferences.Preferences
import com.sftech.core.domain.use_case.FilterOutDigits
import com.sftech.core.navigation.Route
import com.sftech.core.util.UiEvent
import com.sftech.core.util.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AgeViewModel @Inject constructor(
    private val preferences: Preferences,
    private val filterOutDigits: FilterOutDigits
) : ViewModel() {


    var age by mutableStateOf("20")
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()


    fun onAgeEnter(age: String) {
        if (age.length < 3) {
            this.age = filterOutDigits(age)
        }
    }

    fun onNextClick() {
        viewModelScope.launch {
            val ageNumber = age.toIntOrNull() ?: run {
                _uiEvent.send(
                    UiEvent.ShowSnackBar(
                        UiText.StringResource(com.sftech.core.R.string.error_age_cant_be_empty)
                    )
                )
                return@launch
            }
            preferences.saveAge(age = ageNumber)
            _uiEvent.send(UiEvent.Navigate(Route.HEIGHT))
        }

    }

}