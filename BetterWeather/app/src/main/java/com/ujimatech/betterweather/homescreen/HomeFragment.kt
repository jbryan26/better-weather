package com.ujimatech.betterweather.homescreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ujimatech.betterweather.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

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
        viewModel.getSampleData().let {
            adapter = HomePageAdapter(it, object:OnDayWeatherClickListener {
                override fun itemClicked() {

                }
            })
            binding.forecastRecyclerView.adapter = adapter
        }
        return binding.root
    }
}