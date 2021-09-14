package com.inova.mobile.bdilshopify.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.inova.mobile.bdilproductlist.ProductListBasic
import com.inova.mobile.bdilproductlist.listener.ProductOnClickListener
import com.inova.mobile.bdilproductlist.model.Product
import com.inova.mobile.bdilshopify.typhography.BDiLTypoStyle
import com.inova.mobile.bdilshopify.R
import com.inova.mobile.bdilshopify.ui.components.BDiLTextView

class HomeFragment : Fragment() ,ProductOnClickListener{

    lateinit var productList: ProductListBasic
    lateinit var shopNameTv: BDiLTextView
    lateinit var bestSalesTv: BDiLTextView
    lateinit var logoIcon: ImageView
    private lateinit var homeViewModel: HomeViewModel
    lateinit var navController: NavController

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
        productList = root.findViewById(R.id.productList2)

        productList.setProductClickListener(this)

        navController = findNavController(this)

        configureLabels()
        return root
    }

    fun configureLabels() {
        shopNameTv.set(activity,BDiLTypoStyle.MEDIUM_PRIMARY_16)
        bestSalesTv.set(activity,BDiLTypoStyle.MEDIUM_BLACK_16)
    }

    override fun onItemClickListener(data: Product) {
        Toast.makeText(activity, "Item Clicked", Toast.LENGTH_SHORT).show()
        navController.navigate(R.id.action_navigation_home_to_navigation_dashboard)
    }

    override fun onBuyClickListener(data: Product) {
        Toast.makeText(activity, "Buy clicked", Toast.LENGTH_SHORT).show()
    }
}