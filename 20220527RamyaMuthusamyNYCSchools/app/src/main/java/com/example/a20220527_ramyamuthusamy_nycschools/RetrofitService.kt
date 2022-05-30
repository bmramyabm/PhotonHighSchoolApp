package com.example.a20220527_ramyamuthusamy_nycschools

import com.example.a20220527_ramyamuthusamy_nycschools.model.SatScore
import com.example.a20220527_ramyamuthusamy_nycschools.model.School
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET


//creating the interface and instance for the retrofit
interface RetrofitService{
    @GET("s3k6-pzi2.json")
    fun getAllSchools(): Call<List<School>>

    @GET("f9bf-2cp4.json")
    fun getAllStatScore(): Call<List<SatScore>>

    companion object {
        var retrofitService: RetrofitService? = null

        fun getInstance():RetrofitService{
            if(retrofitService == null){
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://data.cityofnewyork.us/resource/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}