package com.example.a20220527_ramyamuthusamy_nycschools

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.a20220527_ramyamuthusamy_nycschools.databinding.ActivityMainBinding
import com.example.a20220527_ramyamuthusamy_nycschools.detail.DetailActivity
import com.example.a20220527_ramyamuthusamy_nycschools.repository.MainRepository

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    private val retrofitService = RetrofitService.getInstance()
    val adapter= MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this,MainViewModelFactory(MainRepository(retrofitService))).get(MainViewModel::class.java)

        binding.rvSchoolList.adapter = adapter
        adapter.onItemClick = {
            val intent = Intent (this,DetailActivity::class.java)
            intent.putExtra("school",it)
            startActivity(intent)
        }

        viewModel.schoolList.observe(this, Observer {
           adapter.setSchoolList(it)
        })
        viewModel.errorMessage.observe(this, Observer {
            Log.d(TAG," ERROR Meggase $it")
        })
        viewModel.getAllSchools()
    }
}