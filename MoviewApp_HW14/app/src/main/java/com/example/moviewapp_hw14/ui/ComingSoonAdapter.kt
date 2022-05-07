package com.example.moviewapp_hw14.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviewapp_hw14.R
import com.example.moviewapp_hw14.data.model.ComingSoon
import com.example.moviewapp_hw14.databinding.ComingsoonItemBinding
import com.example.moviewapp_hw14.network.glide

class ComingSoonAdapter(private val comingSoonList: List<ComingSoon>, private val share: ComingSoonFragment)
    : RecyclerView.Adapter<ComingSoonAdapter.ComingSoonViewHolder>(){

    inner class ComingSoonViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
        private val binding = ComingsoonItemBinding.bind(itemView)

        override fun onClick(p0: View?) {
            share.movieShare(adapterPosition)
        }
        init {
            itemView.setOnClickListener(this)
        }
        fun bind(comingSoon: ComingSoon){
            binding.ivPic.glide(comingSoon.url)
            binding.tvSubject.text = comingSoon.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComingSoonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.comingsoon_item, parent, false)
        return ComingSoonViewHolder(view)
    }

    override fun onBindViewHolder(holder: ComingSoonViewHolder, position: Int) {
        holder.bind(comingSoonList[position])
    }

    override fun getItemCount(): Int {
        return comingSoonList.size
    }

}
interface Share{
    fun movieShare(position : Int)
}
