package com.example.ukulima

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2

class viewPagerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_view_pager, container, false)


        //create a list of fragments

        val fragmentList = arrayListOf<Fragment>(
            onBoard1(),
            onBoard2(),
            onBoard3()
        )

        //create an adapter variable then initialize the viewPagerAdapter
        val viewPager: ViewPager2 = view.findViewById(R.id.viewPager)

        val adapter =  viewPagerAdapter(

            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        viewPager.adapter = adapter

        return view
    }
}