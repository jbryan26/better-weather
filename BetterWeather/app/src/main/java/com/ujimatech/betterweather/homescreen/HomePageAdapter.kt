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
            val context = viewHolder.container.context
            viewHolder.forecastItemDayHighTemp.text = String.format(context.getString(R.string.high_temp_string_template), tempHigh)
            viewHolder.forecastItemDayLowTemp.text = String.format(context.getString(R.string.low_temp_string_template), tempLow)
            viewHolder.forecastItemDayOfWeek.text = dayName
            viewHolder.forecastItemDayOutlook.text = weatherOutlook
            viewHolder.forecastItemIcon.setImageDrawable(context.getDrawable(iconId))
            viewHolder.humidity.text = String.format(context.getString(R.string.humidity_string_template), humidity)
            viewHolder.pressure.text = String.format(context.getString(R.string.pressure_string_template), pressure)
            viewHolder.wind.text = String.format(context.getString(R.string.wind_string_template), windSpeed, windDirection)

            if (isExpanded) {
                viewHolder.showExpanded()
            } else {
                viewHolder.hideExpanded()
            }

            viewHolder.container.setOnClickListener {
                this.isExpanded = !this.isExpanded
                if (isExpanded) {
                    viewHolder.showExpanded()
                } else {
                    viewHolder.hideExpanded()
                }
            }
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