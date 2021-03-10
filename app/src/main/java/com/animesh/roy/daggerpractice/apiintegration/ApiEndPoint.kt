package com.animesh.roy.daggerpractice.apiintegration

import com.animesh.roy.daggerpractice.ui.useritems.UserItemResponse
import io.reactivex.Single
import retrofit2.http.GET
import java.util.ArrayList

interface ApiEndPoint {

    @GET("users")
    fun  fetchUsers() : Single<ArrayList<UserItemResponse>>
}