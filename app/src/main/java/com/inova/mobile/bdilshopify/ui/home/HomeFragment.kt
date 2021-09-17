package com.inova.mobile.bdilshopify.ui.home

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.inova.mobile.bdilproductlist.ProductListBasic
import com.inova.mobile.bdilproductlist.listener.ProductOnClickListener
import com.inova.mobile.bdilproductlist.model.Product
import com.inova.mobile.bdilshopify.R
import com.inova.mobile.bdilshopify.model.Category
import com.inova.mobile.bdilshopify.model.Promo
import com.inova.mobile.bdilshopify.typhography.BDiLTypoStyle
import com.inova.mobile.bdilshopify.ui.components.BDiLTextView
import com.inova.mobile.bdilshopify.ui.components.CenterZoomLayoutManager
import com.inova.mobile.bdilshopify.ui.home.adapter.HomeCategoryAdapter
import com.inova.mobile.bdilshopify.ui.home.adapter.HomePromoAdapter
import com.inova.mobile.bdilshopify.ui.home.callback.CategoryCallback
import com.inova.mobile.bdilshopify.ui.product_details.ProductDetailsFragment
import java.util.*
import kotlin.collections.ArrayList


data class Item(
    val title: String,
    @DrawableRes val icon: Int
)

class HomeFragment : Fragment() ,ProductOnClickListener, CategoryCallback{

    lateinit var productList: ProductListBasic
    lateinit var shopNameTv: BDiLTextView
    lateinit var bestSalesTv: BDiLTextView
    lateinit var logoIcon: ImageView
    lateinit var categoryRv: RecyclerView
    lateinit var promoRv: RecyclerView
    private lateinit var homeViewModel: HomeViewModel
    lateinit var navController: NavController

    //---
    val duration: Int = 10
    val pixelsToMove = 30
    private val mHandler: Handler = Handler(Looper.getMainLooper())
    private val SCROLLING_RUNNABLE: Runnable = object : Runnable {
        override fun run() {
            promoRv.smoothScrollBy(pixelsToMove, 0)
            mHandler.postDelayed(this, duration.toLong())
        }
    }
    //

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        //binding = DataBindingUtil.setContentView(this, R.layout.fragment_home)

        val root = inflater.inflate(R.layout.fragment_home, container, false)
        shopNameTv = root.findViewById(R.id.shopName)
        productList = root.findViewById(R.id.productList2)
        categoryRv = root.findViewById(R.id.categoryRv)
        promoRv = root.findViewById(R.id.promoRv)


        productList.setProductClickListener(this)

        navController = findNavController(this)

        configureLabels()
        configureCategories()
        configurePromos()
        return root
    }

    fun configureCategories() {
        var categoryList = ArrayList<Category>()
        categoryList.add(
            Category(
                "Dresses",
                "https://image.freepik.com/free-photo/smiling-beautiful-young-woman-pink-mini-dress-posing-studio_155003-14602.jpg"
            )
        );
        categoryList.add(
            Category(
                "Jeans",
                "https://img.freepik.com/free-photo/barefoot-legs-female-group-jeans_23-2148206850.jpg?size=338&ext=jpg"
            )
        );
        categoryList.add(
            Category(
                "Jackets",
                "https://img.freepik.com/free-photo/confident-serious-handsome-man-wears-black-leather-jacket-gray-t-shirt-stylish-eyewear-looks-directly-into-camera-isolated-people-style-concept_176420-13362.jpg?size=338&ext=jpg"
            )
        )

        val linearLayoutManager =
            LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)

        categoryRv?.layoutManager = linearLayoutManager
        var adapter = HomeCategoryAdapter(categoryList, requireActivity(), this)
        categoryRv.adapter = adapter

    }

    fun configurePromos() {
        var promoList = ArrayList<Promo>()
        promoList.add(
                Promo(
                    "SALE",
                    "30% Off",
                    "https://image.freepik.com/free-vector/modern-black-friday-sale-banner-template-with-3d-background-red-splash_1361-1877.jpg"
                )
        )
        promoList.add(
            Promo(
                "SALE",
                "30% Off",
                "https://image.freepik.com/free-psd/full-shot-winter-season-sale-mock-up_23-2148319682.jpg"
            )
        )
        promoList.add(
            Promo(
                "SALE",
                "30% Off",
                "https://image.freepik.com/free-vector/new-season-banner-template_1361-1221.jpg"
            )
        )
        promoList.add(
            Promo(
                "SALE",
                "30% Off",
                "https://image.freepik.com/free-vector/fashion-store-banner-template_1361-1248.jpg"
            )
        )
        promoList.add(
            Promo(
                "SALE",
                "30% Off",
                "https://image.freepik.com/free-vector/modern-black-friday-sale-banner-template-with-3d-background-red-splash_1361-1877.jpg"
            )
        )
        promoList.add(
            Promo(
                "SALE",
                "30% Off",
                "https://image.freepik.com/free-psd/full-shot-winter-season-sale-mock-up_23-2148319682.jpg"
            )
        )
        promoList.add(
            Promo(
                "SALE",
                "30% Off",
                "https://image.freepik.com/free-vector/new-season-banner-template_1361-1221.jpg"
            )
        )
        promoList.add(
            Promo(
                "SALE",
                "30% Off",
                "https://image.freepik.com/free-vector/fashion-store-banner-template_1361-1248.jpg"
            )
        )
        promoList.add(
            Promo(
                "SALE",
                "30% Off",
                "https://image.freepik.com/free-vector/modern-black-friday-sale-banner-template-with-3d-background-red-splash_1361-1877.jpg"
            )
        )
        promoList.add(
            Promo(
                "SALE",
                "30% Off",
                "https://image.freepik.com/free-psd/full-shot-winter-season-sale-mock-up_23-2148319682.jpg"
            )
        )
        promoList.add(
            Promo(
                "SALE",
                "30% Off",
                "https://image.freepik.com/free-vector/new-season-banner-template_1361-1221.jpg"
            )
        )
        promoList.add(
            Promo(
                "SALE",
                "30% Off",
                "https://image.freepik.com/free-vector/fashion-store-banner-template_1361-1248.jpg"
            )
        )
        promoList.add(
            Promo(
                "SALE",
                "30% Off",
                "https://image.freepik.com/free-vector/modern-black-friday-sale-banner-template-with-3d-background-red-splash_1361-1877.jpg"
            )
        )
        promoList.add(
            Promo(
                "SALE",
                "30% Off",
                "https://image.freepik.com/free-psd/full-shot-winter-season-sale-mock-up_23-2148319682.jpg"
            )
        )
        promoList.add(
            Promo(
                "SALE",
                "30% Off",
                "https://image.freepik.com/free-vector/new-season-banner-template_1361-1221.jpg"
            )
        )
        promoList.add(
            Promo(
                "SALE",
                "30% Off",
                "https://image.freepik.com/free-vector/fashion-store-banner-template_1361-1248.jpg"
            )
        )


        val layoutManager =
            CenterZoomLayoutManager(requireActivity(), 0.9f, 0.09f)

        promoRv?.layoutManager = layoutManager
        var adapter = HomePromoAdapter(promoList, requireActivity(), this)
        promoRv.adapter = adapter
        adapter.notifyDataSetChanged()
        promoRv.scrollToPosition(1)


        PagerSnapHelper().attachToRecyclerView(promoRv)

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                if (layoutManager.findLastCompletelyVisibleItemPosition() < adapter.itemCount - 1) {
                    layoutManager.smoothScrollToPosition(
                        promoRv,
                        RecyclerView.State(),
                        layoutManager.findLastCompletelyVisibleItemPosition() + 1
                    )
                } else if (layoutManager.findLastCompletelyVisibleItemPosition() === adapter.itemCount - 1) {
                    layoutManager.smoothScrollToPosition(
                        promoRv,
                        RecyclerView.State(),
                        0
                    )
                }
            }
        }, 0, 4000)

    }


    fun configureLabels() {
        shopNameTv.set(activity, BDiLTypoStyle.MEDIUM_PRIMARY_30)
    }

    //Product Callbacks
    override fun onItemClickListener(data: Product) {
        Toast.makeText(activity, "Item Clicked", Toast.LENGTH_SHORT).show()
//        navController.navigate(R.id.action_navigation_home_to_navigation_dashboard)

        val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container, ProductDetailsFragment().newInstance(data)!!)
        fragmentTransaction.commit()
    }

    override fun onBuyClickListener(data: Product) {
        Toast.makeText(activity, "Buy clicked", Toast.LENGTH_SHORT).show()
    }

    //Category Callbacks
    override fun onCategoryClick(data: Category) {
        TODO("Not yet implemented")
    }
}