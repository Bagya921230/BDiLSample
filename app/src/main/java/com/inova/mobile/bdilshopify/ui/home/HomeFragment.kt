package com.inova.mobile.bdilshopify.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.inova.mobile.bdilshopify.typhography.BDiLTypoStyle
import com.inova.mobile.bdilshopify.R
import com.inova.mobile.bdilshopify.ui.components.BDiLTextView

class HomeFragment : Fragment() {

    lateinit var shopNameTv: BDiLTextView
    lateinit var bestSalesTv: BDiLTextView
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        shopNameTv = root.findViewById(R.id.shopName)
        bestSalesTv = root.findViewById(R.id.bestSalesTv)

        configureLabels()
        return root
    }

    fun configureLabels() {
        shopNameTv.set(activity,BDiLTypoStyle.MEDIUM_PRIMARY_16)
        bestSalesTv.set(activity,BDiLTypoStyle.MEDIUM_BLACK_16)
    }
}