package com.example.a20220527_ramyamuthusamy_nycschools.repository

import com.example.a20220527_ramyamuthusamy_nycschools.RetrofitService

//creating the repository
class MainRepository constructor(private val retrofitService: RetrofitService) {
    fun getAllSchools() = retrofitService.getAllSchools()

}