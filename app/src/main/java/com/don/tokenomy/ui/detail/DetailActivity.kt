package com.don.tokenomy.ui.detail

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
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

        //setup toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.elevation = 0f
        toolbar.setNavigationIcon(R.drawable.ic_arrow_left)
        toolbar.setNavigationOnClickListener {
            finish()
        }


        tvMarketCode.text = item.category
        tvMarketName.text = item.market
        tvLastPrice.text = item.lastPrice


        if (item.percentage <= -0f) {
            tvTwoFour.text = item.percentage.toString() + " " + "%"
            tvTwoFour.setTextColor(resources.getColor(R.color.colorRed))

        }

        if (item.percentage > 0f) {
            tvTwoFour.text = item.percentage.toString()
            tvTwoFour.setTextColor(resources.getColor(R.color.colorGreen))
        }

        tvTwoFourHigh.text = item.high
        tvTwoFourHigh.setTextColor(resources.getColor(R.color.colorGreen))

        tvTwoFourLow.text = item.low
        tvTwoFourLow.setTextColor(resources.getColor(R.color.colorRed))

        tvVolume.text = item.vol_a


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return true
    }


}
