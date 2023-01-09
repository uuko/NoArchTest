package com.example.noarchtest.product

import MockAPIResponse
import MockInterceptor
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.noarchtest.api.NetworkService
import evan.chen.tutorial.mvvmretrofitsample.IProductRepository
import evan.chen.tutorial.mvvmretrofitsample.ProductRepository
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class ProductRepositoryTest {
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()
    private lateinit var repository: IProductRepository


    @Test
    fun getProduct() {

        val interceptor = MockInterceptor()

        interceptor.setInterceptorListener(object : MockInterceptor.MockInterceptorListener {
            override fun setAPIResponse(url: String): MockAPIResponse? {
                val mockAPIResponse = MockAPIResponse()
                mockAPIResponse.status = 200
                mockAPIResponse.responseString = Utils.readStringFromResource("product.json")
                return mockAPIResponse
            }
        })

        val networkService = NetworkService(interceptor)
        repository = ProductRepository(networkService.serviceAPI)

        val id = "pixel4"
        val name = "Google Pixel 4"
        val desc = "5.5吋全螢幕"
        val price = 27000

        val product = repository.getProduct().blockingGet()

        Assert.assertEquals(id, product.id)
        Assert.assertEquals(desc, product.desc)
        Assert.assertEquals(name, product.name)
        Assert.assertEquals(price, product.price)
    }
}