package com.example.ukulima

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.ukulima.databinding.FragmentProductsBinding
import com.example.ukulima.databinding.ProductListItemBinding
import com.google.firebase.database.*
import java.util.ArrayList

private const val TAG = "ProductsFragment"
class ProductsFragment : Fragment() {

    private lateinit var binding: FragmentProductsBinding
    private lateinit var reference: DatabaseReference
    private lateinit var productList: ArrayList<ProductsModel>
    private val productAdapter by lazy {
        ProductAdapter(ProductAdapter.OnClickListener{ product ->
            val action = ProductsFragmentDirections.actionProductsFragmentToDetail(product)
            findNavController().navigate(action)
            Log.d(TAG, "arguments: $product")
        })
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_products, container, false)
        binding = FragmentProductsBinding.inflate(inflater, container, false)
        val view = binding.root

        reference = FirebaseDatabase.getInstance("https://ukulima-ebf9b-default-rtdb.firebaseio.com/").reference
        reference.child("products").addValueEventListener(object : ValueEventListener{
            override fun onDataChange(p0: DataSnapshot) {
                productList = ArrayList()
                if (p0.exists()){
                    Log.d(TAG, "onDataChange: $p0")
                    for (product in p0.children){
                        val myProduct = product.getValue(ProductsModel::class.java)
                        productList.add(myProduct!!)
                    }
                    productAdapter.submitList(productList)
                    binding.recyclerView.adapter = productAdapter
                }
                else{

                }
            }

            override fun onCancelled(p0: DatabaseError) {

            }

        })
        return  view
    }

}