package com.don.tokenomy.data

import android.widget.LinearLayout
import androidx.lifecycle.LiveData
import com.don.tokenomy.api.TokenomyService
import com.don.tokenomy.data.remote.MdlMarket

/**
 * Created by gideon on 06,December,2019
 * dunprek@gmail.com
 * Jakarta - Indonesia
 */
interface TokenomyDataSource {
    fun getSummary(tokenomyService: TokenomyService, progress: LinearLayout): LiveData<List<MdlMarket>>
    fun getError(): LiveData<String>
}