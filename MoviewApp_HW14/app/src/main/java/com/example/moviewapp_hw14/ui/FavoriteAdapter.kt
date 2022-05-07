package com.example.moviewapp_hw14.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviewapp_hw14.R
import com.example.moviewapp_hw14.data.model.FilmState
import com.example.moviewapp_hw14.databinding.FavoriteItemBinding
import com.example.moviewapp_hw14.network.glide

class FavoriteAdapter(private val favoriteList : MutableList<FilmState>)
    : RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>(){

    class FavoriteViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView){
        private val binding = FavoriteItemBinding.bind(itemView)
        fun bind(film: FilmState){
            binding.ivPicFavorite.glide(film.urlImage)
            binding.tvFavorite.text = film.name
            binding.ivPicLike.setImageResource(R.drawable.ic_baseline_favorite_24)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.favorite_item, parent, false)
        return FavoriteViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bind(favoriteList[position])
    }

    override fun getItemCount(): Int {
        return favoriteList.size
    }
}