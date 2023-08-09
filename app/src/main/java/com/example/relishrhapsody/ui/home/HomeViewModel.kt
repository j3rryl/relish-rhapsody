package com.example.relishrhapsody.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Welcome to Relish Rhapsody, your culinary companion on a journey of flavors and creativity. We are passionate about bringing the joy of cooking and the delight of savoring delicious meals right to your fingertips."
    }
    val text: LiveData<String> = _text
}