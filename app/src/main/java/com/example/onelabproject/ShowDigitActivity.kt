package com.example.onelabproject

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.onelabproject.databinding.ShowDigitBinding
import com.example.onelabproject.viewModels.showDigitActivityViewModel

private const val TAG = "ShowDigitActivity"
class ShowDigitActivity: AppCompatActivity() {
    private lateinit var binding: ShowDigitBinding
    private val digitActivityViewModel: showDigitActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ShowDigitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textViewShowDigit.text = digitActivityViewModel.currentDigitLiveData.value!!.toString()
        digitActivityViewModel.currentDigitLiveData.observe(this) {digit ->
            binding.textViewShowDigit.text = digit.toString()
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        Log.d(TAG, "Configuration has been changed")
        super.onConfigurationChanged(newConfig)
        digitActivityViewModel.incrementByOne()
        Log.d(TAG, "Number has been increased by 1")
    }
}