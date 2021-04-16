package com.example.messager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import com.example.messager.ui.LogInFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .add(android.R.id.content, LogInFragment(), "LogInFragment").commit()

        buttonNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.miSetting -> this.findNavController(R.id.fragment)
                    .navigate(R.id.action_homeFragment_to_settingFragment2)
            }
            true
        }
    }

    fun toggleNavigation(isHideNavigation: Boolean) {
        buttonNavigationView.visibility = if (isHideNavigation) View.GONE else View.VISIBLE
    }
}