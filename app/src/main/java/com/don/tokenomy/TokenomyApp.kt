package com.don.tokenomy

import android.app.Application
import android.content.Context
import com.don.tokenomy.di.DaggerTokenomyComponent
import com.don.tokenomy.di.TokenomyComponent
import com.don.tokenomy.di.TokenomyModule
import timber.log.Timber

/**
 * Created by gideon on 06,December,2019
 * dunprek@gmail.com
 * Jakarta - Indonesia
 */

class TokenomyApp : Application() {
    companion object {
        var appContext: Context? = null
    }

    lateinit var appComponent: TokenomyComponent

    override fun onCreate() {
        super.onCreate()

        appContext = applicationContext

        // Logging
        Timber.plant(Timber.DebugTree())

        // Set up Dagger
        createAppComponent()

    }

    private fun createAppComponent() {
        appComponent = DaggerTokenomyComponent.builder()
            .tokenomyModule(TokenomyModule())
            .build()
    }
}