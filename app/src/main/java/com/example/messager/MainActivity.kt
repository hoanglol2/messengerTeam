package com.example.messager

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.messager.ui.LogInFragment
import com.example.messager.ui.call.CallFragment
import com.example.messager.ui.camera.CameraFragment
import com.example.messager.ui.home.HomeFragment
import com.example.messager.ui.setting.SettingFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .add(android.R.id.content, LogInFragment(), "LogInFragment").commit()

        val navigation = findViewById<View>(R.id.buttonNavigationView) as BottomNavigationView;
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            val fragment: Fragment
            when (item.itemId) {
                R.id.navigation_home -> {
                    fragment = HomeFragment();
                    loadFragment(fragment);
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_call -> {
                    fragment = CallFragment();
                    loadFragment(fragment);
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_camera -> {
                    fragment = CameraFragment();
                    loadFragment(fragment);
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_setting -> {
                    fragment = SettingFragment();
                    loadFragment(fragment);
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    private fun loadFragment(fragment: Fragment) {
        // load fragment
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.nav_host_fragment, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}