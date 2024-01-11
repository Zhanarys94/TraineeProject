package com.example.onelabproject.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.onelabproject.CitiesList
import com.example.onelabproject.CityAndTimeViewModel
import com.example.onelabproject.R
import com.example.onelabproject.databinding.CityChooserFragmentBinding

class CityChooserFragment : Fragment() {
    private var binding: CityChooserFragmentBinding? = null
    private val cityAndTimeViewModel: CityAndTimeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CityChooserFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val spinner = binding!!.citiesSpinner
        ArrayAdapter(
            requireContext(),
            R.layout.spinner_item,
            CitiesList.cities.map { it.key }
        ).also { adapter ->
            spinner.adapter = adapter
        }

        val listener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedCity = parent.getItemAtPosition(position) as String
                cityAndTimeViewModel.setCity(selectedCity)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        spinner.onItemSelectedListener = listener
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}