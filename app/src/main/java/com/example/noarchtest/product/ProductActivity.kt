package com.example.noarchtest.product

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import com.example.noarchtest.R
import com.example.noarchtest.databinding.ActivityMainBinding
import com.example.noarchtest.databinding.ActivityProductBinding
import evan.chen.tutorial.mvvmretrofitsample.ProductViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProductActivity : AppCompatActivity() {
    private val productViewModel: ProductViewModel by viewModel()
    private val productId = "pixel3"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityProductBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        productViewModel.getProduct(productId)

        productViewModel.productName.observe(this, Observer {
            binding.productName.text=it
        })
        productViewModel.productPrice.observe(this, Observer {
            binding.productPrice.text=it.toString()
        })
        productViewModel.productId.observe(this, Observer {
            binding.productId.text=it.toString()
        })

        binding.buy.setOnClickListener {
            productViewModel.productItems.value=binding.productItems.text.toString()
            productViewModel.buy()
        }

        productViewModel.alertText.observe(this, Observer { event ->
            event?.getContentIfNotHandled()?.let {
                val builder = AlertDialog.Builder(this)
                builder.setMessage(it).setTitle("錯誤")
                builder.show()
            }
        })

        productViewModel.buySuccessText.observe(this, Observer { event ->
            event?.getContentIfNotHandled()?.let {
                Toast.makeText(this, it, Toast.LENGTH_LONG).show();
            }
        })

    }
}