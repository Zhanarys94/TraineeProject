package com.example.onelabproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.onelabproject.databinding.ActivityMainBinding
import com.example.onelabproject.showCountries.RecyclerAdapterCountry

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val countriesViewModel: CountriesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        countriesViewModel.setDefaultCountries()

        val recyclerViewCountries = binding.mainActivityRecyclerView
        recyclerViewCountries.layoutManager = LinearLayoutManager(this)
        recyclerViewCountries.adapter = RecyclerAdapterCountry()
        recyclerViewCountries.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))


        countriesViewModel.countriesLiveData.observe(this) {
            (recyclerViewCountries.adapter as RecyclerAdapterCountry).submitList(it)
        }
    }
}