package com.scb.easybit.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.scb.easybit.fragment.SliderImageFragment

class SliderFirstPageAdapter(fm: FragmentManager, var imgArray: ArrayList<String>) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return SliderImageFragment(imgArray[position])
    }

    override fun getCount(): Int {
        return imgArray.count()
    }
}