package com.example.a20220527_ramyamuthusamy_nycschools.detail

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.a20220527_ramyamuthusamy_nycschools.R
import com.example.a20220527_ramyamuthusamy_nycschools.model.School

class DetailActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //Activity to display the specific details of the school selected
        val school = intent.getParcelableExtra<School>("school")
        if(school !=null){
            val tv_phoneNumber : TextView = findViewById(R.id.tv_phone_number)
            val tv_schoolEmail : TextView = findViewById(R.id.tv_school_email)
            val tv_schoolWebsite: TextView = findViewById(R.id.tv_website)

            tv_phoneNumber.text = school.phoneNumber
            tv_schoolEmail.text = school.schoolEmail
            tv_schoolWebsite.text = school.website
        }
        else{
            Toast.makeText(this,"Intent Not Working",Toast.LENGTH_LONG).show()

        }
    }
}