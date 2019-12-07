package com.don.tokenomy.ui.main

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.don.tokenomy.R
import com.don.tokenomy.TokenomyApp
import com.don.tokenomy.api.TokenomyService
import com.don.tokenomy.data.remote.MdlMarket
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import com.github.mikephil.charting.utils.MPPointF
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber
import java.util.*
import javax.inject.Inject


class MainActivity : AppCompatActivity(), View.OnClickListener, OnChartValueSelectedListener {


    @Inject
    lateinit var tokenomyService: TokenomyService
    lateinit var mAdapter: MainAdapter
    lateinit var progressDialog: LinearLayout
    lateinit var mainViewModel: MainViewModel
    lateinit var chart: PieChart

    var selectedCategory = "BTC"

    val listSelected = arrayListOf<MdlMarket>()
    val listPie = arrayListOf<MdlMarket>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //setup vm
        setupVM()

        //setup Ui
        setupUI()


        //setup adapter
        setupAdapter()






        Handler().postDelayed({ loadPie() }, 3000)



        etSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                filter(s.toString())

                Timber.e("MESSAGE" + s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {


            }

        })


    }

    private fun filter(string: String) {

        val filteredList = arrayListOf<MdlMarket>()

        for (s: MdlMarket in listSelected) {
            if (s.percentage.toString().toLowerCase().contains(string.toLowerCase()) ||
                    s.market.toString().toLowerCase().contains(string.toLowerCase()) ||
                    s.category.toString().toLowerCase().contains(string.toLowerCase())) {
                filteredList.add(s)
            }
        }

        mAdapter.filterList(filteredList)
    }


    private fun loadPie() {
        listPie.clear()
        for (i in 0 until listSelected.count()) {
            if (listSelected[i].category.equals("BTC")) {


                /* var market: String?,
                 var category: String?,
                 var high: String?,
                 var low: String?,
                 var vol_a: String?,
                 var vol_b: String?,
                 var lastPrice: String?,
                 var buy: String?,
                 var sell: String?,
                 var percentage: Float) : Parcelable*/
                listPie.add(MdlMarket(
                        listSelected[i].market,
                        listSelected[i].category,
                        listSelected[i].high,
                        listSelected[i].low,
                        listSelected[i].vol_a,
                        listSelected[i].vol_b,
                        listSelected[i].lastPrice,
                        listSelected[i].buy,
                        listSelected[i].sell,
                        listSelected[i].percentage,
                        listSelected[i].twoFour))
            }
        }
        Collections.sort(listPie, object : Comparator<MdlMarket> {
            override fun compare(one: MdlMarket, two: MdlMarket): Int {
                return one.vol_b!!.compareTo(two.vol_b!!)
            }

        })

        listPie.reverse()

        Log.e("LISTPIE", listPie.toString())

        initialPieSetup()


    }

    private fun initialPieSetup() {


        chart = findViewById(R.id.chart1)
        chart.setUsePercentValues(true)
        chart.description.isEnabled = false
        chart.setExtraOffsets(5f, 10f, 5f, 5f)


        chart.dragDecelerationFrictionCoef = 0.95f

        chart.isDrawHoleEnabled = true
        chart.setHoleColor(resources.getColor(R.color.colorGreyish))

        chart.setTransparentCircleColor(Color.WHITE)
        chart.setTransparentCircleAlpha(110)

//        chart.holeRadius = 58f
        chart.transparentCircleRadius = 58f

        chart.setDrawCenterText(true)

        chart.rotationAngle = 0f
        // enable rotation of the chart by touch
        chart.setRotationEnabled(true)
        chart.setHighlightPerTapEnabled(true)


        // chart.setUnit(" €");
        // chart.setDrawUnitsInChart(true);

        // add a selection listener
        chart.setOnChartValueSelectedListener(this)

        chart.animateY(1400, Easing.EaseInOutQuad)
        // chart.spin(2000, 0, 360);

        chart.legend.isEnabled = false

        /*     val l = chart.getLegend()
             l.verticalAlignment = Legend.LegendVerticalAlignment.TOP
             l.horizontalAlignment = Legend.LegendHorizontalAlignment.RIGHT
             l.orientation = Legend.LegendOrientation.VERTICAL
             l.setDrawInside(false)
             l.xEntrySpace = 7f
             l.yEntrySpace = 0f
             l.yOffset = 0f*/

        // entry label styling
//        chart.setEntryLabelColor(Color.WHITE)
//        chart.setEntryLabelTextSize(12f)

        chart.setDrawCenterText(false)

        setData(5, 0f)
    }


    private fun setData(count: Int, range: Float) {
        val entries = arrayListOf<PieEntry>()

        // NOTE: The order of the entries when being added to the entries array determines their position around the center of
        // the chart.
        for (i in 0 until count) {
            entries.add(PieEntry(listPie[i].vol_b!!.toFloat(),
                    listPie[i].market,
                    resources.getDrawable(R.drawable.star)))
        }

        val dataSet = PieDataSet(entries, "Election Results")

        dataSet.setDrawIcons(false)

        dataSet.sliceSpace = 3f
        dataSet.iconsOffset = MPPointF(0f, 40f)
        dataSet.selectionShift = 5f

        dataSet.setDrawValues(false)

        // add a lot of colors

        val colors = arrayListOf<Int>()

        colors.add(resources.getColor(R.color.colorPieOne))
        colors.add(resources.getColor(R.color.colorPieTwo))
        colors.add(resources.getColor(R.color.colorPieThree))
        colors.add(resources.getColor(R.color.colorPieFour))
        colors.add(resources.getColor(R.color.colorPieFive))

        dataSet.setColors(colors)
        //dataSet.setSelectionShift(0f);

        val data = PieData(dataSet)
        data.setValueFormatter(PercentFormatter(chart))
        data.setValueTextSize(11f)
        data.setValueTextColor(Color.WHITE)
        chart.data = data

        // undo all highlights
        chart.highlightValues(null)

        chart.invalidate()
    }


    private fun setupUI() {
        tvBtc.setOnClickListener(this)
        tvEth.setOnClickListener(this)
        tvTen.setOnClickListener(this)
        tvUsdt.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.tvBtc) {
            selectedCategory = "BTC"
            mAdapter.setData(listSelected, selectedCategory)
        }

        if (v.id == R.id.tvEth) {
            selectedCategory = "ETH"
            mAdapter.setData(listSelected, selectedCategory)
        }

        if (v.id == R.id.tvUsdt) {
            selectedCategory = "USDT"
            mAdapter.setData(listSelected, selectedCategory)
        }

        if (v.id == R.id.tvTen) {
            selectedCategory = "TEN"
            mAdapter.setData(listSelected, selectedCategory)
        }
    }

    private fun setupVM() {
        progressDialog = findViewById(R.id.progress_dialog)
        (application as TokenomyApp).appComponent.inject(this)
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        mainViewModel.setAttributes(tokenomyService, progressDialog)
        mainViewModel.getSummary().observe(this, getSummary)
        mainViewModel.getErrors().observe(this, getError)
    }

    private fun setupAdapter() {
        mAdapter = MainAdapter(this)
        rvMovieList.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = mAdapter
        }


    }

    private val getSummary = Observer<List<MdlMarket>> { list ->
        if (list != null) {
            Timber.d(list.toString())

            listSelected.addAll(list)
            mAdapter.setData(listSelected, selectedCategory)

        }
    }

    private val getError = Observer<String> { list ->
        if (list != null) {
            Timber.d(list)
//            showSnackBar(list)
        }
    }

    override fun onValueSelected(e: Entry?, h: Highlight?) {
    }

    override fun onNothingSelected() {
    }

}
