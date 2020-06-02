package com.iriton.urfurate

import MeetAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_meet.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val USER_KEY = "USER_KEY"
    }


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
