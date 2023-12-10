package com.example.onelabproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.onelabproject.databinding.ActivityMainBinding
import com.example.onelabproject.fragments.CityChooserFragment
import com.example.onelabproject.fragments.TimeFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val cityAndTimeViewModel: CityAndTimeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .add(binding.mainActivityFragmentContainer.id, CityChooserFragment(), "CityChooserFragment")
                .commit()
        }
        binding.switchCityToTime.setOnClickListener {
            cityAndTimeViewModel.switchCityToTimeSwitcher()
        }
        cityAndTimeViewModel.isCityToTimeSwitcherActive.observe(this) { isSwitcherActive ->
            when (isSwitcherActive) {
                true -> {
                    supportFragmentManager.beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(binding.mainActivityFragmentContainer.id, TimeFragment(), "TimeFragment")
                        .addToBackStack("TimeFragment")
                        .commit()
                }
                false -> {
                    supportFragmentManager.popBackStack("TimeFragment", 1)
                }
            }
        }
    }
}