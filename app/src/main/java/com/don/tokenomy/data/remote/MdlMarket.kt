package com.don.tokenomy.data.remote

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data  class MdlMarket(
        var market: String?,
        var category: String?,
        var high: String?,
        var low: String?,
        var vol_a: String?,
        var vol_b: String?,
        var lastPrice: String?,
        var buy: String?,
        var sell: String?,
        var percentage: Float) : Parcelable