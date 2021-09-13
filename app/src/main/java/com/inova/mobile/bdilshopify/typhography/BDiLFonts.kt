package com.inova.mobile.bdilshopify.typhography

import android.content.Context
import android.graphics.Typeface
import com.inova.mobile.bdilproductlist.R

//"REGULAR_WHITE_16,
//REGULAR_GRAY_16,
//REGULAR_BLACK_14,
//REGULAR_GRAY_14,
//REGULAR_BLACK_12,

//REGULAR_PRIMARY_10,
//MEDIUM_BLACK_16,
//MEDIUM_PRIMARY_14,
//MEDIUM_WHITE_16,
//MEDIUM_BLACK_24"

class BDiLFonts {

    var primaryColor: Int = R.color.colorPrimary
    var secondaryColor: Int = R.color.colorPrimaryDark

    fun setFont(
        context: Context,
        bodaTypogrphyStyle: BDiLTypoStyle?
    ): Triplet<Float, Typeface, Int> {
        return when (bodaTypogrphyStyle) {
            BDiLTypoStyle.REGULAR_WHITE_16 -> Triplet<Float, Typeface, Int>(
                16.toFloat(),
                setTypeface(context, "fonts/roboto_regular.ttf"),
                R.color.colorWhite
            )
            BDiLTypoStyle.REGULAR_GRAY_16 -> Triplet<Float, Typeface, Int>(
                16.toFloat(),
                setTypeface(context, "fonts/roboto_regular.ttf"),
                R.color.colorGray
            )
            BDiLTypoStyle.REGULAR_BLACK_14 -> Triplet<Float, Typeface, Int>(
                14.toFloat(),
                setTypeface(context, "fonts/roboto_regular.ttf"),
                R.color.colorBlack
            )
            BDiLTypoStyle.REGULAR_GRAY_14 -> Triplet<Float, Typeface, Int>(
                14.toFloat(),
                setTypeface(context, "fonts/roboto_regular.ttf"),
                R.color.colorGray
            )
            BDiLTypoStyle.REGULAR_BLACK_12 -> Triplet<Float, Typeface, Int>(
                12.toFloat(),
                setTypeface(context, "fonts/roboto_regular.ttf"),
                R.color.colorBlack
            )
            BDiLTypoStyle.REGULAR_PRIMARY_10 -> Triplet<Float, Typeface, Int>(
                10.toFloat(),
                setTypeface(context, "fonts/roboto_regular.ttf"),
                primaryColor
            )
            BDiLTypoStyle.MEDIUM_BLACK_16 -> Triplet<Float, Typeface, Int>(
                16.toFloat(),
                setTypeface(context, "fonts/roboto_medium.ttf"),
                R.color.colorBlack
            )
            BDiLTypoStyle.MEDIUM_PRIMARY_14 -> Triplet<Float, Typeface, Int>(
                14.toFloat(),
                setTypeface(context, "fonts/roboto_medium.ttf"),
                primaryColor
            )
            BDiLTypoStyle.MEDIUM_WHITE_16 -> Triplet<Float, Typeface, Int>(
                16.toFloat(),
                setTypeface(context, "fonts/roboto_medium.ttf"),
                R.color.colorWhite
            )
            BDiLTypoStyle.MEDIUM_BLACK_24 -> Triplet<Float, Typeface, Int>(
                24.toFloat(),
                setTypeface(context, "fonts/roboto_medium.ttf"),
                R.color.colorBlack
            )
            BDiLTypoStyle.MEDIUM_PRIMARY_16 -> Triplet<Float, Typeface, Int>(
                24.toFloat(),
                setTypeface(context, "fonts/roboto_medium.ttf"),
                primaryColor
            )
            else -> Triplet<Float, Typeface, Int>(
                14.toFloat(),
                setTypeface(context, "fonts/roboto_regular.ttf"),
                R.color.colorBlack
            )
        }
    }

    private fun setTypeface(context: Context, path: String): Typeface {
        return Typeface.createFromAsset(
            context.assets,
            path
        )
    }

}