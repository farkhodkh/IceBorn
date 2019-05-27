package ru.farkhod.iceborn.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import ru.farkhod.iceborn.R
import ru.farkhod.iceborn.presenters.MainFragmentPresenter
import javax.inject.Inject

class MainFragment : Fragment() {

    @Inject
    lateinit var presenter:MainFragmentPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.fragment_main, container, false)
    }

}
