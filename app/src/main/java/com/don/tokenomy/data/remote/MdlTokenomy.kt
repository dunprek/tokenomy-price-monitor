package com.don.tokenomy.data.remote


import com.google.gson.annotations.SerializedName

data class MdlTokenomy(
        @SerializedName("prices_24h")
        var prices24h: Prices24h,
        @SerializedName("prices_7d")
        var prices7d: Prices7d,
        @SerializedName("server_time")
        var serverTime: Int,
        @SerializedName("tickers")
        var tickers: Tickers
) {
    data class Prices24h(
            @SerializedName("bchabcbtc")
            var bchabcbtc: String,
            @SerializedName("bchsvbtc")
            var bchsvbtc: String,
            @SerializedName("btcidk")
            var btcidk: String,
            @SerializedName("btcusdt")
            var btcusdt: String,
            @SerializedName("bttbtc")
            var bttbtc: String,
            @SerializedName("eosbtc")
            var eosbtc: String,
            @SerializedName("etcbtc")
            var etcbtc: String,
            @SerializedName("ethbtc")
            var ethbtc: String,
            @SerializedName("ethusdt")
            var ethusdt: String,
            @SerializedName("fgramidk")
            var fgramidk: String,
            @SerializedName("fgramusdt")
            var fgramusdt: String,
            @SerializedName("harteth")
            var harteth: String,
            @SerializedName("hnstbtc")
            var hnstbtc: String,
            @SerializedName("inxeth")
            var inxeth: String,
            @SerializedName("lrcbtc")
            var lrcbtc: String,
            @SerializedName("ltcbtc")
            var ltcbtc: String,
            @SerializedName("lyfebtc")
            var lyfebtc: String,
            @SerializedName("ontbtc")
            var ontbtc: String,
            @SerializedName("perlbtc")
            var perlbtc: String,
            @SerializedName("perlidk")
            var perlidk: String,
            @SerializedName("pxgbtc")
            var pxgbtc: String,
            @SerializedName("sccidk")
            var sccidk: String,
            @SerializedName("sixbtc")
            var sixbtc: String,
            @SerializedName("sixten")
            var sixten: String,
            @SerializedName("swipebtc")
            var swipebtc: String,
            @SerializedName("tenbtc")
            var tenbtc: String,
            @SerializedName("teneth")
            var teneth: String,
            @SerializedName("tenusdt")
            var tenusdt: String,
            @SerializedName("trxbtc")
            var trxbtc: String,
            @SerializedName("trxeth")
            var trxeth: String,
            @SerializedName("usdtidk")
            var usdtidk: String,
            @SerializedName("vexbtc")
            var vexbtc: String,
            @SerializedName("vexten")
            var vexten: String,
            @SerializedName("xlmbtc")
            var xlmbtc: String,
            @SerializedName("xmrbtc")
            var xmrbtc: String,
            @SerializedName("zecbtc")
            var zecbtc: String
    )

    data class Prices7d(
            @SerializedName("bchabcbtc")
            var bchabcbtc: String,
            @SerializedName("bchsvbtc")
            var bchsvbtc: String,
            @SerializedName("btcidk")
            var btcidk: String,
            @SerializedName("btcusdt")
            var btcusdt: String,
            @SerializedName("bttbtc")
            var bttbtc: String,
            @SerializedName("eosbtc")
            var eosbtc: String,
            @SerializedName("etcbtc")
            var etcbtc: String,
            @SerializedName("ethbtc")
            var ethbtc: String,
            @SerializedName("ethusdt")
            var ethusdt: String,
            @SerializedName("fgramidk")
            var fgramidk: String,
            @SerializedName("fgramusdt")
            var fgramusdt: String,
            @SerializedName("harteth")
            var harteth: String,
            @SerializedName("hnstbtc")
            var hnstbtc: String,
            @SerializedName("inxeth")
            var inxeth: String,
            @SerializedName("lrcbtc")
            var lrcbtc: String,
            @SerializedName("ltcbtc")
            var ltcbtc: String,
            @SerializedName("lyfebtc")
            var lyfebtc: String,
            @SerializedName("ontbtc")
            var ontbtc: String,
            @SerializedName("perlbtc")
            var perlbtc: String,
            @SerializedName("perlidk")
            var perlidk: String,
            @SerializedName("pxgbtc")
            var pxgbtc: String,
            @SerializedName("sccidk")
            var sccidk: String,
            @SerializedName("sixbtc")
            var sixbtc: String,
            @SerializedName("sixten")
            var sixten: String,
            @SerializedName("swipebtc")
            var swipebtc: String,
            @SerializedName("tenbtc")
            var tenbtc: String,
            @SerializedName("teneth")
            var teneth: String,
            @SerializedName("tenusdt")
            var tenusdt: String,
            @SerializedName("trxbtc")
            var trxbtc: String,
            @SerializedName("trxeth")
            var trxeth: String,
            @SerializedName("usdtidk")
            var usdtidk: String,
            @SerializedName("vexbtc")
            var vexbtc: String,
            @SerializedName("vexten")
            var vexten: String,
            @SerializedName("xlmbtc")
            var xlmbtc: String,
            @SerializedName("xmrbtc")
            var xmrbtc: String,
            @SerializedName("zecbtc")
            var zecbtc: String
    )

    data class Tickers(
            @SerializedName("bchabc_btc")
            var bchabcBtc: BchabcBtc,
            @SerializedName("bchsv_btc")
            var bchsvBtc: BchsvBtc,
            @SerializedName("btc_idk")
            var btcIdk: BtcIdk,
            @SerializedName("btc_usdt")
            var btcUsdt: BtcUsdt,
            @SerializedName("btt_btc")
            var bttBtc: BttBtc,
            @SerializedName("eos_btc")
            var eosBtc: EosBtc,
            @SerializedName("etc_btc")
            var etcBtc: EtcBtc,
            @SerializedName("eth_btc")
            var ethBtc: EthBtc,
            @SerializedName("eth_usdt")
            var ethUsdt: EthUsdt,
            @SerializedName("fgram_idk")
            var fgramIdk: FgramIdk,
            @SerializedName("fgram_usdt")
            var fgramUsdt: FgramUsdt,
            @SerializedName("hart_eth")
            var hartEth: HartEth,
            @SerializedName("hnst_btc")
            var hnstBtc: HnstBtc,
            @SerializedName("inx_eth")
            var inxEth: InxEth,
            @SerializedName("lrc_btc")
            var lrcBtc: LrcBtc,
            @SerializedName("ltc_btc")
            var ltcBtc: LtcBtc,
            @SerializedName("lyfe_btc")
            var lyfeBtc: LyfeBtc,
            @SerializedName("ont_btc")
            var ontBtc: OntBtc,
            @SerializedName("perl_btc")
            var perlBtc: PerlBtc,
            @SerializedName("perl_idk")
            var perlIdk: PerlIdk,
            @SerializedName("pxg_btc")
            var pxgBtc: PxgBtc,
            @SerializedName("scc_idk")
            var sccIdk: SccIdk,
            @SerializedName("six_btc")
            var sixBtc: SixBtc,
            @SerializedName("six_ten")
            var sixTen: SixTen,
            @SerializedName("swipe_btc")
            var swipeBtc: SwipeBtc,
            @SerializedName("ten_btc")
            var tenBtc: TenBtc,
            @SerializedName("ten_eth")
            var tenEth: TenEth,
            @SerializedName("ten_usdt")
            var tenUsdt: TenUsdt,
            @SerializedName("trx_btc")
            var trxBtc: TrxBtc,
            @SerializedName("trx_eth")
            var trxEth: TrxEth,
            @SerializedName("usdt_idk")
            var usdtIdk: UsdtIdk,
            @SerializedName("vex_btc")
            var vexBtc: VexBtc,
            @SerializedName("vex_ten")
            var vexTen: VexTen,
            @SerializedName("xlm_btc")
            var xlmBtc: XlmBtc,
            @SerializedName("xmr_btc")
            var xmrBtc: XmrBtc,
            @SerializedName("zec_btc")
            var zecBtc: ZecBtc
    ) {
        data class BchabcBtc(
                @SerializedName("buy")
                var buy: String,
                @SerializedName("high")
                var high: String,
                @SerializedName("last")
                var last: String,
                @SerializedName("low")
                var low: String,
                @SerializedName("name")
                var name: String,
                @SerializedName("sell")
                var sell: String,
                @SerializedName("vol_bchabc")
                var volBchabc: String,
                @SerializedName("vol_btc")
                var volBtc: String
        )

        data class BchsvBtc(
                @SerializedName("buy")
                var buy: Int,
                @SerializedName("high")
                var high: String,
                @SerializedName("last")
                var last: String,
                @SerializedName("low")
                var low: String,
                @SerializedName("name")
                var name: String,
                @SerializedName("sell")
                var sell: Int,
                @SerializedName("vol_bchsv")
                var volBchsv: String,
                @SerializedName("vol_btc")
                var volBtc: String
        ) {
            var convertedBuy = buy.toString()
            var convertedSell = sell.toString()
        }

        data class BtcIdk(
                @SerializedName("buy")
                var buy: String,
                @SerializedName("high")
                var high: String,
                @SerializedName("last")
                var last: String,
                @SerializedName("low")
                var low: String,
                @SerializedName("name")
                var name: String,
                @SerializedName("sell")
                var sell: String,
                @SerializedName("vol_btc")
                var volBtc: String,
                @SerializedName("vol_idk")
                var volIdk: String
        )

        data class BtcUsdt(
                @SerializedName("buy")
                var buy: String,
                @SerializedName("high")
                var high: String,
                @SerializedName("last")
                var last: String,
                @SerializedName("low")
                var low: String,
                @SerializedName("name")
                var name: String,
                @SerializedName("sell")
                var sell: String,
                @SerializedName("vol_btc")
                var volBtc: String,
                @SerializedName("vol_usdt")
                var volUsdt: String
        )

        data class BttBtc(
                @SerializedName("buy")
                var buy: Int,
                @SerializedName("high")
                var high: String,
                @SerializedName("last")
                var last: String,
                @SerializedName("low")
                var low: String,
                @SerializedName("name")
                var name: String,
                @SerializedName("sell")
                var sell: Int,
                @SerializedName("vol_btc")
                var volBtc: String,
                @SerializedName("vol_btt")
                var volBtt: String
        ) {
            var convertedBuy = buy.toString()
            var convertedSell = sell.toString()
        }

        data class EosBtc(
                @SerializedName("buy")
                var buy: String,
                @SerializedName("high")
                var high: String,
                @SerializedName("last")
                var last: String,
                @SerializedName("low")
                var low: String,
                @SerializedName("name")
                var name: String,
                @SerializedName("sell")
                var sell: String,
                @SerializedName("vol_btc")
                var volBtc: String,
                @SerializedName("vol_eos")
                var volEos: String
        )

        data class EtcBtc(
                @SerializedName("buy")
                var buy: String,
                @SerializedName("high")
                var high: String,
                @SerializedName("last")
                var last: String,
                @SerializedName("low")
                var low: String,
                @SerializedName("name")
                var name: String,
                @SerializedName("sell")
                var sell: String,
                @SerializedName("vol_btc")
                var volBtc: String,
                @SerializedName("vol_etc")
                var volEtc: String
        )

        data class EthBtc(
                @SerializedName("buy")
                var buy: String,
                @SerializedName("high")
                var high: String,
                @SerializedName("last")
                var last: String,
                @SerializedName("low")
                var low: String,
                @SerializedName("name")
                var name: String,
                @SerializedName("sell")
                var sell: String,
                @SerializedName("vol_btc")
                var volBtc: String,
                @SerializedName("vol_eth")
                var volEth: String
        )

        data class EthUsdt(
                @SerializedName("buy")
                var buy: String,
                @SerializedName("high")
                var high: String,
                @SerializedName("last")
                var last: String,
                @SerializedName("low")
                var low: String,
                @SerializedName("name")
                var name: String,
                @SerializedName("sell")
                var sell: String,
                @SerializedName("vol_eth")
                var volEth: String,
                @SerializedName("vol_usdt")
                var volUsdt: String
        )

        data class FgramIdk(
                @SerializedName("buy")
                var buy: String,
                @SerializedName("high")
                var high: String,
                @SerializedName("last")
                var last: String,
                @SerializedName("low")
                var low: String,
                @SerializedName("name")
                var name: String,
                @SerializedName("sell")
                var sell: String,
                @SerializedName("vol_fgram")
                var volFgram: String,
                @SerializedName("vol_idk")
                var volIdk: String
        )

        data class FgramUsdt(
                @SerializedName("buy")
                var buy: String,
                @SerializedName("high")
                var high: String,
                @SerializedName("last")
                var last: String,
                @SerializedName("low")
                var low: String,
                @SerializedName("name")
                var name: String,
                @SerializedName("sell")
                var sell: String,
                @SerializedName("vol_fgram")
                var volFgram: String,
                @SerializedName("vol_usdt")
                var volUsdt: String
        )

        data class HartEth(
                @SerializedName("buy")
                var buy: String,
                @SerializedName("high")
                var high: String,
                @SerializedName("last")
                var last: String,
                @SerializedName("low")
                var low: String,
                @SerializedName("name")
                var name: String,
                @SerializedName("sell")
                var sell: String,
                @SerializedName("vol_eth")
                var volEth: String,
                @SerializedName("vol_hart")
                var volHart: String
        )

        data class HnstBtc(
                @SerializedName("buy")
                var buy: String,
                @SerializedName("high")
                var high: String,
                @SerializedName("last")
                var last: String,
                @SerializedName("low")
                var low: String,
                @SerializedName("name")
                var name: String,
                @SerializedName("sell")
                var sell: String,
                @SerializedName("vol_btc")
                var volBtc: String,
                @SerializedName("vol_hnst")
                var volHnst: String
        )

        data class InxEth(
                @SerializedName("buy")
                var buy: String,
                @SerializedName("high")
                var high: String,
                @SerializedName("last")
                var last: String,
                @SerializedName("low")
                var low: String,
                @SerializedName("name")
                var name: String,
                @SerializedName("sell")
                var sell: String,
                @SerializedName("vol_eth")
                var volEth: String,
                @SerializedName("vol_inx")
                var volInx: String
        )

        data class LrcBtc(
                @SerializedName("buy")
                var buy: String,
                @SerializedName("high")
                var high: String,
                @SerializedName("last")
                var last: String,
                @SerializedName("low")
                var low: String,
                @SerializedName("name")
                var name: String,
                @SerializedName("sell")
                var sell: String,
                @SerializedName("vol_btc")
                var volBtc: String,
                @SerializedName("vol_lrc")
                var volLrc: String
        )

        data class LtcBtc(
                @SerializedName("buy")
                var buy: String,
                @SerializedName("high")
                var high: String,
                @SerializedName("last")
                var last: String,
                @SerializedName("low")
                var low: String,
                @SerializedName("name")
                var name: String,
                @SerializedName("sell")
                var sell: String,
                @SerializedName("vol_btc")
                var volBtc: String,
                @SerializedName("vol_ltc")
                var volLtc: String
        )

        data class LyfeBtc(
                @SerializedName("buy")
                var buy: String,
                @SerializedName("high")
                var high: String,
                @SerializedName("last")
                var last: String,
                @SerializedName("low")
                var low: String,
                @SerializedName("name")
                var name: String,
                @SerializedName("sell")
                var sell: String,
                @SerializedName("vol_btc")
                var volBtc: String,
                @SerializedName("vol_lyfe")
                var volLyfe: String
        )

        data class OntBtc(
                @SerializedName("buy")
                var buy: String,
                @SerializedName("high")
                var high: String,
                @SerializedName("last")
                var last: String,
                @SerializedName("low")
                var low: String,
                @SerializedName("name")
                var name: String,
                @SerializedName("sell")
                var sell: String,
                @SerializedName("vol_btc")
                var volBtc: String,
                @SerializedName("vol_ont")
                var volOnt: String
        )

        data class PerlBtc(
                @SerializedName("buy")
                var buy: Int,
                @SerializedName("high")
                var high: String,
                @SerializedName("last")
                var last: String,
                @SerializedName("low")
                var low: String,
                @SerializedName("name")
                var name: String,
                @SerializedName("sell")
                var sell: Int,
                @SerializedName("vol_btc")
                var volBtc: String,
                @SerializedName("vol_perl")
                var volPerl: String
        ) {
            var convertedBuy = buy.toString()
            var convertedSell = sell.toString()
        }

        data class PerlIdk(
                @SerializedName("buy")
                var buy: Int,
                @SerializedName("high")
                var high: String,
                @SerializedName("last")
                var last: String,
                @SerializedName("low")
                var low: String,
                @SerializedName("name")
                var name: String,
                @SerializedName("sell")
                var sell: Int,
                @SerializedName("vol_idk")
                var volIdk: String,
                @SerializedName("vol_perl")
                var volPerl: String
        ) {

            var convertedBuy = buy.toString()
            var convertedSell = sell.toString()

        }

        data class PxgBtc(
                @SerializedName("buy")
                var buy: String,
                @SerializedName("high")
                var high: String,
                @SerializedName("last")
                var last: String,
                @SerializedName("low")
                var low: String,
                @SerializedName("name")
                var name: String,
                @SerializedName("sell")
                var sell: String,
                @SerializedName("vol_btc")
                var volBtc: String,
                @SerializedName("vol_pxg")
                var volPxg: String
        )

        data class SccIdk(
                @SerializedName("buy")
                var buy: String,
                @SerializedName("high")
                var high: String,
                @SerializedName("last")
                var last: String,
                @SerializedName("low")
                var low: String,
                @SerializedName("name")
                var name: String,
                @SerializedName("sell")
                var sell: String,
                @SerializedName("vol_idk")
                var volIdk: String,
                @SerializedName("vol_scc")
                var volScc: String
        )

        data class SixBtc(
                @SerializedName("buy")
                var buy: String,
                @SerializedName("high")
                var high: String,
                @SerializedName("last")
                var last: String,
                @SerializedName("low")
                var low: String,
                @SerializedName("name")
                var name: String,
                @SerializedName("sell")
                var sell: String,
                @SerializedName("vol_btc")
                var volBtc: String,
                @SerializedName("vol_six")
                var volSix: String
        )

        data class SixTen(
                @SerializedName("buy")
                var buy: Int,
                @SerializedName("high")
                var high: String,
                @SerializedName("last")
                var last: String,
                @SerializedName("low")
                var low: String,
                @SerializedName("name")
                var name: String,
                @SerializedName("sell")
                var sell: Int,
                @SerializedName("vol_six")
                var volSix: String,
                @SerializedName("vol_ten")
                var volTen: String
        ) {
            var convertedBuy = buy.toString()
            var convertedSell = sell.toString()
        }

        data class SwipeBtc(
                @SerializedName("buy")
                var buy: String,
                @SerializedName("high")
                var high: String,
                @SerializedName("last")
                var last: String,
                @SerializedName("low")
                var low: String,
                @SerializedName("name")
                var name: String,
                @SerializedName("sell")
                var sell: String,
                @SerializedName("vol_btc")
                var volBtc: String,
                @SerializedName("vol_swipe")
                var volSwipe: String
        )

        data class TenBtc(
                @SerializedName("buy")
                var buy: String,
                @SerializedName("high")
                var high: String,
                @SerializedName("last")
                var last: String,
                @SerializedName("low")
                var low: String,
                @SerializedName("name")
                var name: String,
                @SerializedName("sell")
                var sell: String,
                @SerializedName("vol_btc")
                var volBtc: String,
                @SerializedName("vol_ten")
                var volTen: String
        )

        data class TenEth(
                @SerializedName("buy")
                var buy: String,
                @SerializedName("high")
                var high: String,
                @SerializedName("last")
                var last: String,
                @SerializedName("low")
                var low: String,
                @SerializedName("name")
                var name: String,
                @SerializedName("sell")
                var sell: String,
                @SerializedName("vol_eth")
                var volEth: String,
                @SerializedName("vol_ten")
                var volTen: String
        )

        data class TenUsdt(
                @SerializedName("buy")
                var buy: String,
                @SerializedName("high")
                var high: String,
                @SerializedName("last")
                var last: String,
                @SerializedName("low")
                var low: String,
                @SerializedName("name")
                var name: String,
                @SerializedName("sell")
                var sell: String,
                @SerializedName("vol_ten")
                var volTen: String,
                @SerializedName("vol_usdt")
                var volUsdt: String
        )

        data class TrxBtc(
                @SerializedName("buy")
                var buy: String,
                @SerializedName("high")
                var high: String,
                @SerializedName("last")
                var last: String,
                @SerializedName("low")
                var low: String,
                @SerializedName("name")
                var name: String,
                @SerializedName("sell")
                var sell: String,
                @SerializedName("vol_btc")
                var volBtc: String,
                @SerializedName("vol_trx")
                var volTrx: String
        )

        data class TrxEth(
                @SerializedName("buy")
                var buy: String,
                @SerializedName("high")
                var high: String,
                @SerializedName("last")
                var last: String,
                @SerializedName("low")
                var low: String,
                @SerializedName("name")
                var name: String,
                @SerializedName("sell")
                var sell: String,
                @SerializedName("vol_eth")
                var volEth: String,
                @SerializedName("vol_trx")
                var volTrx: String
        )

        data class UsdtIdk(
                @SerializedName("buy")
                var buy: String,
                @SerializedName("high")
                var high: String,
                @SerializedName("last")
                var last: String,
                @SerializedName("low")
                var low: String,
                @SerializedName("name")
                var name: String,
                @SerializedName("sell")
                var sell: String,
                @SerializedName("vol_idk")
                var volIdk: String,
                @SerializedName("vol_usdt")
                var volUsdt: String
        )

        data class VexBtc(
                @SerializedName("buy")
                var buy: String,
                @SerializedName("high")
                var high: String,
                @SerializedName("last")
                var last: String,
                @SerializedName("low")
                var low: String,
                @SerializedName("name")
                var name: String,
                @SerializedName("sell")
                var sell: String,
                @SerializedName("vol_btc")
                var volBtc: String,
                @SerializedName("vol_vex")
                var volVex: String
        )

        data class VexTen(
                @SerializedName("buy")
                var buy: String,
                @SerializedName("high")
                var high: String,
                @SerializedName("last")
                var last: String,
                @SerializedName("low")
                var low: String,
                @SerializedName("name")
                var name: String,
                @SerializedName("sell")
                var sell: String,
                @SerializedName("vol_ten")
                var volTen: String,
                @SerializedName("vol_vex")
                var volVex: String
        )

        data class XlmBtc(
                @SerializedName("buy")
                var buy: String,
                @SerializedName("high")
                var high: String,
                @SerializedName("last")
                var last: String,
                @SerializedName("low")
                var low: String,
                @SerializedName("name")
                var name: String,
                @SerializedName("sell")
                var sell: String,
                @SerializedName("vol_btc")
                var volBtc: String,
                @SerializedName("vol_xlm")
                var volXlm: String
        )

        data class XmrBtc(
                @SerializedName("buy")
                var buy: String,
                @SerializedName("high")
                var high: String,
                @SerializedName("last")
                var last: String,
                @SerializedName("low")
                var low: String,
                @SerializedName("name")
                var name: String,
                @SerializedName("sell")
                var sell: String,
                @SerializedName("vol_btc")
                var volBtc: String,
                @SerializedName("vol_xmr")
                var volXmr: String
        ) {
            var convertedBuy = buy.toString()
            var convertedSell = sell.toString()
        }


        data class ZecBtc(
                @SerializedName("buy")
                var buy: String,
                @SerializedName("high")
                var high: String,
                @SerializedName("last")
                var last: String,
                @SerializedName("low")
                var low: String,
                @SerializedName("name")
                var name: String,
                @SerializedName("sell")
                var sell: String,
                @SerializedName("vol_btc")
                var volBtc: String,
                @SerializedName("vol_zec")
                var volZec: String
        )
    }
}