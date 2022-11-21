package com.example.example

import com.google.gson.annotations.SerializedName


data class MediaFormats (

  @SerializedName("tinygifpreview" ) var tinygifpreview : Tinygifpreview? = Tinygifpreview(),
  @SerializedName("nanogif"        ) var nanogif        : Nanogif?        = Nanogif(),
  @SerializedName("mediumgif"      ) var mediumgif      : Mediumgif?      = Mediumgif(),
  @SerializedName("gif"            ) var gif            : Gif?            = Gif(),
  @SerializedName("loopedmp4"      ) var loopedmp4      : Loopedmp4?      = Loopedmp4(),
  @SerializedName("nanowebm"       ) var nanowebm       : Nanowebm?       = Nanowebm(),
  @SerializedName("tinymp4"        ) var tinymp4        : Tinymp4?        = Tinymp4(),
  @SerializedName("tinywebm"       ) var tinywebm       : Tinywebm?       = Tinywebm(),
  @SerializedName("gifpreview"     ) var gifpreview     : Gifpreview?     = Gifpreview(),
  @SerializedName("nanogifpreview" ) var nanogifpreview : Nanogifpreview? = Nanogifpreview(),
  @SerializedName("tinygif"        ) var tinygif        : Tinygif?        = Tinygif(),
  @SerializedName("mp4"            ) var mp4            : Mp4?            = Mp4(),
  @SerializedName("nanomp4"        ) var nanomp4        : Nanomp4?        = Nanomp4(),
  @SerializedName("webm"           ) var webm           : Webm?           = Webm()

)