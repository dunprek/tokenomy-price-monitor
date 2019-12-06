package com.don.tokenomy.di

import com.don.tokenomy.BuildConfig
import com.don.tokenomy.api.TokenomyService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by gideon on 06,December,2019
 * dunprek@gmail.com
 * Jakarta - Indonesia
 */
@Module
class TokenomyModule {
    companion object{
        val BASE_URL = "https://exchange.tokenomy.com/"
    }
    @Provides
    internal fun provideLoggingCapableHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor()

        logging.level =
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE

        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    @Provides
    internal fun gson(): Gson {
        return GsonBuilder()
            .serializeNulls()
            .create()
    }

    @Provides
    internal fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson()))
            .client(okHttpClient)
            .build()
    }

    @Provides
    internal fun provideTokenomyService(retrofit: Retrofit): TokenomyService {
        return retrofit.create<TokenomyService>(TokenomyService::class.java)
    }


}