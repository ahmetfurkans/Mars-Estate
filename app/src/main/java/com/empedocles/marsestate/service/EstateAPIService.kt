package com.empedocles.marsestate.service

import com.empedocles.marsestate.model.Estate
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class EstateAPIService {
    companion object {
        private const val BASE_URL = "https://mars.udacity.com/"
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(EstateAPI::class.java)

    fun getData(): Single<List<Estate>> {
        return retrofit.getEstates()
    }
}