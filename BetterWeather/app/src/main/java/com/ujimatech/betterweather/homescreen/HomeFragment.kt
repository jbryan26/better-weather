package com.ujimatech.betterweather.homescreen

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.ujimatech.betterweather.R
import com.ujimatech.betterweather.databinding.FragmentHomeBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.math.roundToInt

class HomeFragment: Fragment() {
    private val viewModel: HomeScreenViewModel by viewModel()
    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: HomePageAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("CheckResult")
    override fun onResume() {
        super.onResume()
        viewModel.refreshWeatherData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                 it.body()?.let { weatherMapResponse ->
                     viewModel.updateWeatherData(weatherMapResponse.list)
                     viewModel.getWeatherDataList().first().apply {
                         binding.cityName.text = weatherMapResponse.city.name
                         binding.forecastIcon.setImageDrawable(requireActivity().getDrawable(iconId))
                         binding.forecastTextView.text = weatherOutlook
                         binding.tempTextView.text = dayTemp
                         binding.feelsLikeTextView.text = String.format(getString(R.string.feels_like_template), weatherMapResponse.list.first().feelsLike.day.roundToInt())
                     }
                     adapter = HomePageAdapter(viewModel.getWeatherDataList(), object:OnDayWeatherClickListener {
                         override fun itemClicked() {

                         }
                     })
                     binding.forecastRecyclerView.adapter = adapter
                 }
            },{
                Snackbar.make(
                    binding.forecastRecyclerView,
                    "Error loading data",
                    Snackbar.LENGTH_LONG
                ).show()
            })
    }
}