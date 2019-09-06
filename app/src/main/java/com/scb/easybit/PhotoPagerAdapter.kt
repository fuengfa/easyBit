package com.scb.easybit

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PhotoPagerAdapter(fm: FragmentManager, var imgArray: ArrayList<String>) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return PicturesFragment(imgArray[position])
        }

    override fun getCount(): Int {
        return imgArray.count()
    }
}