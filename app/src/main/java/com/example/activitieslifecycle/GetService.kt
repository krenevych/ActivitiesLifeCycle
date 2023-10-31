package com.example.activitieslifecycle

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


//https://api.npoint.io/8d241653a684f6a80b82
interface GetService {
    @GET("{key}")
    fun getData(@Path("key") key: String): Call<Data>
}