package com.example.noarchtest.di

import com.example.noarchtest.product.ProductRepository
import com.example.noarchtest.product.ProductViewModel
import com.example.noarchtest.api.BaseInterceptor
import com.example.noarchtest.api.NetworkService
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {

    viewModel  {
        val networkServiceApi = NetworkService(BaseInterceptor())
        val productRepository = ProductRepository(networkServiceApi.serviceAPI)

        ProductViewModel(productRepository)
    }
}
