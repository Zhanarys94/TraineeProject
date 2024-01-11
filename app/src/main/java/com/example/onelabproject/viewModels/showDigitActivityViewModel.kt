package com.example.onelabproject.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class showDigitActivityViewModel: ViewModel() {
    private val _currentDigitLiveData: MutableLiveData<Int> = MutableLiveData(0)
    val currentDigitLiveData = _currentDigitLiveData

    fun incrementByOne() {
        _currentDigitLiveData.value = _currentDigitLiveData.value!! + 1
    }
}