package com.example.ukulima

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ukulima.databinding.ProductListItemBinding

class ProductAdapter(private val onClickListener: OnClickListener) : ListAdapter<ProductsModel,ProductAdapter.MyViewHoder>(MyDiffUtil){
    inner class MyViewHoder(private val binding: ProductListItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(products: ProductsModel?){
            Glide.with(binding.imageMaize)
                .load(products?.image)
                .into(binding.imageMaize)

            binding.textMaize.text = products?.title

        }

    }

    object MyDiffUtil : DiffUtil.ItemCallback<ProductsModel>(){
        override fun areItemsTheSame(oldItem: ProductsModel, newItem: ProductsModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ProductsModel, newItem: ProductsModel): Boolean {
           return oldItem.title== newItem.title
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHoder {
        return MyViewHoder(ProductListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHoder, position: Int) {
       val product = getItem(position)
        holder.bind(product)
        holder.itemView.setOnClickListener{
            onClickListener.onClick(product)

        }

    }
    class OnClickListener(val clickListener: (modelProducts: ProductsModel)-> Unit){
        fun onClick(modelProducts: ProductsModel) = clickListener(modelProducts)
    }

}