package com.example.ukulima

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import java.util.ArrayList

class viewPagerAdapter (list: ArrayList<Fragment>, fragmentManager: FragmentManager, lifecycle: Lifecycle):
    FragmentStateAdapter(fragmentManager, lifecycle) {

    //create a fragmentList variable
    private val fragmentList: ArrayList<Fragment> = list

    //return the fragmentList size
    override fun getItemCount(): Int {

        return fragmentList.size
    }

    //return the fragmentList position
    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }
}