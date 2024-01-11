package com.example.onelabproject

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CityAndTimeViewModel : ViewModel() {
    private val _isCityToTimeSwitcherActive: MutableLiveData<Boolean> = MutableLiveData(false)
    val isCityToTimeSwitcherActive = _isCityToTimeSwitcherActive

    private val _cityLiveData = MutableLiveData<String>()
    val cityLiveData = _cityLiveData

    fun switchCityToTimeSwitcher() {
        _isCityToTimeSwitcherActive.value = !_isCityToTimeSwitcherActive.value!!
    }

    fun setCity(city: String) {
        _cityLiveData.value = city
    }
}