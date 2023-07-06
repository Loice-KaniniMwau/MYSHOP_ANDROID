package com.loice.myshop

import retrofit2.Call
import retrofit2.http.GET
//specifications of what the api client does
//the functions
//api client-making http calls
//the endpoint ansd the functions to be created by retrofit
//
//api interface is kotlin class of type interface ..define the http method and the endpoint
interface ApiInterface {
    @GET("/product")
    fun getProducts(): Call<ProductResponse>

}