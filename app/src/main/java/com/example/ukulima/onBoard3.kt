package com.example.ukulima

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2

class onBoard3 : Fragment() {

    private lateinit var button: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_on_board3, container, false)

        val viewPager = requireActivity().findViewById<ViewPager2>(R.id.viewPager)
        button = view.findViewById(R.id.onBoard3Button)

        button.setOnClickListener {
            viewPager?.currentItem = 3
            //findNavController().navigate(R.id.action_viewPagerFragment_to_productsFragment)
        }

        return view

    }
}