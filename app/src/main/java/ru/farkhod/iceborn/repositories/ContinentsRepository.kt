package ru.farkhod.iceborn.repositories

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import ru.farkhod.iceborn.repositories.api.ContinentsApi
import ru.farkhod.iceborn.repositories.api.ContinentsData

class ContinentsRepository {
    fun getRepository(onRepositoryReadyCallback: OnRepositoryReadyCallback, term: String) {
        var arrayList: ArrayList<String> = arrayListOf()
        val apiService = ContinentsApi.create()

        try {
            var result: Observable<ArrayList<ContinentsData>> = when (term) {
                "EU" -> apiService.searchEU()
                "AF" -> apiService.searchAF()
                "AS" -> apiService.searchAS()
                "NA" -> apiService.searchNA()
                "SA" -> apiService.searchSA()
                "OC" -> apiService.searchOC()
                else -> apiService.searchEU()
            }
            result.subscribeOn(Schedulers.io()).subscribe { items ->
                items.forEach {
                    arrayList.add(it.name)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
        }

//        Handler().postDelayed({ onRepositoryReadyCallback.onDataReady(arrayList) }, 2000)
        onRepositoryReadyCallback.onDataReady(term, arrayList)
    }

    interface OnRepositoryReadyCallback {
        fun onDataReady(groupName: String, data: ArrayList<String>)
    }
}