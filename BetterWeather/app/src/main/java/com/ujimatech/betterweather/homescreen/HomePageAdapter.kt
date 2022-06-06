package com.ujimatech.betterweather.homescreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.ujimatech.betterweather.R
import com.ujimatech.betterweather.models.WeatherItemModel

class HomePageAdapter(
    var contentItemModels: ArrayList<WeatherItemModel>,
    val onDayWeatherClickedListener: OnDayWeatherClickListener
) :
    RecyclerView.Adapter<HomePageViewHolder>() {

    companion object {
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomePageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_forecast_list_item, parent, false)
        return HomePageViewHolder(view)
    }

    override fun onBindViewHolder(
        viewHolder: HomePageViewHolder,
        position: Int
    ) {
        contentItemModels[position].apply {
            viewHolder.forecastItemDayHighTemp.text = tempHigh
            viewHolder.forecastItemDayLowTemp.text = tempLow
            viewHolder.forecastItemDayOfWeek.text = dayName
            viewHolder.forecastItemDayOutlook.text = weatherOutlook
            viewHolder.forecastItemIcon.setImageDrawable(icon)
            viewHolder.humidity.text = humidity
            viewHolder.pressure.text = pressure
            viewHolder.wind.text = wind
        }
    }

    override fun getItemCount(): Int {
        return contentItemModels.size
    }
}

class HomePageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val forecastItemIcon: AppCompatImageView = view.findViewById(R.id.forecastItemIcon)
    val forecastItemDayOfWeek: TextView = view.findViewById(R.id.forecastItemDayOfWeek)
    val forecastItemDayHighTemp: TextView = view.findViewById(R.id.forecastItemDayHighTemp)
    val forecastItemDayOutlook: TextView = view.findViewById(R.id.forecastItemDayOutlook)
    val forecastItemDayLowTemp: TextView = view.findViewById(R.id.forecastItemDayLowTemp)
    val humidity: TextView = view.findViewById(R.id.humidity)
    val pressure: TextView = view.findViewById(R.id.pressure)
    val wind: TextView = view.findViewById(R.id.wind)
    val container: View = view.findViewById(R.id.forecastItemContainer)

    fun showExpanded() {
        humidity.visibility = View.VISIBLE
        pressure.visibility = View.VISIBLE
        wind.visibility = View.VISIBLE
    }

    fun hideExpanded() {
        humidity.visibility = View.GONE
        pressure.visibility = View.GONE
        wind.visibility = View.GONE
    }
}

interface OnDayWeatherClickListener {
    fun itemClicked()
}