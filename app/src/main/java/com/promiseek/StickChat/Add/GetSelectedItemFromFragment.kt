package com.promiseek.StickChat.Add

import android.net.Uri

interface GetSelectedItemFromFragment {
    fun GetGifs(gifs: String)
    fun GetImageUri(uri: Uri)
    fun setText(text:String)
}