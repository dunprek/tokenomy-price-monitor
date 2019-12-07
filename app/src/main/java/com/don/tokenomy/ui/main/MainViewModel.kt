package com.don.tokenomy.ui.main

import android.widget.LinearLayout
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.don.tokenomy.api.TokenomyService
import com.don.tokenomy.data.TokenomyRepository
import com.don.tokenomy.data.remote.MdlMarket
import com.don.tokenomy.data.remote.RemoteRepository

/**
 * Created by gideon on 06,December,2019
 * dunprek@gmail.com
 * Jakarta - Indonesia
 */

class MainViewModel() : ViewModel() {
    lateinit var mService: TokenomyService
    lateinit var mProgress: LinearLayout

    val tokenomyRepository: TokenomyRepository = TokenomyRepository.getInstance(RemoteRepository())!!


    fun getErrors(): LiveData<String> {
        return tokenomyRepository.getError()
    }

    fun getSummary(): LiveData<List<MdlMarket>> {
        return tokenomyRepository.getSummary(mService, mProgress)
    }

    fun setAttributes(tokenomyService: TokenomyService, view: LinearLayout) {
        this.mService = tokenomyService
        this.mProgress = view
    }

}