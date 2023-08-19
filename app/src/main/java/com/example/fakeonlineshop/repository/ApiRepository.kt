package com.example.fakeonlineshop.repository

import com.example.fakeonlineshop.remote.ApiService
import javax.inject.Inject

class ApiRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getProduct() = apiService.getProducts()
}