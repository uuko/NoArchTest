package com.example.noarchtest.api

import com.example.noarchtest.api.ApiConfig
import com.example.noarchtest.api.BuyResponse
import com.example.noarchtest.api.ProductResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

interface ServiceApi {
    @GET(ApiConfig.productUrl)
    fun getProduct(): Single<Response<ProductResponse>>

    @GET(ApiConfig.buyUrl)
    fun buy(): Single<Response<BuyResponse>>
}
