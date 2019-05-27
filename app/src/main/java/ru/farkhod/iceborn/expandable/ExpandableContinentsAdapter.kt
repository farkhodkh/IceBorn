package ru.farkhod.iceborn.expandable

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ru.farkhod.iceborn.MainActivity
import ru.farkhod.iceborn.R
import ru.farkhod.iceborn.repositories.ContinentsRepository
import ru.farkhod.iceborn.repositories.ContinentsRepository.OnRepositoryReadyCallback
import java.util.*
import kotlin.collections.ArrayList

class ExpandableContinentsAdapter :
    ExpandableRecyclerView.Adapter<ExpandableContinentsAdapter.ChildViewHolder, ExpandableRecyclerView.SimpleGroupViewHolder, String, String>() {

    val resources = MainActivity.applicationContext().resources
    val continentsArray = resources.getStringArray(R.array.continents)
    var contriesMap: Map<String, ArrayList<String>> = mutableMapOf()

    override fun getGroupItemCount(): Int {
        return continentsArray.size - 1
    }

    override fun getChildItemCount(group: Int): Int {
        return contriesMap[continentsArray[group]]!!.size
    }

    override fun getGroupItem(position: Int): String {
        return continentsArray[position]
    }

    override fun getChildItem(group: Int, position: Int): String {
        var contMap = contriesMap.filter { it.key == continentsArray[group] }
        return contMap.values.toList()[position].toString()
    }

    override fun expand(group: Int) {
        var groupId = group
    }

    override fun onCreateGroupViewHolder(parent: ViewGroup?): ExpandableRecyclerView.SimpleGroupViewHolder {
        return ExpandableRecyclerView.SimpleGroupViewHolder(parent?.context)

        prepareChildItems()
    }

    override fun onCreateChildViewHolder(parent: ViewGroup?, viewType: Int): ChildViewHolder {
        val inflater = LayoutInflater.from(parent?.context)
        val view = inflater.inflate(R.layout.row_drawer, parent, false)
        return ChildViewHolder(view)
    }

    override fun onBindGroupViewHolder(holder: ExpandableRecyclerView.SimpleGroupViewHolder?, group: Int) {
        super.onBindGroupViewHolder(holder, group)
        holder?.setText(getGroupItem(group))
    }

    override fun onBindChildViewHolder(holder: ChildViewHolder?, group: Int, position: Int) {
        super.onBindChildViewHolder(holder, group, position)
        holder?.tv?.text = getChildItem(group, position)
    }

    override fun getChildItemViewType(group: Int, position: Int): Int {
        return 1
    }

    override fun setOnChildItemClickedListener(onItemClickedListener: ExpandableRecyclerView.OnChildItemClickedListener?) {
        print(onItemClickedListener.toString())
    }

    fun prepareChildItems() {
        lateinit var entry:Pair<String, ArrayList<String>>

        var callBack = object : OnRepositoryReadyCallback {
            override fun onDataReady(groupName: String, data: ArrayList<String>) {
                entry = Pair(groupName, data)
            }
            val entryToAdd = mapOf(entry)
        }
        continentsArray.forEach {
            val repository = ContinentsRepository().getRepository(callBack, it)
        }
    }
    inner class ChildViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tv: TextView

        init {
            tv = itemView.findViewById(R.id.text) as TextView
        }
    }
}