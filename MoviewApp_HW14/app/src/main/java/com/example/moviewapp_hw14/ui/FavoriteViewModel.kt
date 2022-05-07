package com.example.moviewapp_hw14.ui

import androidx.lifecycle.ViewModel
import com.example.moviewapp_hw14.data.model.FilmData
import com.example.moviewapp_hw14.data.model.FilmState

class FavoriteViewModel: ViewModel() {

    private val filmList = FilmData.filmList

    fun addFavorite() : MutableList<FilmState> {
        val addFilm = mutableListOf<FilmState>()
        for (k in filmList){
            if (k.liked) addFilm.add(k)
        }
        return addFilm
    }
}