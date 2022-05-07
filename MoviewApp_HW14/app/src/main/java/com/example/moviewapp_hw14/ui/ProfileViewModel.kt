package com.example.moviewapp_hw14.ui

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviewapp_hw14.data.model.User
import com.example.moviewapp_hw14.network.NetworkManager
import com.example.moviewapp_hw14.network.arrayConvert
import okhttp3.MediaType
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileViewModel:ViewModel() {
    private val _register: MutableLiveData<Boolean> = MutableLiveData()
    val register: LiveData<Boolean> = _register
    val firstName = MutableLiveData<String>()
    val lastName = MutableLiveData<String>()
    val userName = MutableLiveData<String>()
    val email = MutableLiveData<String>()
    val phoneNumber = MutableLiveData<String>()
    val viewPic: Bitmap? = null
    var urlPic : String? = null

    private fun picUpload(bitmap: Bitmap) {
        val userName = userName.value
        val requestBody =
            MultipartBody.create(MediaType.parse("image/*"), bitmap.arrayConvert())
        val body = MultipartBody.Part.createFormData(
            "image",
            "${userName}.png",
            requestBody
        )
        NetworkManager.service.uploadImage(userName.toString(), body)
            .enqueue(object : Callback<Any?> {
                override fun onResponse(call: Call<Any?>, response: Response<Any?>) {
                    _register.postValue(true)
                    urlPic = "http://51.195.19.222/uploads/${userName}.png"
                }

                override fun onFailure(call: Call<Any?>, t: Throwable) {}
            })
    }
    fun register(bitmap: Bitmap) {
        if (validInput()){
            picUpload(bitmap)
        }
    }
    private fun validInput(): Boolean {
        var flag = false
        if (firstName.value.toString().isNotBlank() && lastName.value.toString().isNotBlank() &&
            email.value.toString().isNotBlank() && phoneNumber.value.toString().isNotBlank() &&
            userName.value.toString().isNotBlank())
        {
            User.firstName = firstName.value
            User.lastName = lastName.value
            User.email = email.value
            User.phoneNumber = phoneNumber.value
            User.userName = userName.value
            User.isSign = true
            flag = true
        }
        return flag
    }
    init {
        if (User.isSign) {
            firstName.value = User.firstName.toString()
            lastName.value = User.lastName.toString()
            userName.value = User.userName.toString()
            email.value = User.email.toString()
            phoneNumber.value = User.phoneNumber.toString()
            urlPic = User.urlImage.toString()
            _register.value = User.isSign
        }
    }
}