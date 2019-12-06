package com.don.tokenomy.di

import com.don.tokenomy.ui.main.MainActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by gideon on 06,December,2019
 * dunprek@gmail.com
 * Jakarta - Indonesia
 */

@Singleton
@Component(modules = [TokenomyModule::class])
interface TokenomyComponent {
    fun inject(target: MainActivity)
}