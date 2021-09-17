package com.inova.mobile.bdilshopify.ui.shop.adapter

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

class CategoryAdapter(
    private val dataSet: ArrayList<Category>,
    var mContext: Context,
    private val categoryCallback: CategoryCallback
) : RecyclerView.Adapter<RecyclerView.ViewHolder?>() {

    class CategoryViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var name: BDiLTextView

        init {
            name = itemView.findViewById<View>(R.id.categoryName) as BDiLTextView
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val view: View
        view = LayoutInflater.from(parent.context)
            .inflate(R.layout.category_item_view, parent, false)
        return CategoryViewHolder(view)
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, listPosition: Int) {

        val category = dataSet[listPosition]
        (holder as CategoryViewHolder?)!!.name.text = category.name
        configureLabels(holder)
    }

    fun configureLabels(holder: CategoryViewHolder) {
        holder.name.set(mContext, BDiLTypoStyle.REGULAR_BLACK_16)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}