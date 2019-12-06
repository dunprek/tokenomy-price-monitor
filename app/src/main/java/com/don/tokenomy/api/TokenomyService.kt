package com.don.tokenomy.api

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by gideon on 06,December,2019
 * dunprek@gmail.com
 * Jakarta - Indonesia
 */
interface TokenomyService {
    /**
     * GET-------------------------------------------------------------------------------------------------------------------------
     */
    @GET("api/summaries")
    fun getSummary(): Call<JsonObject>
}
