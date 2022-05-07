package com.example.moviewapp_hw14.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviewapp_hw14.R
import com.example.moviewapp_hw14.data.model.FilmState
import com.example.moviewapp_hw14.databinding.FavoriteItemBinding
import com.example.moviewapp_hw14.network.glide

class HomeAdapter(private val movieList: MutableList<FilmState>, private val filmClick: FilmClick)
    : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>()
{
   inner class HomeViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
        private val binding = FavoriteItemBinding.bind(itemView)
        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(p0: View?) {
            filmClick.click(adapterPosition)
        }

        fun setMovie(film: FilmState){
            binding.ivPicFavorite.glide(film.urlImage)
            binding.tvFavorite.text = film.name
            if (film.liked) {
                binding.ivPicLike.setImageResource(R.drawable.ic_baseline_favorite_24)
            }
            else {
                binding.ivPicLike.setImageResource(R.drawable.ic_baseline_favorite_border_24)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.home_item, parent,false)
        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.setMovie(movieList[position])
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}
interface FilmClick{
    fun click(position : Int)
}