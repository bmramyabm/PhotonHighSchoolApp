package com.example.a20220527_ramyamuthusamy_nycschools.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

//Model - Data class for SatScore
data class SatScore(
    @SerializedName("school_name") var schoolName :String,
    @SerializedName("sat_critical_reading_avg_score") var readingScore : String,
    @SerializedName("sat_math_avg_score")var mathScore : String,
    @SerializedName("sat_writing_avg_score") var writingScore :  String
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(schoolName)
        parcel.writeString(readingScore)
        parcel.writeString(mathScore)
        parcel.writeString(writingScore)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SatScore> {
        override fun createFromParcel(parcel: Parcel): SatScore {
            return SatScore(parcel)
        }

        override fun newArray(size: Int): Array<SatScore?> {
            return arrayOfNulls(size)
        }
    }
}