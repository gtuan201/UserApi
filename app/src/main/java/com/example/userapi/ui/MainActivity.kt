package com.example.userapi.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.userapi.databinding.ActivityMainBinding
import com.example.userapi.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: UserAdapter
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val viewModel = ViewModelProvider(this)[UserViewModel::class.java]
        binding.rcvUser.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        viewModel.getListUserApi().observe(this){
            adapter = UserAdapter()
            adapter.setData(it)
            binding.rcvUser.adapter = adapter
            adapter.notifyDataSetChanged()
        }
        setContentView(binding.root)
    }
}