package com.example.application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavInflater

import androidx.navigation.fragment.NavHostFragment




class MainActivity : AppCompatActivity() {
    lateinit var controller: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()

    }

    private fun initView() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
      val inflater = navHostFragment.navController.navInflater
        controller = navHostFragment.navController
        controller.navigate(R.id.homeFragment)
    }
}







