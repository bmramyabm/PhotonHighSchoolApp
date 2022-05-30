package com.example.a20220527_ramyamuthusamy_nycschools

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a20220527_ramyamuthusamy_nycschools.model.School
import com.example.a20220527_ramyamuthusamy_nycschools.repository.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: MainRepository): ViewModel() {

    val schoolList = MutableLiveData<List<School>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllSchools(){
        val response = repository.getAllSchools()
        response.enqueue(object: Callback<List<School>>{
            override fun onResponse(call: Call<List<School>>, response: Response<List<School>>) {
                schoolList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<School>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }

        })

    }
}