package com.example.onelabproject

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.onelabproject.showCountries.CountriesData
import com.example.onelabproject.showCountries.CountryImpl

class CountriesViewModel : ViewModel() {
    private val _countriesMutableLiveData = MutableLiveData<List<CountryImpl>>()
    val countriesLiveData = _countriesMutableLiveData

    fun changeList(countries: List<CountryImpl>) {
        _countriesMutableLiveData.value = countries
    }

    fun setDefaultCountries() {
        if (_countriesMutableLiveData.value == null) {
            val countries = CountriesData.countriesToImgMap
            _countriesMutableLiveData.value = countries.map {
                CountryImpl(it.key, it.value)
            }
        }
    }
}