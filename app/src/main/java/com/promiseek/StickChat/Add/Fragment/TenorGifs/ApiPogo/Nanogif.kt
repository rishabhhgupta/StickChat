package com.example.example

import com.google.gson.annotations.SerializedName


data class Nanogif (

  @SerializedName("url"      ) var url      : String?        = null,
  @SerializedName("duration" ) var duration : Double?           = null,
  @SerializedName("preview"  ) var preview  : String?        = null,
  @SerializedName("dims"     ) var dims     : ArrayList<Int> = arrayListOf(),
  @SerializedName("size"     ) var size     : Int?           = null

)