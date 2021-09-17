package com.inova.mobile.bdilproductlist

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.inova.mobile.bdilproductlist.adapter.ProductAdapter
import com.inova.mobile.bdilproductlist.adapter.SectionAdapter
import com.inova.mobile.bdilproductlist.listener.ProductOnClickListener
import com.inova.mobile.bdilproductlist.model.AdapterModel
import com.inova.mobile.bdilproductlist.model.Product
import com.inova.mobile.bdilproductlist.model.SectionModel


class ProductListBasic : LinearLayout,ProductOnClickListener {

    /** Core Items */
    private var mContext: Context
    private var attrs: AttributeSet? = null
    private var styleAttr = 0
    private var view: View? = null
    private lateinit var productList: ArrayList<AdapterModel>
    /** Core Components */
    var productRecyclerView: RecyclerView? = null
    var adapter: SectionAdapter? = null

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
        val linearLayoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        productRecyclerView?.layoutManager = linearLayoutManager
        //setLayoutManager(layoutManager!!)
        //setLinearLayoutDirection(layoutDirection!!)
        productRecyclerView?.adapter = adapter

        check(!context.isRestricted) {
            ("The android:onClick attribute cannot "
                    + "be used within a restricted context")
        }

        arr.recycle()
    }

    private fun setAdapterSettings(itemType: Int){
        val sections = ArrayList<SectionModel>()
        val productList = ArrayList<AdapterModel>()
        productList.add(
            AdapterModel(
                itemType,
                Product(
                    "Black Leather Jacket",
                    "\$600.00",
                    "\$630.00",
                    "https://image.freepik.com/free-photo/young-stylish-guy-glasses-black-leather-jacket-with-phone-glass-background_78826-3160.jpg",
                    5
                )
            )
        )
        productList.add(
            AdapterModel(
                itemType,
                Product(
                    "Blue Maxi Dress",
                    "\$400.00",
                    "\$450.00",
                    "https://image.freepik.com/free-photo/elegant-pretty-woman-wearing-fashionable-trendy-blue-maxi-dress-posing-city-park_291049-195.jpg",
                    3
                )
            )
        )
        productList.add(
            AdapterModel(
                itemType,
                Product(
                    "Pink Boardshorts",
                    "\$200",
                    "\$250",
                    "https://image.freepik.com/free-photo/happy-professional-female-surfer-wears-boardshorts-has-positive-smile-slender-legs_273609-17784.jpg",
                    2
                )
            )
        )
        productList.add(
            AdapterModel(
                itemType,
                Product(
                    "Red Knitted Sweater",
                    "\$300.00",
                    "\$350.00",
                    "https://image.freepik.com/free-photo/pretty-lady-with-white-smile-standing-beach-near-lake-mountains-covered-with-snow-wearing-red-knitted-sweater-blue-jeans-blonde-long-hairstyle-no-makeup_343629-65.jpg",
                    5
                )
            )
        )

        val section1 = SectionModel()
        section1.title = "Best Sales"
        section1.items.addAll(productList)

        sections.add(section1)

        val section2 = SectionModel()
        section2.title = "Back In Stock"
        section2.items.addAll(productList)

        sections.add(section2)
        adapter = SectionAdapter(context, sections, this,layoutManager,layoutDirection)

    }

//    fun setLayoutManager(mLayoutManager: Int) {
//
//        if (mLayoutManager == 1) {
//            val gridLayoutManager = GridLayoutManager(context, 2)
//            productRecyclerView?.layoutManager = gridLayoutManager
//        } else {
//            if (layoutDirection == 0) {
//
//                val linearLayoutManager =
//                    LinearLayoutManager(context, RecyclerView.VERTICAL, false)
//                productRecyclerView?.layoutManager = linearLayoutManager
//            } else {
//
//                val linearLayoutManager =
//                    LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
//                productRecyclerView?.layoutManager = linearLayoutManager
//            }
//        }
//    }
//
//    fun setLinearLayoutDirection(mDirection: Int) {
//        if (layoutManager == 0) {
//            if (mDirection == 0) {
//
//                val linearLayoutManager =
//                    LinearLayoutManager(context, RecyclerView.VERTICAL, false)
//                productRecyclerView?.layoutManager = linearLayoutManager
//            } else {
//
//                val linearLayoutManager =
//                    LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
//                productRecyclerView?.layoutManager = linearLayoutManager
//            }
//        }
//    }

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