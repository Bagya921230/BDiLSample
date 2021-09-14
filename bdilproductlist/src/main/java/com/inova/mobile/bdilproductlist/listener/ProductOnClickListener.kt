package com.inova.mobile.bdilproductlist.listener

import com.inova.mobile.bdilproductlist.model.Product

interface ProductOnClickListener {
    fun onItemClickListener(data: Product)
    fun onBuyClickListener(data: Product)
}