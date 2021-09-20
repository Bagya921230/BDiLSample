package com.inova.mobile.bdilshopify.ui.product_details.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.inova.mobile.bdilshopify.R
import com.inova.mobile.bdilshopify.model.Category
import com.inova.mobile.bdilshopify.typhography.BDiLTypoStyle
import com.inova.mobile.bdilshopify.ui.components.BDiLTextView
import com.inova.mobile.bdilshopify.ui.home.callback.CategoryCallback
import java.util.ArrayList

class ProductDetailsAdapter(
    private val dataSet: ArrayList<Category>,
    var mContext: Context,
    private val categoryCallback: CategoryCallback
) : RecyclerView.Adapter<RecyclerView.ViewHolder?>() {

    class ProductDetailsViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var name: BDiLTextView
//        var categoryImage: ImageView

        init {
            name = itemView.findViewById<View>(R.id.txtChipName) as BDiLTextView
//            categoryImage = itemView.findViewById<View>(R.id.categoryImage) as ImageView
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val view: View
        view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_brand_view, parent, false)
        return ProductDetailsViewHolder(view)
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, listPosition: Int) {
        val category = dataSet[listPosition]

        (holder as ProductDetailsViewHolder?)!!.name.text = category.name
//        Glide.with(mContext)
//            .load(category.image)
//            .into((holder as ProductDetailsViewHolder?)!!.categoryImage);
        configureLabels(holder)
    }

    fun configureLabels(holder: ProductDetailsViewHolder) {
        holder.name.set(mContext, BDiLTypoStyle.MEDIUM_WHITE_16)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}