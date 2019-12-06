package com.don.tokenomy.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.don.tokenomy.R
import com.don.tokenomy.data.remote.MdlMarket
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MDL = "mdl"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val item: MdlMarket = intent.getParcelableExtra(EXTRA_MDL)!!

        tvMarketCode.text = item.category
        tvMarketName.text = item.market
        tvLastPrice.text = item.lastPrice
        tvTwoFour.text = item.percentage.toString()
        tvTwoFourHigh.text = item.high
        tvTwoFourLow.text = item.low
        tvVolume.text = item.vol_a



    }
}
