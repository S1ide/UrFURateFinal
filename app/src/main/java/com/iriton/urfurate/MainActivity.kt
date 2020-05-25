package com.iriton.urfurate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createBottomView()
    }

    fun createBottomView()
    {
        val fragmentManager = supportFragmentManager;
        val trans = fragmentManager.beginTransaction().replace(R.id.main_container, ProfileFragment())
        trans.commit()
        var fragment = Fragment()
        bottom_navigation.setOnNavigationItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.navigation_profile -> fragment = ProfileFragment()
                R.id.navigation_meet -> fragment = MeetFragment()
                R.id.navigation_settings -> fragment = SettingsFragment()
            }
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.main_container, fragment).commit()
            return@setOnNavigationItemSelectedListener true
        }

    }
}
