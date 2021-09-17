package com.inova.mobile.bdilshopify.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.inova.mobile.bdilshopify.R
import com.inova.mobile.bdilshopify.model.Category
import com.inova.mobile.bdilshopify.typhography.BDiLTypoStyle
import com.inova.mobile.bdilshopify.ui.components.BDiLTextView
import com.inova.mobile.bdilshopify.ui.home.callback.CategoryCallback
import java.util.ArrayList

class HomeCategoryAdapter(
    private val dataSet: ArrayList<Category>,
    var mContext: Context,
    private val categoryCallback: CategoryCallback
) : RecyclerView.Adapter<RecyclerView.ViewHolder?>() {

    class CategoryViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var name: BDiLTextView
        var categoryImage: ImageView

        init {
            name = itemView.findViewById<View>(R.id.categoryName) as BDiLTextView
            categoryImage = itemView.findViewById<View>(R.id.categoryImage) as ImageView
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val view: View
        view = LayoutInflater.from(parent.context)
            .inflate(R.layout.home_category_item_view, parent, false)
        return CategoryViewHolder(view)
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, listPosition: Int) {
        val category = dataSet[listPosition]

        (holder as CategoryViewHolder?)!!.name.text = category.name
        Glide.with(mContext)
            .load(category.image)
            .into((holder as CategoryViewHolder?)!!.categoryImage);
        configureLabels(holder)
    }

    fun configureLabels(holder: CategoryViewHolder) {
        holder.name.set(mContext, BDiLTypoStyle.MEDIUM_WHITE_16)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}