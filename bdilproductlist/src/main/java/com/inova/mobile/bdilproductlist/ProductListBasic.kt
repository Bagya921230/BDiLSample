package com.inova.mobile.bdilproductlist

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.inova.mobile.bdilproductlist.adapter.ProductAdapter
import com.inova.mobile.bdilproductlist.model.AdapterModel
import com.inova.mobile.bdilproductlist.model.Product


class ProductListBasic : LinearLayout {
    /** Core Items */
    private var mContext: Context
    private var attrs: AttributeSet? = null
    private var styleAttr = 0
    private var view: View? = null

    /** Core Components */
    var productRecyclerView: RecyclerView? = null
    var adapter: ProductAdapter? = null

    /** Attributes  */
    var viewType: Int? = 0
    var cardColor: Int? = R.color.colorWhite
    var layoutManager: Int? = 0
    var layoutDirection: Int? = 0
    var primaryColor :Int? = R.color.colorPrimary
    var secondaryColor :Int? = R.color.colorPrimaryDark

    constructor(context: Context) : super(context) {
        mContext = context
        initView()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        mContext = context
        this.attrs = attrs
        initView()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        mContext = context
        this.attrs = attrs
        styleAttr = defStyleAttr
        initView()
    }

    private fun initView() {

        view = this
        inflate(mContext, R.layout.product_list_layout, this)
        val arr = mContext.obtainStyledAttributes(
            attrs, R.styleable.ProductListBasic,
            styleAttr, 0
        )

        viewType = arr.getInt(R.styleable.ProductListBasic_viewType, 0)
        layoutDirection = arr.getInt(R.styleable.ProductListBasic_mLayoutDirection, 0)
        layoutManager = arr.getInt(R.styleable.ProductListBasic_mLayoutManager, 0)
        cardColor = arr.getColor(R.styleable.ProductListBasic_cardColor, 0)
        primaryColor = arr.getColor(R.styleable.ProductListBasic_primaryColor, 0)
        secondaryColor = arr.getColor(R.styleable.ProductListBasic_secondaryColor, 0)


        productRecyclerView = findViewById<RecyclerView>(R.id.productRv);
        setAdapterSettings(viewType!!)
        setLayoutManager(layoutManager!!)
        setLinearLayoutDirection(layoutDirection!!)
        productRecyclerView?.adapter = adapter

        arr.recycle()
    }

    fun setAdapterSettings(itemType: Int) {
        //TODO: Get the list from API
        val list: ArrayList<AdapterModel> = ArrayList()
        list.add(
            AdapterModel(
                itemType,
                Product(
                    "Cellulite Duo",
                    "\$65.00",
                    "\$76.45",
                    "https://cdn.shopify.com/s/files/1/1705/3837/products/cellulite-duo_540x.jpg?v=1620913657",
                    4
                )
            )
        )
        list.add(
            AdapterModel(
                itemType,
                Product(
                    "Exfoliation Duo",
                    "\$35.00",
                    "\$59.90",
                    "https://cdn.shopify.com/s/files/1/1705/3837/products/exfoliation-duo_a41146fc-3d83-497c-9ee0-bce02abc811b_540x.jpg?v=1620915557",
                    3
                )
            )
        )
        list.add(
            AdapterModel(
                itemType,
                Product(
                    "Organic Coffee Scrub",
                    "\$19.95",
                    "\$39.95",
                    "https://cdn.shopify.com/s/files/1/1705/3837/products/200g-organic-coffee-scrub_6d2d5e66-9066-4f5c-b494-d774ee43f755_540x.jpg?v=1620873384",
                    2
                )
            )
        )
        list.add(
            AdapterModel(
                itemType,
                Product(
                    "Gua Sha Duo",
                    "\$89.00",
                    "\$109.00",
                    "https://cdn.shopify.com/s/files/1/1705/3837/products/gua-sha-duo_d62d941d-c292-46d0-82cf-93efc098c83e_540x.jpg?v=1620874886",
                    5
                )
            )
        )

        adapter = ProductAdapter(list, context)

    }

    fun setLayoutManager(mLayoutManager: Int) {

        if (mLayoutManager == 1) {
            val gridLayoutManager = GridLayoutManager(context, 2)
            productRecyclerView?.layoutManager = gridLayoutManager
        } else {
            if (layoutDirection == 0) {

                val linearLayoutManager =
                    LinearLayoutManager(context, RecyclerView.VERTICAL, false)
                productRecyclerView?.layoutManager = linearLayoutManager
            } else {

                val linearLayoutManager =
                    LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
                productRecyclerView?.layoutManager = linearLayoutManager
            }
        }
    }

    fun setLinearLayoutDirection(mDirection: Int) {
        if (layoutManager == 0) {
            if (mDirection == 0) {

                val linearLayoutManager =
                    LinearLayoutManager(context, RecyclerView.VERTICAL, false)
                productRecyclerView?.layoutManager = linearLayoutManager
            } else {

                val linearLayoutManager =
                    LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
                productRecyclerView?.layoutManager = linearLayoutManager
            }
        }
    }

}