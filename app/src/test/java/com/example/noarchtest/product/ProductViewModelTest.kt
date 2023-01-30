package com.example.noarchtest.product

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.noarchtest.api.ProductResponse
import evan.chen.tutorial.mvvmretrofitsample.IProductRepository
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.reactivex.Single
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ProductViewModelTest {
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @MockK
    lateinit var stubRepository: IProductRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }


    @Test
    fun getProduct() {
        val product = ProductResponse()
        product.id = "pixel3"
        product.name = "Google Pixel3"
        product.price = 27000
        product.desc = "5.5吋全螢幕"

        every {
            stubRepository.getProduct()
        } returns Single.just(product)
        //mockito寫法
//        Mockito.`when`(stubRepository.getProduct()).thenReturn(Single.just(product))
        val viewModel = ProductViewModel(stubRepository)
        viewModel.getProduct(product.id)

        Assert.assertEquals(product.name, viewModel.productName.value)
        Assert.assertEquals(product.desc, viewModel.productDesc.value)
        Assert.assertEquals(product.price, viewModel.productPrice.value)
    }

    @Test
    fun buySuccess() {
        every {
            stubRepository.buy(any(), any())
        } returns  Single.just(true)
//        Mockito.`when`(stubRepository.buy(ArgumentMatchers.anyString(), ArgumentMatchers.anyInt()))
//            .thenReturn(
//                Single.just(true)
//            )
        val productViewModel = ProductViewModel(stubRepository)
        productViewModel.buy()

        Assert.assertTrue(productViewModel.buySuccessText.value != null)
    }

    @Test
    fun buyFail() {
        every {
            stubRepository.buy(any(), any())
        } returns  Single.just(false)
//        Mockito.`when`(stubRepository.buy(ArgumentMatchers.anyString(), ArgumentMatchers.anyInt()))
//            .thenReturn(
//                Single.just(false)
//            )
        val productViewModel = ProductViewModel(stubRepository)

        productViewModel.productId.value = "pixel3"
        productViewModel.productItems.value = "2"
        productViewModel.buy()

        Assert.assertTrue(productViewModel.alertText.value != null)
    }
}