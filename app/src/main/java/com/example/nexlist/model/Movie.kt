package com.example.nexlist.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize



@Parcelize
data class Movie(
    val COUNT: String,
    val ITEMS: List<ITEMS>
):Parcelable

@Parcelize
data class ITEMS(
    val download: String,
    val image: String,
    val imdbid: String,
    val largeimage: String,
    val netflixid: String,
    val rating: String,
    val released: String,
    val runtime: String,
    val synopsis: String,
    val title: String,
    val type: String,
    val unogsdate: String
):Parcelable


