package com.inova.mobile.bdilproductlist.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.inova.mobile.bdilproductlist.R
import com.inova.mobile.bdilproductlist.components.BDiLTextView
import com.inova.mobile.bdilproductlist.listener.ProductOnClickListener
import com.inova.mobile.bdilproductlist.model.SectionModel
import com.inova.mobile.bdilproductlist.typhography.BDiLTypoStyle

class SectionAdapter(context: Context, items: ArrayList<SectionModel>?,productOnClickListener: ProductOnClickListener,mLayoutManager: Int?,mLayoutDirection: Int?) :
    RecyclerView.Adapter<SectionAdapter.SectionViewHolder>() {

    private val items: ArrayList<SectionModel>?
    private val context: Context
    private val productOnClickListener: ProductOnClickListener
    private var layoutManager: Int? = 0
    private var layoutDirection: Int? = 0

    init {
        this.items = items
        this.context = context
        this.productOnClickListener = productOnClickListener
        this.layoutManager = mLayoutManager
        this.layoutDirection = mLayoutDirection
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionViewHolder {
        val view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_header, null)

        return SectionViewHolder(view)
    }

    override fun getItemCount(): Int {
        if (items != null) {
            return items.count()
        }

        return 0
    }

    override fun onBindViewHolder(holder: SectionViewHolder, position: Int) {
        val name = items?.get(position)?.title
        val sections = items?.get(position)?.items

        val adapter = ProductAdapter(context, sections,productOnClickListener)

        holder.recyclerView.setHasFixedSize(true)
        setLayoutManager(holder,this.layoutManager)
        setLinearLayoutDirection(holder,layoutDirection)
        holder.recyclerView.adapter = adapter

        holder.title.set(context,BDiLTypoStyle.MEDIUM_BLACK_16)
        holder.viewAll.set(context,BDiLTypoStyle.MEDIUM_PRIMARY_16)
        holder.title.text = name
        holder.viewAll.setOnClickListener {
            Toast.makeText(context, name, Toast.LENGTH_SHORT).show()
        }
    }

    inner class SectionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title: BDiLTextView
        var recyclerView: RecyclerView
        var viewAll: BDiLTextView

        init {
            this.title = view.findViewById(R.id.title) as BDiLTextView
            this.recyclerView = view.findViewById(R.id.recyclerViewProducts) as RecyclerView
            this.viewAll = view.findViewById(R.id.viewAll) as BDiLTextView
        }
    }

    fun setLayoutManager(holder: SectionViewHolder, mLayoutManager: Int?) {

        if (mLayoutManager == 1) {
            val gridLayoutManager = GridLayoutManager(context, 2)
            holder.recyclerView?.layoutManager = gridLayoutManager
        } else {
            if (layoutDirection == 0) {

                val linearLayoutManager =
                    LinearLayoutManager(context, RecyclerView.VERTICAL, false)
                holder.recyclerView?.layoutManager = linearLayoutManager
            } else {

                val linearLayoutManager =
                    LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
                holder.recyclerView?.layoutManager = linearLayoutManager
            }
        }
    }

    fun setLinearLayoutDirection(holder: SectionViewHolder, mDirection: Int?) {
        if (layoutManager == 0) {
            if (mDirection == 0) {

                val linearLayoutManager =
                    LinearLayoutManager(context, RecyclerView.VERTICAL, false)
                holder.recyclerView?.layoutManager = linearLayoutManager
            } else {

                val linearLayoutManager =
                    LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
                holder.recyclerView?.layoutManager = linearLayoutManager
            }
        }
    }

}