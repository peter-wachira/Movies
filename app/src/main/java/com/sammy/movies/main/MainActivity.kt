package com.sammy.movies.main

import android.os.Bundle
import com.sammy.movies.R
import dagger.android.support.DaggerAppCompatActivity
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.components.ApplicationComponent

@AndroidEntryPoint
class MainActivity : DaggerAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}