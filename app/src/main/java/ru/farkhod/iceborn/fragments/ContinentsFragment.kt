package ru.farkhod.iceborn.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.farkhod.iceborn.App

import ru.farkhod.iceborn.R
import ru.farkhod.iceborn.presenters.ContinentsFragmentPresenter
import javax.inject.Inject

class ContinentsFragment : Fragment() {
    @Inject
    lateinit var presenter: ContinentsFragmentPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        App.getComponent().injectContinentsFragment(this)
        var view = inflater.inflate(R.layout.fragment_continents, container, false)

        presenter.prepareView(view)

        return view
    }
}

