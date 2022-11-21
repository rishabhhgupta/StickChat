package com.example.example

import com.google.gson.annotations.SerializedName


data class ApiResults (

    @SerializedName("locale"  ) var locale  : String?            = null,
    @SerializedName("results" ) var results : ArrayList<Results> = arrayListOf(),
    @SerializedName("next"    ) var next    : String?            = null

)