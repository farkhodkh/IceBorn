package ru.farkhod.iceborn.fragments

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import ru.farkhod.iceborn.R

class PagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {

    var fragmentsTitles = arrayOf("")

    constructor(fm: FragmentManager?, context: Context): this(fm){
        val resources = context.resources
        fragmentsTitles = resources.getStringArray(R.array.fragmentsTitles)
    }

    override fun getItem(position: Int): Fragment = when (position) {
        0 -> ContinentsFragment()
        1 -> CountriesFragment()
        2 -> OperatorsFragment()
        3 -> IPDetailsFragment()
        else -> ContinentsFragment()
    }

    override fun getCount(): Int {
        return fragmentsTitles.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentsTitles[position]
    }
}