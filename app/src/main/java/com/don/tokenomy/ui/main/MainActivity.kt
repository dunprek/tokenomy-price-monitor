package com.don.tokenomy.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.don.tokenomy.R
import com.don.tokenomy.TokenomyApp
import com.don.tokenomy.api.TokenomyService
import com.don.tokenomy.data.remote.MdlMarket
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity(), View.OnClickListener {


    @Inject
    lateinit var tokenomyService: TokenomyService
    lateinit var mAdapter: MainAdapter
    lateinit var progressDialog: LinearLayout
    lateinit var mainViewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //setup vm
        setupVM()

        //setup Ui
        setupUI()


        //setup adapter
        setupAdapter()


    }


    private fun setupUI() {
        tvBtc.setOnClickListener(this)
        tvEth.setOnClickListener(this)
        tvTen.setOnClickListener(this)
        tvUsdt.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if(v.id ==R.id.tvBtc){


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
            mAdapter.setData(list)
        }
    }

    private val getError = Observer<String> { list ->
        if (list != null) {
            Timber.d(list)
//            showSnackBar(list)
        }
    }
}
