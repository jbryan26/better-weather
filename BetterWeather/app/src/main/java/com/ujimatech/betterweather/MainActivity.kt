package com.ujimatech.betterweather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ujimatech.betterweather.homescreen.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setIcon(R.drawable.ic_menu)
        supportActionBar?.setTitle(R.string.toolbar_name)
        if (savedInstanceState == null) {
            val fragment = HomeFragment()
            supportFragmentManager.beginTransaction().setReorderingAllowed(true).add(R.id.fragmentContainer, fragment, "homeFragment").commit()
        }
    }
}