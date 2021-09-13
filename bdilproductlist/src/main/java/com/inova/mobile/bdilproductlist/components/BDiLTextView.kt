package com.inova.mobile.bdilproductlist.components

import android.R
import android.content.Context
import android.graphics.Typeface
import android.os.Build
import android.text.InputType
import android.util.AttributeSet
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.res.ResourcesCompat
import com.inova.mobile.bdilproductlist.typhography.BDiLFonts
import com.inova.mobile.bdilproductlist.typhography.BDiLTypoStyle
import com.inova.mobile.bdilproductlist.typhography.Triplet


class BDiLTextView : AppCompatTextView {
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context) : super(context) {
        initUI(context)
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initUI(context)
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initUI(context)
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private fun initUI(context: Context) {
        val attributes: Triplet<Float, Typeface, Int> =
            BDiLFonts().setFont(context, BDiLTypoStyle.REGULAR_BLACK_14)
        setTextSize(attributes.first)
        setTypeface(attributes.second)
        val color: Int = attributes.third
        setTextColor(color)
        setInputType(InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS)
        //setLineSpacing(BDiLTypoStyle.REGULAR_BLACK_14)
        setSingleLine(false)
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    operator fun set(context: Context?, bodaTypogrphyStyle: BDiLTypoStyle) {
        val attributes: Triplet<Float, Typeface, Int> =
            BDiLFonts().setFont(context!!, bodaTypogrphyStyle)
        setTextSize(attributes.first)
        setTypeface(attributes.second)
        val color: Int = attributes.third
        setTextColor(color)
        setLineSpacing(bodaTypogrphyStyle)
    }

    override fun setInputType(type: Int) {
        super.setInputType(type)
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private fun setLineSpacing(bodaTypogrphyStyle: BDiLTypoStyle) {
        when (bodaTypogrphyStyle) {
            BDiLTypoStyle.REGULAR_BLACK_14 -> setLetterSpacing(0.1.toFloat())
            else -> setLetterSpacing(0.1.toFloat())
        }
    }

}