package com.example.ukulima

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.viewpager2.widget.ViewPager2


class onBoard1 : Fragment() {


    private lateinit var button: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_on_board1, container, false)

        val viewPager = requireActivity().findViewById<ViewPager2>(R.id.viewPager)
        button = view.findViewById(R.id.onBoard1Button)

        button.setOnClickListener {
            viewPager?.currentItem = 1
        }

        return view


    }
}