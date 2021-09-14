package com.inova.mobile.bdilproductlist

import android.R.attr
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.inova.mobile.bdilproductlist.adapter.ProductAdapter
import com.inova.mobile.bdilproductlist.listener.ProductOnClickListener
import com.inova.mobile.bdilproductlist.model.AdapterModel
import com.inova.mobile.bdilproductlist.model.Product


class ProductListBasic : LinearLayout,ProductOnClickListener {

    /** Core Items */
    private var mContext: Context
    private var attrs: AttributeSet? = null
    private var styleAttr = 0
    private var view: View? = null
    private lateinit var productList: ArrayList<AdapterModel>
    /** Core Components */
    var productRecyclerView: RecyclerView? = null
    var adapter: ProductAdapter? = null

    /** Attributes  */
    var viewType: Int? = 0
    var cardColor: Int? = R.color.colorWhite
    var layoutManager: Int? = 0
    var layoutDirection: Int? = 0
    var primaryColor :Int? = R.color.colorWhite
    var lightTextColor :Int? = R.color.colorWhite
    var darkTextColor: Int? = R.color.colorBlack
    var greyTextColor: Int? = R.color.colorGray
    lateinit var appOnClickListener: ProductOnClickListener

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
        darkTextColor = arr.getColor(R.styleable.ProductListBasic_darkTextColor, 0)
        lightTextColor = arr.getColor(R.styleable.ProductListBasic_lightTextColor, 0)
        greyTextColor = arr.getColor(R.styleable.ProductListBasic_greyTextColor, 0)

        //SET COLOR PREFRENCES
        prefs.primaryColorPref = primaryColor as Int
        prefs.darkTextColorPref = darkTextColor as Int
        prefs.lightTextColorPref = lightTextColor as Int
        prefs.greyTextColorPref = greyTextColor as Int

        productRecyclerView = findViewById<RecyclerView>(R.id.productRv);
        setAdapterSettings(viewType!!)
        setLayoutManager(layoutManager!!)
        setLinearLayoutDirection(layoutDirection!!)
        productRecyclerView?.adapter = adapter

        check(!context.isRestricted) {
            ("The android:onClick attribute cannot "
                    + "be used within a restricted context")
        }

        arr.recycle()
    }

    fun setAdapterSettings(itemType: Int) {
        //TODO: Get the list from API
        productList = ArrayList()
        productList.add(
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
        productList.add(
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
        productList.add(
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
        productList.add(
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

        adapter = ProductAdapter(productList, context, this)

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

    override fun onItemClickListener(data: Product) {
        if(appOnClickListener != null) {
            appOnClickListener.onItemClickListener(data)
        }
    }

    override fun onBuyClickListener(data: Product) {
        if(appOnClickListener != null) {
            appOnClickListener.onBuyClickListener(data)
        }
    }

    fun setProductClickListener(listerFromApp: ProductOnClickListener) {

        appOnClickListener = listerFromApp
    }

}