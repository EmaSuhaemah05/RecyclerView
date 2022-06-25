package com.EmaSuhaemah.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.EmaSuhaemah.recyclerview.databinding.ActivityMainBinding
import com.EmaSuhaemah.recyclerview.model.Pemain

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}