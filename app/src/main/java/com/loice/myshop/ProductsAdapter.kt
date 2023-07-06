package com.loice.myshop

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.loice.myshop.databinding.ProductlistBinding
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation

class ProductsAdapter(var productList:List<Product>):RecyclerView.Adapter<ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding=ProductlistBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ProductViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
       var currentProduct=productList[position]
        val binding=holder.binding
        binding.tvId.text=currentProduct.id.toString()
        binding.tvtitle.text=currentProduct.title
        binding.tvprice.text=currentProduct.price.toString()
        binding.tvdescription.text=currentProduct.description
        binding.tvcategory.text=currentProduct.category
        binding.tvstock.text=currentProduct.sock.toString()
        binding.tvrating.text=currentProduct.rating.toString()
        Picasso
            .get()
            .load(currentProduct.thumbnail)
            .resize(400,300)
            .centerCrop()
//            .transform(CropCircleTransformation())
            .into(binding.ivthumbnail)

    }

    override fun getItemCount(): Int {
        return productList.size
    }
}
class ProductViewHolder(var binding: ProductlistBinding):RecyclerView.ViewHolder(binding.root){

}
