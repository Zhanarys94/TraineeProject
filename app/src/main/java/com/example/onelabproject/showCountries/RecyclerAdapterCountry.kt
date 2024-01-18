package com.example.onelabproject.showCountries

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.onelabproject.R

class RecyclerAdapterCountry : ListAdapter<CountryImpl, RecyclerAdapterCountry.CountryViewHolder>(
    CountryDiffUtil
) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerAdapterCountry.CountryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CountryViewHolder(inflater.inflate(R.layout.list_item_country, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerAdapterCountry.CountryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class CountryViewHolder(private val view: View) : ViewHolder(view) {
        fun bind(country: CountryImpl) {
            val countryName = view.findViewById<TextView>(R.id.countryItemName)
            val countryFlagImage = view.findViewById<ImageView>(R.id.countryItemFlag)

            countryName.text = country.name
            countryFlagImage.load(country.flagImgUlr) {
                placeholder(R.drawable.loading_placeholder)
                crossfade(true)
            }
        }
    }
}

object CountryDiffUtil : DiffUtil.ItemCallback<CountryImpl>() {
    override fun areItemsTheSame(oldItem: CountryImpl, newItem: CountryImpl): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: CountryImpl, newItem: CountryImpl): Boolean {
        return oldItem == newItem
    }

}