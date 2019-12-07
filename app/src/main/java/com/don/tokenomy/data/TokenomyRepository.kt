package com.don.tokenomy.data

import android.widget.LinearLayout
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.don.tokenomy.api.TokenomyService
import com.don.tokenomy.data.remote.MdlMarket
import com.don.tokenomy.data.remote.RemoteRepository

/**
 * Created by gideon on 06,December,2019
 * dunprek@gmail.com
 * Jakarta - Indonesia
 */
class TokenomyRepository(private val remoteRepository: RemoteRepository) : TokenomyDataSource {
    override fun getSummary(tokenomyService: TokenomyService, progress: LinearLayout): LiveData<List<MdlMarket>> {
        val summaryResult = MutableLiveData<List<MdlMarket>>()
        remoteRepository.getSummary(object : RemoteRepository.LoadSummaryCallback {
            override fun onSummaryReceived(market: List<MdlMarket>) {
                summaryResult.postValue(market)
            }


            override fun onDataNotAvailable(response: String) {
                errorResponse.postValue(response)
            }

        }, tokenomyService, progress)

        return summaryResult
    }


    val errorResponse = MutableLiveData<String>()

    companion object {
        @Volatile
        private var INSTANCE: TokenomyRepository? = null

        fun getInstance(remoteData: RemoteRepository): TokenomyRepository? {
            if (INSTANCE == null) {
                synchronized(TokenomyRepository::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = TokenomyRepository(remoteData)
                    }
                }
            }
            return INSTANCE
        }
    }


    override fun getError(): LiveData<String> {
        return errorResponse
    }


}