package com.inova.mobile.bdilshopify.ui.product_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.inova.mobile.bdilproductlist.model.Product
import com.inova.mobile.bdilshopify.R
import com.inova.mobile.bdilshopify.model.Category
import com.inova.mobile.bdilshopify.ui.home.HomeViewModel
import com.inova.mobile.bdilshopify.ui.product_details.adapter.ProductDetailsAdapter

class ProductDetailsFragment : Fragment() {
    lateinit var productList: Category
    lateinit var brandRv: RecyclerView
    private lateinit var ProductDetailsViewModel: HomeViewModel

    fun newInstance(data: Product?): Fragment? {
        val profileFragment = ProductDetailsFragment()

        return profileFragment
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        ProductDetailsViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_product_details, container, false)
        brandRv = root.findViewById(R.id.brandRv)
        configureCategories()

        return inflater.inflate(R.layout.fragment_product_details, container, false)
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

        brandRv?.layoutManager = linearLayoutManager
        var adapter = ProductDetailsAdapter(categoryList, requireActivity(), this)
        brandRv.adapter = adapter

    }

}