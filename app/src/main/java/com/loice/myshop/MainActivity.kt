package com.loice.myshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.loice.myshop.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        binding.rvProducts.adapter = ProductsAdapter(emptyList())

    }

    override fun onResume() {
        super.onResume()
        getProducts()
    }
    fun getProducts(){
        val apiclient=ApiClient.buildClient(ApiInterface::class.java)
        val request=apiclient.getProducts()
        request.enqueue(object : Callback<ProductResponse> {
            override fun onResponse(call: Call<ProductResponse>, response: Response<ProductResponse>) {
                if(response.isSuccessful){
                    val products=response.body()?.products
                    val productAdapter = ProductsAdapter(products ?: emptyList())
                    binding.rvProducts.layoutManager = LinearLayoutManager(this@MainActivity)
                    binding.rvProducts.adapter = productAdapter
                    Toast.makeText(baseContext,"fetched ${products?.size} products",Toast.LENGTH_LONG).show()
//                    finish()
                }
                else{
                    Toast.makeText(baseContext,response.errorBody()?.string(),Toast.LENGTH_LONG).show()
                }


            }

            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
//                finish()

            }
        })
    }

}