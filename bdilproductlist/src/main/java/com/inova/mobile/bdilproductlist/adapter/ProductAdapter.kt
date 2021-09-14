package com.inova.mobile.bdilproductlist.adapter

import android.content.Context
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RatingBar
import androidx.cardview.widget.CardView
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.inova.mobile.bdilproductlist.R
import com.inova.mobile.bdilproductlist.components.BDiLTextView
import com.inova.mobile.bdilproductlist.listener.ProductOnClickListener
import com.inova.mobile.bdilproductlist.model.AdapterModel
import com.inova.mobile.bdilproductlist.prefs
import com.inova.mobile.bdilproductlist.typhography.BDiLTypoStyle
import java.util.*

class ProductAdapter(
    private val dataSet: ArrayList<AdapterModel>,
    var mContext: Context,
    private val productClickListener: ProductOnClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder?>() {
    var total_types: Int

    init {
        total_types = dataSet.size
    }

    class TypeAViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var name: BDiLTextView
        var price: BDiLTextView
        var regularPrice: BDiLTextView
        var rating: RatingBar
        var cardView: CardView
        var productImage: ImageView
        var buyNowTv: BDiLTextView
        var btnBgView: CardView

        init {
            name = itemView.findViewById<View>(R.id.name) as BDiLTextView
            price = itemView.findViewById<View>(R.id.price) as BDiLTextView
            regularPrice = itemView.findViewById<View>(R.id.regularPrice) as BDiLTextView
            rating = itemView.findViewById<View>(R.id.productRating) as RatingBar
            cardView = itemView.findViewById<View>(R.id.card_view) as CardView
            productImage = itemView.findViewById<View>(R.id.productImg) as ImageView
            buyNowTv = itemView.findViewById<View>(R.id.buyNowTv) as BDiLTextView
            btnBgView = itemView.findViewById(R.id.btnBg) as CardView
        }
    }

    class TypeBViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var name: BDiLTextView
        var price: BDiLTextView
        var regularPrice: BDiLTextView
        var rating: BDiLTextView
        var cardView: CardView
        var productImage: ImageView
        var buyNowTv: BDiLTextView
        var starImageView: ImageView
        var btnBgView: View

        init {
            name = itemView.findViewById<View>(R.id.name) as BDiLTextView
            price = itemView.findViewById<View>(R.id.price) as BDiLTextView
            regularPrice = itemView.findViewById<View>(R.id.regularPrice) as BDiLTextView
            rating = itemView.findViewById<View>(R.id.rating) as BDiLTextView
            cardView = itemView.findViewById<View>(R.id.card_view) as CardView
            productImage = itemView.findViewById<View>(R.id.productImg) as ImageView
            buyNowTv = itemView.findViewById<View>(R.id.buyNowTv) as BDiLTextView
            btnBgView = itemView.findViewById(R.id.btnBg) as View
            starImageView = itemView.findViewById(R.id.starIcon)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val view: View
        when (viewType) {
            AdapterModel.TYPE_A -> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_view_a, parent, false)
                return TypeAViewHolder(view)
            }
            AdapterModel.TYPE_B -> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_view_b, parent, false)
                return TypeBViewHolder(view)
            }
            else -> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_view_a, parent, false)
                return TypeAViewHolder(view)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (dataSet[position].type) {
            0 -> AdapterModel.TYPE_A
            1 -> AdapterModel.TYPE_B
            else -> -1
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, listPosition: Int) {
        val product = dataSet[listPosition]

        when (product.type) {
            AdapterModel.TYPE_A -> {
                (holder as TypeAViewHolder?)!!.name.text = product.data.name
                (holder as TypeAViewHolder?)!!.price.text = product.data.price
                (holder as TypeAViewHolder?)!!.regularPrice.text = product.data.regularPrice
                (holder as TypeAViewHolder?)!!.rating.rating = product.data.rating.toFloat()
                Glide.with(mContext)
                    .load(product.data.image)
                    .into((holder as TypeAViewHolder?)!!.productImage);
                (holder as TypeAViewHolder?)!!.btnBgView.setCardBackgroundColor(prefs.primaryColorPref)
                setTypeAFonts(holder)
                (holder as TypeAViewHolder?)!!.itemView.setOnClickListener {
                    productClickListener.onItemClickListener(product.data)
                }
                (holder as TypeAViewHolder?)!!.btnBgView.setOnClickListener {
                    productClickListener.onBuyClickListener(product.data)
                }
            }
            AdapterModel.TYPE_B -> {
                (holder as TypeBViewHolder?)!!.name.text = product.data.name
                (holder as TypeBViewHolder?)!!.price.text = product.data.price
                (holder as TypeBViewHolder?)!!.regularPrice.text = product.data.regularPrice
                (holder as TypeBViewHolder?)!!.rating.text = product.data.rating.toString()
                Glide.with(mContext)
                    .load(product.data.image)
                    .into((holder as TypeBViewHolder?)!!.productImage);
                (holder as TypeBViewHolder?)!!.btnBgView.setBackgroundColor(prefs.primaryColorPref)
                setTypeBFonts(holder)
                (holder as TypeBViewHolder?)!!.itemView.setOnClickListener {
                    productClickListener.onItemClickListener(product.data)
                }
                (holder as TypeBViewHolder?)!!.btnBgView.setOnClickListener {
                    productClickListener.onBuyClickListener(product.data)
                }
            }
        }
    }

    fun setTypeAFonts(holder: TypeAViewHolder) {
        holder.name.set(mContext, BDiLTypoStyle.MEDIUM_BLACK_16)
        holder.price.set(mContext, BDiLTypoStyle.REGULAR_GRAY_14)
        holder.regularPrice.set(mContext, BDiLTypoStyle.REGULAR_GRAY_14)
        holder.regularPrice.setPaintFlags(holder.regularPrice.getPaintFlags() or Paint.STRIKE_THRU_TEXT_FLAG)
        holder.buyNowTv.set(mContext,BDiLTypoStyle.MEDIUM_WHITE_16)
    }

    fun setTypeBFonts(holder: TypeBViewHolder) {
        holder.name.set(mContext, BDiLTypoStyle.REGULAR_BLACK_14)
        holder.price.set(mContext, BDiLTypoStyle.REGULAR_GRAY_14)
        holder.regularPrice.set(mContext, BDiLTypoStyle.REGULAR_GRAY_14)
        holder.rating.set(mContext, BDiLTypoStyle.REGULAR_PRIMARY_10)
        holder.regularPrice.setPaintFlags(holder.regularPrice.getPaintFlags() or Paint.STRIKE_THRU_TEXT_FLAG)
        holder.buyNowTv.set(mContext,BDiLTypoStyle.MEDIUM_WHITE_16)
        holder.starImageView.setColorFilter(prefs.primaryColorPref, PorterDuff.Mode.SRC_IN)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}