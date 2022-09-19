package com.empedocles.marsestate.service

import com.empedocles.marsestate.model.Estate
import io.reactivex.Single
import retrofit2.http.GET

interface EstateAPI {
    @GET("/realestate")
    fun getEstates(): Single<List<Estate>>
}