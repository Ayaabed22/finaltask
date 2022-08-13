package com.example.application.Ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.navigation.fragment.NavHostFragment
import com.example.application.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()

    }


    private fun initView() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navgraph) as NavHostFragment
        val inflater = navHostFragment.navController.navInflater
        var controller = navHostFragment.navController
        controller.navigate(R.id.loginFragment)
    }
}




