package com.example.movieapp.ui

import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.movieapp.R
import com.example.movieapp.databinding.ActivityMainBinding
import com.example.movieapp.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeActivity : BaseActivity<ActivityMainBinding>(){
    private var binding: ActivityMainBinding? = null
    private var navController : NavController ? = null

    override val layoutId: Int
        get() = R.layout.activity_main

    override fun activityCreated() {
        binding = viewDataBinding
        setUpNavigation()
    }

    private fun setUpNavigation(){
        setSupportActionBar(binding?.toolbar)
        setTitle(R.string.app_name)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment?
        navController = navHostFragment?.navController
    }


}