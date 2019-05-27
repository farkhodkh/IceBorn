package ru.farkhod.iceborn.repositories.api

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ContinentsApi{
    @GET("EU/info")
    fun searchEU(): Observable<ArrayList<ContinentsData>>

    @GET("AS/info")
    fun searchAS(): Observable<ArrayList<ContinentsData>>

    @GET("AF/info")
    fun searchAF(): Observable<ArrayList<ContinentsData>>

    @GET("NA/info")
    fun searchNA(): Observable<ArrayList<ContinentsData>>

    @GET("SA/info")
    fun searchSA(): Observable<ArrayList<ContinentsData>>

    @GET("OC/info")
    fun searchOC(): Observable<ArrayList<ContinentsData>>

//    @GET("search")
//    fun search(@Query("term") query: String): Observable<ItunesSearchResult>
//    //https://itunes.apple.com/search?term=jim+jones

    companion object Factory {
        fun create(): ContinentsApi {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://iceborn.ru/api/v1/continent/")
                .build()

            return retrofit.create(ContinentsApi::class.java);
        }
    }
}