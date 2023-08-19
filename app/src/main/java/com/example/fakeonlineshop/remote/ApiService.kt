package com.example.fakeonlineshop.remote

import com.example.fakeonlineshop.models.GetProduct
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getProducts(): Response<GetProduct>
}