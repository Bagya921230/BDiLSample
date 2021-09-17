package com.inova.mobile.bdilshopify.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.inova.mobile.bdilshopify.R
import com.inova.mobile.bdilshopify.model.Category
import com.inova.mobile.bdilshopify.model.Promo
import com.inova.mobile.bdilshopify.typhography.BDiLTypoStyle
import com.inova.mobile.bdilshopify.ui.components.BDiLTextView
import com.inova.mobile.bdilshopify.ui.home.callback.CategoryCallback
import kotlinx.android.synthetic.main.home_promo_item_view.view.*
import java.util.*

class HomePromoAdapter(
    private val dataSet: ArrayList<Promo>,
    var mContext: Context,
    private val categoryCallback: CategoryCallback
) : RecyclerView.Adapter<RecyclerView.ViewHolder?>() {

    class PromoViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var title: BDiLTextView
        var description: BDiLTextView
        var promoImage: ImageView

        init {
            title = itemView.findViewById<View>(R.id.promoText1) as BDiLTextView
            description = itemView.findViewById<View>(R.id.promoText2) as BDiLTextView
            promoImage = itemView.findViewById<View>(R.id.promoImage) as ImageView
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val view: View
        view = LayoutInflater.from(parent.context)
            .inflate(R.layout.home_promo_item_view, parent, false)
        return PromoViewHolder(view)
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, listPosition: Int) {

        val promo = dataSet[listPosition]
        (holder as PromoViewHolder?)!!.title.text = promo.title
        (holder as PromoViewHolder?)!!.description.text = promo.description
        Glide.with(mContext)
            .load(promo.image)
            .into((holder as PromoViewHolder?)!!.promoImage);
        configureLabels(holder)
    }

    fun configureLabels(holder: PromoViewHolder) {
        holder.title.set(mContext, BDiLTypoStyle.MEDIUM_PRIMARY_24)
        holder.description.set(mContext, BDiLTypoStyle.REGULAR_WHITE_16)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}
