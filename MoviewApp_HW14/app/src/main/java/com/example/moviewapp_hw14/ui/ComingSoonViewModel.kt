package com.example.moviewapp_hw14.ui

import android.content.Intent
import androidx.lifecycle.ViewModel
import com.example.moviewapp_hw14.data.model.SoonData

class ComingSoonViewModel: ViewModel() {

    val listComingSoon = SoonData.comingSoon

    fun shareComingSoonMovie(position : Int) : Intent {
        val intent = Intent(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_SUBJECT, listComingSoon[position].name)
        intent.putExtra(Intent.EXTRA_TEXT, listComingSoon[position].url)
        intent.type = "text/plain"
        return intent
    }
}