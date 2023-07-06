package com.loice.myshop

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
//define and instantiate a retrofit object by specifying the base url and the necessary methods such as
//converting the json to kotlin object

object ApiClient {
    var retrofit=Retrofit.Builder()
        .baseUrl("https://dummyjson.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    fun <T> buildClient(apiInterface: Class<T>):T{
        return retrofit.create(apiInterface)
    }
}