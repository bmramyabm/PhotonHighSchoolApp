package com.example.a20220527_ramyamuthusamy_nycschools.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


//Model - school data
data class School(
   @SerializedName("dbn") var dbn :String,
   @SerializedName("school_name") var schoolName: String,
   @SerializedName("phone_number") var phoneNumber:String,
   @SerializedName("school_email") var schoolEmail:String,
   @SerializedName("website") var website:String

):Parcelable {
   constructor(parcel: Parcel) : this(
      parcel.readString()!!,
      parcel.readString()!!,
      parcel.readString()!!,
      parcel.readString()!!,
      parcel.readString()!!
   ) {
   }

   override fun writeToParcel(parcel: Parcel, flags: Int) {
      parcel.writeString(dbn)
      parcel.writeString(schoolName)
      parcel.writeString(phoneNumber)
      parcel.writeString(schoolEmail)
      parcel.writeString(website)
   }

   override fun describeContents(): Int {
      return 0
   }

   companion object CREATOR : Parcelable.Creator<School> {
      override fun createFromParcel(parcel: Parcel): School {
         return School(parcel)
      }

      override fun newArray(size: Int): Array<School?> {
         return arrayOfNulls(size)
      }
   }
}


