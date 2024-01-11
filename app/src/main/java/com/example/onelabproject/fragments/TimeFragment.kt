package com.example.onelabproject.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.onelabproject.CitiesList
import com.example.onelabproject.CityAndTimeViewModel
import com.example.onelabproject.databinding.ClockFragmentBinding

class TimeFragment : Fragment() {
    private var binding: ClockFragmentBinding? = null
    private val cityAndTimeViewModel: CityAndTimeViewModel by activityViewModels()
    private val cities = CitiesList.cities

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ClockFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val time = binding!!.textClockWidget
        cityAndTimeViewModel.cityLiveData.observe(viewLifecycleOwner) { cityName ->
            time.timeZone = cities[cityName]
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}