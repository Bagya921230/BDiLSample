package com.inova.mobile.bdilshopify.ui.shop

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CategoryViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is category Fragment"
    }
    val text: LiveData<String> = _text
}