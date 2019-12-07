package com.don.tokenomy.data.remote

import android.util.Log
import android.view.View
import android.widget.LinearLayout
import com.don.tokenomy.api.TokenomyService
import com.don.tokenomy.utils.ConstantsFile.Companion.bchabc_btc
import com.don.tokenomy.utils.ConstantsFile.Companion.bchsv_btc
import com.don.tokenomy.utils.ConstantsFile.Companion.btc_idk
import com.don.tokenomy.utils.ConstantsFile.Companion.btc_usdt
import com.don.tokenomy.utils.ConstantsFile.Companion.btt_btc
import com.don.tokenomy.utils.ConstantsFile.Companion.eos_btc
import com.don.tokenomy.utils.ConstantsFile.Companion.etc_btc
import com.don.tokenomy.utils.ConstantsFile.Companion.eth_btc
import com.don.tokenomy.utils.ConstantsFile.Companion.eth_usdt
import com.don.tokenomy.utils.ConstantsFile.Companion.fgram_idk
import com.don.tokenomy.utils.ConstantsFile.Companion.fgram_usdt
import com.don.tokenomy.utils.ConstantsFile.Companion.hart_eth
import com.don.tokenomy.utils.ConstantsFile.Companion.hnst_btc
import com.don.tokenomy.utils.ConstantsFile.Companion.inx_eth
import com.don.tokenomy.utils.ConstantsFile.Companion.lrc_btc
import com.don.tokenomy.utils.ConstantsFile.Companion.ltc_btc
import com.don.tokenomy.utils.ConstantsFile.Companion.lyfe_btc
import com.don.tokenomy.utils.ConstantsFile.Companion.ont_btc
import com.don.tokenomy.utils.ConstantsFile.Companion.perl_btc
import com.don.tokenomy.utils.ConstantsFile.Companion.perl_idk
import com.don.tokenomy.utils.ConstantsFile.Companion.pxg_btc
import com.don.tokenomy.utils.ConstantsFile.Companion.scc_idk
import com.don.tokenomy.utils.ConstantsFile.Companion.six_btc
import com.don.tokenomy.utils.ConstantsFile.Companion.six_ten
import com.don.tokenomy.utils.ConstantsFile.Companion.swipe_btc
import com.don.tokenomy.utils.ConstantsFile.Companion.ten_btc
import com.don.tokenomy.utils.ConstantsFile.Companion.ten_eth
import com.don.tokenomy.utils.ConstantsFile.Companion.ten_usdt
import com.don.tokenomy.utils.ConstantsFile.Companion.trx_btc
import com.don.tokenomy.utils.ConstantsFile.Companion.trx_eth
import com.don.tokenomy.utils.ConstantsFile.Companion.usdt_idk
import com.don.tokenomy.utils.ConstantsFile.Companion.vex_btc
import com.don.tokenomy.utils.ConstantsFile.Companion.vex_ten
import com.don.tokenomy.utils.ConstantsFile.Companion.xlm_btc
import com.don.tokenomy.utils.ConstantsFile.Companion.xmr_btc
import com.don.tokenomy.utils.ConstantsFile.Companion.zec_btc
import com.google.gson.Gson
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

/**
 * Created by gideon on 06,December,2019
 * dunprek@gmail.com
 * Jakarta - Indonesia
 */
class RemoteRepository {

    fun getSummary(
            callback: LoadSummaryCallback,
            service: TokenomyService,
            progress: LinearLayout
    ) {
        //hardcoded t = dragon
        progress.visibility = View.VISIBLE
        service.getSummary()
                .enqueue(object : Callback<JsonObject> {
                    override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                        if (response.isSuccessful) {
                            if (response.body() != null) {
                                //Get response from JsonObject save itu into string
                                val jsonBody = response.body()!!.asJsonObject.toString()
                                Timber.d(jsonBody)

                                val gson = Gson()
                                val mdlTokenomy =
                                        gson.fromJson(jsonBody, MdlTokenomy::class.java)

                                /*  data class MdlMarket(
                                          var market:String,
                                          var category :String,
                                          var high:String,
                                          var low:String,
                                          var a:String,
                                          var b:String,
                                          var lastPrice:String,
                                          var buy:String,
                                          var sell:String,
                                          var percentage:Long)*/

                                /*

                                Count percentage
                                (price24 - price7) / price24 * 100
                                 */

//                                val df = DecimalFormat("#.#")
//                                df.roundingMode = RoundingMode.CEILING

//                                val formatter = DecimalFormat("#.#")


                                val percentageTenBtc = countPercentage(mdlTokenomy.prices24h.tenbtc.toFloat(), mdlTokenomy.prices7d.tenbtc.toFloat())


                                val percentageEthBtc = countPercentage(mdlTokenomy.prices24h.ethbtc.toFloat(), mdlTokenomy.prices7d.ethbtc.toFloat())


                                val percentageTrxBtc = countPercentage(mdlTokenomy.prices24h.trxbtc.toFloat(), mdlTokenomy.prices7d.trxbtc.toFloat())


                                val percentageLrcBtc = countPercentage(mdlTokenomy.prices24h.lrcbtc.toFloat(), mdlTokenomy.prices7d.lrcbtc.toFloat())


                                val percentageVexBtc = countPercentage(mdlTokenomy.prices24h.vexbtc.toFloat(), mdlTokenomy.prices7d.vexbtc.toFloat())


                                val percentageLtcBtc = countPercentage(mdlTokenomy.prices24h.ltcbtc.toFloat(), mdlTokenomy.prices7d.ltcbtc.toFloat())


                                val percentageBchabcBtc = countPercentage(mdlTokenomy.prices24h.bchabcbtc.toFloat(), mdlTokenomy.prices7d.bchabcbtc.toFloat())


                                val percentageBchsvBtc = countPercentage(mdlTokenomy.prices24h.bchsvbtc.toFloat(), mdlTokenomy.prices7d.bchsvbtc.toFloat())


                                val percentageEtcBtc = countPercentage(mdlTokenomy.prices24h.etcbtc.toFloat(), mdlTokenomy.prices7d.etcbtc.toFloat())


                                val percentageOntBtc = countPercentage(mdlTokenomy.prices24h.ontbtc.toFloat(), mdlTokenomy.prices7d.ontbtc.toFloat())


                                val percentageSixBtc = countPercentage(mdlTokenomy.prices24h.sixbtc.toFloat(), mdlTokenomy.prices7d.sixbtc.toFloat())


                                val percentageXlmBtc = countPercentage(mdlTokenomy.prices24h.xlmbtc.toFloat(), mdlTokenomy.prices7d.xlmbtc.toFloat())


                                val percentagePxgBtc = countPercentage(mdlTokenomy.prices24h.pxgbtc.toFloat(), mdlTokenomy.prices7d.pxgbtc.toFloat())


                                val percentageLyfeBtc = countPercentage(mdlTokenomy.prices24h.lyfebtc.toFloat(), mdlTokenomy.prices7d.lyfebtc.toFloat())


                                val percentageBttBtc = countPercentage(mdlTokenomy.prices24h.bttbtc.toFloat(), mdlTokenomy.prices7d.bttbtc.toFloat())


                                val percentageZecBtc = countPercentage(mdlTokenomy.prices24h.zecbtc.toFloat(), mdlTokenomy.prices7d.zecbtc.toFloat())


                                val percentageHnstBtc = countPercentage(mdlTokenomy.prices24h.hnstbtc.toFloat(), mdlTokenomy.prices7d.hnstbtc.toFloat())


                                val percentageSwipeBtc = countPercentage(mdlTokenomy.prices24h.swipebtc.toFloat(), mdlTokenomy.prices7d.swipebtc.toFloat())


                                val percentagePerlBtc = countPercentage(mdlTokenomy.prices24h.perlbtc.toFloat(), mdlTokenomy.prices7d.perlbtc.toFloat())


                                val percentageXmrBtc = countPercentage(mdlTokenomy.prices24h.xmrbtc.toFloat(), mdlTokenomy.prices7d.xmrbtc.toFloat())


                                val percentageEosBtc = countPercentage(mdlTokenomy.prices24h.eosbtc.toFloat(), mdlTokenomy.prices7d.eosbtc.toFloat())


                                val percentageTenEth = countPercentage(mdlTokenomy.prices24h.teneth.toFloat(), mdlTokenomy.prices7d.teneth.toFloat())


                                val percentageTrxEth = countPercentage(mdlTokenomy.prices24h.trxeth.toFloat(), mdlTokenomy.prices7d.trxeth.toFloat())


                                val percentageHartEth = countPercentage(mdlTokenomy.prices24h.harteth.toFloat(), mdlTokenomy.prices7d.harteth.toFloat())


                                val percentageInxEth = countPercentage(mdlTokenomy.prices24h.inxeth.toFloat(), mdlTokenomy.prices7d.inxeth.toFloat())


                                val percentageVexTen = countPercentage(mdlTokenomy.prices24h.vexten.toFloat(), mdlTokenomy.prices7d.vexten.toFloat())


                                val percentageSixTen = countPercentage(mdlTokenomy.prices24h.sixten.toFloat(), mdlTokenomy.prices7d.sixten.toFloat())


                                val percentageTenUsdt = countPercentage(mdlTokenomy.prices24h.tenusdt.toFloat(), mdlTokenomy.prices7d.tenusdt.toFloat())


                                val percentageBtcUsdt = countPercentage(mdlTokenomy.prices24h.btcusdt.toFloat(), mdlTokenomy.prices7d.btcusdt.toFloat())


                                val percentageEthUsdt = countPercentage(mdlTokenomy.prices24h.ethusdt.toFloat(), mdlTokenomy.prices7d.ethusdt.toFloat())


                                val percentageFgramUsdt = countPercentage(mdlTokenomy.prices24h.fgramusdt.toFloat(), mdlTokenomy.prices7d.fgramusdt.toFloat())


                                val percentageBtcIdk = countPercentage(mdlTokenomy.prices24h.btcidk.toFloat(), mdlTokenomy.prices7d.btcidk.toFloat())


                                val percentageUsdtIdk = countPercentage(mdlTokenomy.prices24h.usdtidk.toFloat(), mdlTokenomy.prices7d.usdtidk.toFloat())


                                val percentagePerlIdk = countPercentage(mdlTokenomy.prices24h.perlidk.toFloat(), mdlTokenomy.prices7d.perlidk.toFloat())


                                val percentageFgramIdk = countPercentage(mdlTokenomy.prices24h.fgramidk.toFloat(), mdlTokenomy.prices7d.fgramidk.toFloat())


                                val percentageSccIdk = countPercentage(mdlTokenomy.prices24h.sccidk.toFloat(), mdlTokenomy.prices7d.sccidk.toFloat())


                                val listMdlMarket = arrayListOf<MdlMarket>()

                                listMdlMarket.add(MdlMarket(
                                        ten_btc,
                                        "BTC",
                                        mdlTokenomy.tickers.tenBtc.high,
                                        mdlTokenomy.tickers.tenBtc.low,
                                        mdlTokenomy.tickers.tenBtc.volTen,
                                        mdlTokenomy.tickers.tenBtc.volBtc,
                                        mdlTokenomy.tickers.tenBtc.last,
                                        mdlTokenomy.tickers.tenBtc.buy,
                                        mdlTokenomy.tickers.tenBtc.sell,
                                        percentageTenBtc,
                                        mdlTokenomy.prices24h.tenbtc))
                                listMdlMarket.add(MdlMarket(
                                        eth_btc,
                                        "BTC",
                                        mdlTokenomy.tickers.ethBtc.high,
                                        mdlTokenomy.tickers.ethBtc.low,
                                        mdlTokenomy.tickers.ethBtc.volEth,
                                        mdlTokenomy.tickers.ethBtc.volBtc,
                                        mdlTokenomy.tickers.ethBtc.last,
                                        mdlTokenomy.tickers.ethBtc.buy,
                                        mdlTokenomy.tickers.ethBtc.sell,
                                        percentageEthBtc,
                                        mdlTokenomy.prices24h.ethbtc))
                                listMdlMarket.add(MdlMarket(
                                        trx_btc,
                                        "BTC",
                                        mdlTokenomy.tickers.trxBtc.high,
                                        mdlTokenomy.tickers.trxBtc.low,
                                        mdlTokenomy.tickers.trxBtc.volTrx,
                                        mdlTokenomy.tickers.trxBtc.volBtc,
                                        mdlTokenomy.tickers.trxBtc.last,
                                        mdlTokenomy.tickers.trxBtc.buy,
                                        mdlTokenomy.tickers.trxBtc.sell,
                                        percentageTrxBtc,
                                        mdlTokenomy.prices24h.trxbtc))

                                listMdlMarket.add(MdlMarket(
                                        lrc_btc,
                                        "BTC",
                                        mdlTokenomy.tickers.lrcBtc.high,
                                        mdlTokenomy.tickers.lrcBtc.low,
                                        mdlTokenomy.tickers.lrcBtc.volLrc,
                                        mdlTokenomy.tickers.lrcBtc.volBtc,
                                        mdlTokenomy.tickers.lrcBtc.last,
                                        mdlTokenomy.tickers.lrcBtc.buy,
                                        mdlTokenomy.tickers.lrcBtc.sell,
                                        percentageLrcBtc,
                                        mdlTokenomy.prices24h.lrcbtc))

                                listMdlMarket.add(MdlMarket(
                                        vex_btc,
                                        "BTC",
                                        mdlTokenomy.tickers.vexBtc.high,
                                        mdlTokenomy.tickers.vexBtc.low,
                                        mdlTokenomy.tickers.vexBtc.volVex,
                                        mdlTokenomy.tickers.vexBtc.volBtc,
                                        mdlTokenomy.tickers.vexBtc.last,
                                        mdlTokenomy.tickers.vexBtc.buy,
                                        mdlTokenomy.tickers.vexBtc.sell,
                                        percentageVexBtc,
                                        mdlTokenomy.prices24h.vexbtc))

                                listMdlMarket.add(MdlMarket(
                                        ltc_btc,
                                        "BTC",
                                        mdlTokenomy.tickers.ltcBtc.high,
                                        mdlTokenomy.tickers.ltcBtc.low,
                                        mdlTokenomy.tickers.ltcBtc.volLtc,
                                        mdlTokenomy.tickers.ltcBtc.volBtc,
                                        mdlTokenomy.tickers.ltcBtc.last,
                                        mdlTokenomy.tickers.ltcBtc.buy,
                                        mdlTokenomy.tickers.ltcBtc.sell,
                                        percentageLtcBtc,
                                        mdlTokenomy.prices24h.ltcbtc))

                                listMdlMarket.add(MdlMarket(
                                        bchabc_btc,
                                        "BTC",
                                        mdlTokenomy.tickers.bchabcBtc.high,
                                        mdlTokenomy.tickers.bchabcBtc.low,
                                        mdlTokenomy.tickers.bchabcBtc.volBchabc,
                                        mdlTokenomy.tickers.bchabcBtc.volBtc,
                                        mdlTokenomy.tickers.bchabcBtc.last,
                                        mdlTokenomy.tickers.bchabcBtc.buy,
                                        mdlTokenomy.tickers.bchabcBtc.sell,
                                        percentageBchabcBtc,
                                        mdlTokenomy.prices24h.bchabcbtc))


                                listMdlMarket.add(MdlMarket(
                                        bchsv_btc,
                                        "BTC",
                                        mdlTokenomy.tickers.bchsvBtc.high,
                                        mdlTokenomy.tickers.bchsvBtc.low,
                                        mdlTokenomy.tickers.bchsvBtc.volBchsv,
                                        mdlTokenomy.tickers.bchsvBtc.volBtc,
                                        mdlTokenomy.tickers.bchsvBtc.last,
                                        mdlTokenomy.tickers.bchsvBtc.convertedBuy,
                                        mdlTokenomy.tickers.bchsvBtc.convertedSell,
                                        percentageBchsvBtc,
                                        mdlTokenomy.prices24h.bchsvbtc))


                                listMdlMarket.add(MdlMarket(
                                        etc_btc,
                                        "BTC",
                                        mdlTokenomy.tickers.etcBtc.high,
                                        mdlTokenomy.tickers.etcBtc.low,
                                        mdlTokenomy.tickers.etcBtc.volEtc,
                                        mdlTokenomy.tickers.etcBtc.volBtc,
                                        mdlTokenomy.tickers.etcBtc.last,
                                        mdlTokenomy.tickers.etcBtc.buy,
                                        mdlTokenomy.tickers.etcBtc.sell,
                                        percentageEtcBtc,
                                        mdlTokenomy.prices24h.etcbtc))


                                listMdlMarket.add(MdlMarket(
                                        ont_btc,
                                        "BTC",
                                        mdlTokenomy.tickers.ontBtc.high,
                                        mdlTokenomy.tickers.ontBtc.low,
                                        mdlTokenomy.tickers.ontBtc.volOnt,
                                        mdlTokenomy.tickers.ontBtc.volBtc,
                                        mdlTokenomy.tickers.ontBtc.last,
                                        mdlTokenomy.tickers.ontBtc.buy,
                                        mdlTokenomy.tickers.ontBtc.sell,
                                        percentageOntBtc,
                                        mdlTokenomy.prices24h.ontbtc))


                                listMdlMarket.add(MdlMarket(
                                        six_btc,
                                        "BTC",
                                        mdlTokenomy.tickers.sixBtc.high,
                                        mdlTokenomy.tickers.sixBtc.low,
                                        mdlTokenomy.tickers.sixBtc.volSix,
                                        mdlTokenomy.tickers.sixBtc.volBtc,
                                        mdlTokenomy.tickers.sixBtc.last,
                                        mdlTokenomy.tickers.sixBtc.buy,
                                        mdlTokenomy.tickers.sixBtc.sell,
                                        percentageSixBtc,
                                        mdlTokenomy.prices24h.sixbtc))


                                listMdlMarket.add(MdlMarket(
                                        xlm_btc,
                                        "BTC",
                                        mdlTokenomy.tickers.xlmBtc.high,
                                        mdlTokenomy.tickers.xlmBtc.low,
                                        mdlTokenomy.tickers.xlmBtc.volXlm,
                                        mdlTokenomy.tickers.xlmBtc.volBtc,
                                        mdlTokenomy.tickers.xlmBtc.last,
                                        mdlTokenomy.tickers.xlmBtc.buy,
                                        mdlTokenomy.tickers.xlmBtc.sell,
                                        percentageXlmBtc,
                                        mdlTokenomy.prices24h.xlmbtc))


                                listMdlMarket.add(MdlMarket(
                                        pxg_btc,
                                        "BTC",
                                        mdlTokenomy.tickers.pxgBtc.high,
                                        mdlTokenomy.tickers.pxgBtc.low,
                                        mdlTokenomy.tickers.pxgBtc.volPxg,
                                        mdlTokenomy.tickers.pxgBtc.volBtc,
                                        mdlTokenomy.tickers.pxgBtc.last,
                                        mdlTokenomy.tickers.pxgBtc.buy,
                                        mdlTokenomy.tickers.pxgBtc.sell,
                                        percentagePxgBtc,
                                        mdlTokenomy.prices24h.pxgbtc))


                                listMdlMarket.add(MdlMarket(
                                        lyfe_btc,
                                        "BTC",
                                        mdlTokenomy.tickers.lyfeBtc.high,
                                        mdlTokenomy.tickers.lyfeBtc.low,
                                        mdlTokenomy.tickers.lyfeBtc.volLyfe,
                                        mdlTokenomy.tickers.lyfeBtc.volBtc,
                                        mdlTokenomy.tickers.lyfeBtc.last,
                                        mdlTokenomy.tickers.lyfeBtc.buy,
                                        mdlTokenomy.tickers.lyfeBtc.sell,
                                        percentageLyfeBtc,
                                        mdlTokenomy.prices24h.lyfebtc))


                                listMdlMarket.add(MdlMarket(
                                        btt_btc,
                                        "BTC",
                                        mdlTokenomy.tickers.bttBtc.high,
                                        mdlTokenomy.tickers.bttBtc.low,
                                        mdlTokenomy.tickers.bttBtc.volBtt,
                                        mdlTokenomy.tickers.bttBtc.volBtc,
                                        mdlTokenomy.tickers.bttBtc.last,
                                        mdlTokenomy.tickers.bttBtc.convertedBuy,
                                        mdlTokenomy.tickers.bttBtc.convertedSell,
                                        percentageBttBtc,
                                        mdlTokenomy.prices24h.bttbtc))


                                listMdlMarket.add(MdlMarket(
                                        zec_btc,
                                        "BTC",
                                        mdlTokenomy.tickers.zecBtc.high,
                                        mdlTokenomy.tickers.zecBtc.low,
                                        mdlTokenomy.tickers.zecBtc.volZec,
                                        mdlTokenomy.tickers.zecBtc.volBtc,
                                        mdlTokenomy.tickers.zecBtc.last,
                                        mdlTokenomy.tickers.zecBtc.buy,
                                        mdlTokenomy.tickers.zecBtc.sell,
                                        percentageZecBtc,
                                        mdlTokenomy.prices24h.zecbtc))


                                listMdlMarket.add(MdlMarket(
                                        hnst_btc,
                                        "BTC",
                                        mdlTokenomy.tickers.hnstBtc.high,
                                        mdlTokenomy.tickers.hnstBtc.low,
                                        mdlTokenomy.tickers.hnstBtc.volHnst,
                                        mdlTokenomy.tickers.hnstBtc.volBtc,
                                        mdlTokenomy.tickers.hnstBtc.last,
                                        mdlTokenomy.tickers.hnstBtc.buy,
                                        mdlTokenomy.tickers.hnstBtc.sell,
                                        percentageHnstBtc,
                                        mdlTokenomy.prices24h.hnstbtc))


                                listMdlMarket.add(MdlMarket(
                                        swipe_btc,
                                        "BTC",
                                        mdlTokenomy.tickers.swipeBtc.high,
                                        mdlTokenomy.tickers.swipeBtc.low,
                                        mdlTokenomy.tickers.swipeBtc.volSwipe,
                                        mdlTokenomy.tickers.swipeBtc.volBtc,
                                        mdlTokenomy.tickers.swipeBtc.last,
                                        mdlTokenomy.tickers.swipeBtc.buy,
                                        mdlTokenomy.tickers.swipeBtc.sell,
                                        percentageSwipeBtc,
                                        mdlTokenomy.prices24h.swipebtc))


                                listMdlMarket.add(MdlMarket(
                                        perl_btc,
                                        "BTC",
                                        mdlTokenomy.tickers.perlBtc.high,
                                        mdlTokenomy.tickers.perlBtc.low,
                                        mdlTokenomy.tickers.perlBtc.volPerl,
                                        mdlTokenomy.tickers.perlBtc.volBtc,
                                        mdlTokenomy.tickers.perlBtc.last,
                                        mdlTokenomy.tickers.perlBtc.convertedBuy,
                                        mdlTokenomy.tickers.perlBtc.convertedSell,
                                        percentagePerlBtc,
                                        mdlTokenomy.prices24h.perlbtc))

                                listMdlMarket.add(MdlMarket(
                                        xmr_btc,
                                        "BTC",
                                        mdlTokenomy.tickers.xmrBtc.high,
                                        mdlTokenomy.tickers.xmrBtc.low,
                                        mdlTokenomy.tickers.xmrBtc.volXmr,
                                        mdlTokenomy.tickers.xmrBtc.volBtc,
                                        mdlTokenomy.tickers.xmrBtc.last,
                                        mdlTokenomy.tickers.xmrBtc.convertedBuy,
                                        mdlTokenomy.tickers.xmrBtc.convertedSell,
                                        percentageXmrBtc,
                                        mdlTokenomy.prices24h.xmrbtc))


                                listMdlMarket.add(MdlMarket(
                                        eos_btc,
                                        "BTC",
                                        mdlTokenomy.tickers.eosBtc.high,
                                        mdlTokenomy.tickers.eosBtc.low,
                                        mdlTokenomy.tickers.eosBtc.volEos,
                                        mdlTokenomy.tickers.eosBtc.volBtc,
                                        mdlTokenomy.tickers.eosBtc.last,
                                        mdlTokenomy.tickers.eosBtc.buy,
                                        mdlTokenomy.tickers.eosBtc.sell,
                                        percentageEosBtc,
                                        mdlTokenomy.prices24h.eosbtc))


                                listMdlMarket.add(MdlMarket(
                                        ten_eth,
                                        "ETH",
                                        mdlTokenomy.tickers.tenEth.high,
                                        mdlTokenomy.tickers.tenEth.low,
                                        mdlTokenomy.tickers.tenEth.volTen,
                                        mdlTokenomy.tickers.tenEth.volEth,
                                        mdlTokenomy.tickers.tenEth.last,
                                        mdlTokenomy.tickers.tenEth.buy,
                                        mdlTokenomy.tickers.tenEth.sell,
                                        percentageTenEth,
                                        mdlTokenomy.prices24h.teneth))


                                listMdlMarket.add(MdlMarket(
                                        trx_eth,
                                        "ETH",
                                        mdlTokenomy.tickers.trxEth.high,
                                        mdlTokenomy.tickers.trxEth.low,
                                        mdlTokenomy.tickers.trxEth.volTrx,
                                        mdlTokenomy.tickers.trxEth.volEth,
                                        mdlTokenomy.tickers.trxEth.last,
                                        mdlTokenomy.tickers.trxEth.buy,
                                        mdlTokenomy.tickers.trxEth.sell,
                                        percentageTrxEth,
                                        mdlTokenomy.prices24h.trxeth))


                                listMdlMarket.add(MdlMarket(
                                        hart_eth,
                                        "ETH",
                                        mdlTokenomy.tickers.hartEth.high,
                                        mdlTokenomy.tickers.hartEth.low,
                                        mdlTokenomy.tickers.hartEth.volHart,
                                        mdlTokenomy.tickers.hartEth.volEth,
                                        mdlTokenomy.tickers.hartEth.last,
                                        mdlTokenomy.tickers.hartEth.buy,
                                        mdlTokenomy.tickers.hartEth.sell,
                                        percentageHartEth,
                                        mdlTokenomy.prices24h.harteth))


                                listMdlMarket.add(MdlMarket(
                                        inx_eth,
                                        "ETH",
                                        mdlTokenomy.tickers.inxEth.high,
                                        mdlTokenomy.tickers.inxEth.low,
                                        mdlTokenomy.tickers.inxEth.volInx,
                                        mdlTokenomy.tickers.inxEth.volEth,
                                        mdlTokenomy.tickers.inxEth.last,
                                        mdlTokenomy.tickers.inxEth.buy,
                                        mdlTokenomy.tickers.inxEth.sell,
                                        percentageInxEth,
                                        mdlTokenomy.prices24h.inxeth))


                                listMdlMarket.add(MdlMarket(
                                        vex_ten,
                                        "TEN",
                                        mdlTokenomy.tickers.vexTen.high,
                                        mdlTokenomy.tickers.vexTen.low,
                                        mdlTokenomy.tickers.vexTen.volVex,
                                        mdlTokenomy.tickers.vexTen.volTen,
                                        mdlTokenomy.tickers.vexTen.last,
                                        mdlTokenomy.tickers.vexTen.buy,
                                        mdlTokenomy.tickers.vexTen.sell,
                                        percentageVexTen,
                                        mdlTokenomy.prices24h.vexten))

                                listMdlMarket.add(MdlMarket(
                                        six_ten,
                                        "TEN",
                                        mdlTokenomy.tickers.sixTen.high,
                                        mdlTokenomy.tickers.sixTen.low,
                                        mdlTokenomy.tickers.sixTen.volSix,
                                        mdlTokenomy.tickers.sixTen.volTen,
                                        mdlTokenomy.tickers.sixTen.last,
                                        mdlTokenomy.tickers.sixTen.convertedBuy,
                                        mdlTokenomy.tickers.sixTen.convertedSell,
                                        percentageSixTen,
                                        mdlTokenomy.prices24h.sixten))


                                listMdlMarket.add(MdlMarket(
                                        ten_usdt,
                                        "USDT",
                                        mdlTokenomy.tickers.tenUsdt.high,
                                        mdlTokenomy.tickers.tenUsdt.low,
                                        mdlTokenomy.tickers.tenUsdt.volTen,
                                        mdlTokenomy.tickers.tenUsdt.volUsdt,
                                        mdlTokenomy.tickers.tenUsdt.last,
                                        mdlTokenomy.tickers.tenUsdt.buy,
                                        mdlTokenomy.tickers.tenUsdt.sell,
                                        percentageTenUsdt,
                                        mdlTokenomy.prices24h.tenusdt))


                                listMdlMarket.add(MdlMarket(
                                        btc_usdt,
                                        "USDT",
                                        mdlTokenomy.tickers.btcUsdt.high,
                                        mdlTokenomy.tickers.btcUsdt.low,
                                        mdlTokenomy.tickers.btcUsdt.volBtc,
                                        mdlTokenomy.tickers.btcUsdt.volUsdt,
                                        mdlTokenomy.tickers.btcUsdt.last,
                                        mdlTokenomy.tickers.btcUsdt.buy,
                                        mdlTokenomy.tickers.btcUsdt.sell,
                                        percentageBtcUsdt,
                                        mdlTokenomy.prices24h.btcusdt))


                                listMdlMarket.add(MdlMarket(
                                        eth_usdt,
                                        "USDT",
                                        mdlTokenomy.tickers.ethUsdt.high,
                                        mdlTokenomy.tickers.ethUsdt.low,
                                        mdlTokenomy.tickers.ethUsdt.volEth,
                                        mdlTokenomy.tickers.ethUsdt.volUsdt,
                                        mdlTokenomy.tickers.ethUsdt.last,
                                        mdlTokenomy.tickers.ethUsdt.buy,
                                        mdlTokenomy.tickers.ethUsdt.sell,
                                        percentageEthUsdt,
                                        mdlTokenomy.prices24h.ethusdt))


                                listMdlMarket.add(MdlMarket(
                                        fgram_usdt,
                                        "USDT",
                                        mdlTokenomy.tickers.fgramUsdt.high,
                                        mdlTokenomy.tickers.fgramUsdt.low,
                                        mdlTokenomy.tickers.fgramUsdt.volFgram,
                                        mdlTokenomy.tickers.fgramUsdt.volUsdt,
                                        mdlTokenomy.tickers.fgramUsdt.last,
                                        mdlTokenomy.tickers.fgramUsdt.buy,
                                        mdlTokenomy.tickers.fgramUsdt.sell,
                                        percentageFgramUsdt,
                                        mdlTokenomy.prices24h.fgramusdt))


                                listMdlMarket.add(MdlMarket(
                                        btc_idk,
                                        "IDK",
                                        mdlTokenomy.tickers.btcIdk.high,
                                        mdlTokenomy.tickers.btcIdk.low,
                                        mdlTokenomy.tickers.btcIdk.volBtc,
                                        mdlTokenomy.tickers.btcIdk.volIdk,
                                        mdlTokenomy.tickers.btcIdk.last,
                                        mdlTokenomy.tickers.btcIdk.buy,
                                        mdlTokenomy.tickers.btcIdk.sell,
                                        percentageBtcIdk,
                                        mdlTokenomy.prices24h.btcidk))



                                listMdlMarket.add(MdlMarket(
                                        usdt_idk,
                                        "IDK",
                                        mdlTokenomy.tickers.usdtIdk.high,
                                        mdlTokenomy.tickers.usdtIdk.low,
                                        mdlTokenomy.tickers.usdtIdk.volUsdt,
                                        mdlTokenomy.tickers.usdtIdk.volIdk,
                                        mdlTokenomy.tickers.usdtIdk.last,
                                        mdlTokenomy.tickers.usdtIdk.buy,
                                        mdlTokenomy.tickers.usdtIdk.sell,
                                        percentageUsdtIdk,
                                        mdlTokenomy.prices24h.usdtidk))


                                listMdlMarket.add(MdlMarket(
                                        perl_idk,
                                        "IDK",
                                        mdlTokenomy.tickers.perlIdk.high,
                                        mdlTokenomy.tickers.perlIdk.low,
                                        mdlTokenomy.tickers.perlIdk.volPerl,
                                        mdlTokenomy.tickers.perlIdk.volIdk,
                                        mdlTokenomy.tickers.perlIdk.last,
                                        mdlTokenomy.tickers.perlIdk.convertedBuy,
                                        mdlTokenomy.tickers.perlIdk.convertedSell,
                                        percentagePerlIdk,
                                        mdlTokenomy.prices24h.perlidk))


                                listMdlMarket.add(MdlMarket(
                                        fgram_idk,
                                        "IDK",
                                        mdlTokenomy.tickers.fgramIdk.high,
                                        mdlTokenomy.tickers.fgramIdk.low,
                                        mdlTokenomy.tickers.fgramIdk.volFgram,
                                        mdlTokenomy.tickers.fgramIdk.volIdk,
                                        mdlTokenomy.tickers.fgramIdk.last,
                                        mdlTokenomy.tickers.fgramIdk.buy,
                                        mdlTokenomy.tickers.fgramIdk.sell,
                                        percentageFgramIdk,
                                        mdlTokenomy.prices24h.fgramidk))


                                listMdlMarket.add(MdlMarket(
                                        scc_idk,
                                        "IDK",
                                        mdlTokenomy.tickers.sccIdk.high,
                                        mdlTokenomy.tickers.sccIdk.low,
                                        mdlTokenomy.tickers.sccIdk.volScc,
                                        mdlTokenomy.tickers.sccIdk.volIdk,
                                        mdlTokenomy.tickers.sccIdk.last,
                                        mdlTokenomy.tickers.sccIdk.buy,
                                        mdlTokenomy.tickers.sccIdk.sell,
                                        percentageSccIdk,
                                        mdlTokenomy.prices24h.sccidk))


                                //add the  result to 'list'
                                callback.onSummaryReceived(listMdlMarket)


                                Log.e("ERROR", listMdlMarket.toString())

                                /*   var percentageTenBtc =
                                           ((mdlTokenomy.prices24h.tenbtc.toFloat() - mdlTokenomy.prices7d.tenbtc.toFloat())
                                                   / (mdlTokenomy.prices24h.tenbtc.toFloat() * 100f))*/

                                val testOne = mdlTokenomy.prices24h.tenbtc.toFloat() - mdlTokenomy.prices7d.tenbtc.toFloat()
                                val testTwo = testOne / (mdlTokenomy.prices24h.tenbtc.toFloat())
                                val testThree = testTwo * 100f

                                Log.e("ERROR", mdlTokenomy.prices24h.tenbtc.toFloat().toString())
                                Log.e("ERROR", mdlTokenomy.prices7d.tenbtc.toFloat().toString())
                                Log.e("ERROR", testOne.toString())
                                Log.e("ERROR", testTwo.toString())
                                Log.e("ERROR", testThree.toString())
                                Log.e("ERROR", listMdlMarket.size.toString())

                            }
                            progress.visibility = View.GONE
                        }
                    }

                    override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                        Timber.e(t, "Failed to get movies!")
                        progress.visibility = View.GONE
//                        errorResponse.postValue(t.message.toString())
                        callback.onDataNotAvailable(t.message.toString())
                    }
                })
    }


    interface LoadSummaryCallback {
        fun onSummaryReceived(market: List<MdlMarket>)
        fun onDataNotAvailable(response: String)
    }

    fun countPercentage(f1: Float, f2: Float): Float {
        val testOne = f1 - f2
        val testTwo = testOne / f1
        val testThree = testTwo * 100f
        val formatted = String.format("%.1f", testThree)

        return formatted.toFloat()
    }


}