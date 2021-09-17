package com.inova.mobile.bdilshopify.ui.shop

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.inova.mobile.bdilshopify.R
import com.inova.mobile.bdilshopify.model.Category
import com.inova.mobile.bdilshopify.ui.home.adapter.HomeCategoryAdapter
import com.inova.mobile.bdilshopify.ui.home.callback.CategoryCallback
import com.inova.mobile.bdilshopify.ui.shop.adapter.CategoryAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class CategoryFragment : Fragment() ,CategoryCallback{

    private lateinit var categoryViewModel: CategoryViewModel
    private lateinit var categoryRv: RecyclerView

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        categoryViewModel =
                ViewModelProviders.of(this).get(CategoryViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_category, container, false)
        categoryRv = root.findViewById(R.id.categoryRecyclerView)

        configureCategories()

        return root
    }

    private fun configureCategories() {
        val categoryList = ArrayList<Category>()
        categoryList.add(
            Category(
                "Dresses")
        )
        categoryList.add(
            Category(
                "Tops")
        )
        categoryList.add(
            Category(
                "Jeans")
        )
        categoryList.add(
            Category(
                "Jackets")
        )
        categoryList.add(
            Category(
                "Knitwear")
        )
        categoryList.add(
            Category(
                "Bags")
        )
        categoryList.add(
            Category(
                "Hats")
        )
        categoryList.add(
            Category(
                "Towels")
        )

        val linearLayoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        categoryRv.layoutManager = linearLayoutManager
        val adapter = CategoryAdapter(categoryList, requireActivity(), this)
        categoryRv.adapter = adapter
    }

    override fun onCategoryClick(data: Category) {
        Log.d("test","sdsadasd")
    }
}