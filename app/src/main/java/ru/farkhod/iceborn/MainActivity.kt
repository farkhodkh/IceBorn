package ru.farkhod.iceborn

import android.content.Context
import android.mtp.MtpStorageInfo
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import ru.farkhod.iceborn.fragments.PagerAdapter


class MainActivity : AppCompatActivity() {

    lateinit var viewPager: ViewPager

    lateinit var pagerAdapter: PagerAdapter

    init {
        instance = this
    }
    companion object {
        private var instance: MainActivity? = null

        fun applicationContext() : Context {
            return instance!!.applicationContext
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        App.getComponent().injectMainactivity(this)
        prepareViewPager()
    }

    private fun prepareViewPager() {
        pagerAdapter = PagerAdapter(supportFragmentManager, this)
        viewPager = findViewById(R.id.mainViewPager)
        viewPager.adapter = pagerAdapter
        viewPager.currentItem = 0
    }
}
