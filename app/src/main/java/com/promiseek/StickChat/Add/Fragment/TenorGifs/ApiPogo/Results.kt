package com.example.example

import com.google.gson.annotations.SerializedName


data class Results (

  @SerializedName("id"                  ) var id                 : String?           = null,
  @SerializedName("title"               ) var title              : String?           = null,
  @SerializedName("media_formats"       ) var mediaFormats       : MediaFormats?     = MediaFormats(),
  @SerializedName("created"             ) var created            : Double?           = null,
  @SerializedName("content_description" ) var contentDescription : String?           = null,
  @SerializedName("itemurl"             ) var itemurl            : String?           = null,
  @SerializedName("url"                 ) var url                : String?           = null,
  @SerializedName("tags"                ) var tags               : ArrayList<String> = arrayListOf(),
  @SerializedName("flags"               ) var flags              : ArrayList<String> = arrayListOf(),
  @SerializedName("hasaudio"            ) var hasaudio           : Boolean?          = null

)