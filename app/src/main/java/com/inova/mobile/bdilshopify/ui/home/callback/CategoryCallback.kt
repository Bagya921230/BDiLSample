package com.inova.mobile.bdilshopify.ui.home.callback

import com.inova.mobile.bdilshopify.model.Category

interface CategoryCallback {
    fun onCategoryClick(data: Category)
}