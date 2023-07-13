package com.example.userapi.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.userapi.databinding.ItemRcvUserBinding
import com.example.userapi.model.Results
import com.example.userapi.model.User

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    private var listUser : ArrayList<User> = ArrayList()
    class UserViewHolder(var binding: ItemRcvUserBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ItemRcvUserBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return UserViewHolder(binding)
    }
    override fun getItemCount(): Int {
        return listUser.size
    }
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = listUser[position]
        Glide.with(holder.binding.imgThum).load(user.picture?.medium).into(holder.binding.imgThum)
        holder.binding.tvName.text = "${user.name?.title}.${user.name?.last} ${user.name?.first}"
        holder.binding.tvUsername.text = "@" + user.login?.username
    }
    fun setData(results: Results){
        listUser = results.results!!
    }
}
