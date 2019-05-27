package ru.farkhod.iceborn.presenters

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import ru.farkhod.iceborn.App
import ru.farkhod.iceborn.MainActivity
import ru.farkhod.iceborn.R
import ru.farkhod.iceborn.expandable.ExpandableContinentsAdapter
import ru.farkhod.iceborn.expandable.ExpandableRecyclerView

class ContinentsFragmentPresenter {
    fun prepareView(view: View) {
        App.getComponent().injectContinentsFragmentPresenter(this)

        val recyclerView = (view.findViewById(R.id.recyclerView) as ExpandableRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(
            MainActivity.applicationContext(),
            LinearLayoutManager.VERTICAL,
            false
        )
//        val continentsAdapter = ExpandableTestAdapter()
        val continentsAdapter = ExpandableContinentsAdapter()
        recyclerView.adapter = continentsAdapter
    }
}