package com.example.userapi.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.userapi.api.ApiService
import com.example.userapi.model.Results
import com.example.userapi.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel: ViewModel() {
    private var data: MutableLiveData<Results> = MutableLiveData()
    fun getListUserApi() : MutableLiveData<Results>{
        ApiService.apiService.getUser(20).enqueue(object : Callback<Results>{
            override fun onResponse(call: Call<Results>, response: Response<Results>) {
                val results : Results? = response.body()
                data.value = results
            }

            override fun onFailure(call: Call<Results>, t: Throwable) {
                Log.e("api","call error")
            }
        })
        return data
    }
}