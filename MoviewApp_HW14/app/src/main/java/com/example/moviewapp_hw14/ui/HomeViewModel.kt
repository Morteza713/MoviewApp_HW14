package com.example.moviewapp_hw14.ui

import androidx.lifecycle.ViewModel
import com.example.moviewapp_hw14.data.model.FilmData

class HomeViewModel:ViewModel() {

    val listFilm = FilmData.filmList
    fun likePosition(position : Int){
        FilmData.filmList[position].liked = listFilm[position].liked.not()
    }
}