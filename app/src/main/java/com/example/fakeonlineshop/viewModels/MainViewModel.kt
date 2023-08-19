package com.example.fakeonlineshop.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fakeonlineshop.models.GetProduct
import com.example.fakeonlineshop.repository.ApiRepository
import com.example.fakeonlineshop.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val apiRepository: ApiRepository) : ViewModel() {
    private val _responseProducts = MutableLiveData<Resource<GetProduct>>()
    val getProduct: LiveData<Resource<GetProduct>> get() = _responseProducts

    fun getProducts() {
        _responseProducts.postValue(Resource.loading(null))
        viewModelScope.launch {
            try {
                apiRepository.getProduct().let {
                    Log.d("TAG", "getProducts: $it")
                    Log.d("TAG", "getProducts:Data ${it.body()}")
                    if (it.isSuccessful) {
                        _responseProducts.postValue(Resource.success(it.body()))
                    } else {
                        _responseProducts.postValue(Resource.error(it.message().toString(), null))
                    }
                }
            } catch (e: Exception) {
                _responseProducts.postValue(Resource.error(e.message.toString(), null))
                Log.d("TAG", "getProducts: ${e.message}")
            }
        }
    }
}