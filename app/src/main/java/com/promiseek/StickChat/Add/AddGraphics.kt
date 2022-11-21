package com.promiseek.StickChat.Add

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import com.bumptech.glide.Glide
import com.google.android.material.card.MaterialCardView

class AddGraphics @JvmOverloads constructor(context: Context) : MaterialCardView(context) {

    private val parentConstratin:ConstraintLayout by lazy{ConstraintLayout(context)}
    private  val constrainSet:ConstraintSet by lazy { ConstraintSet() }

    init {
        createView()
    }

    private fun createView() {
        updateCardView()
        addChildView()
    }



    private fun updateCardView() {
        layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT)
        radius = 24f
        setPadding(12,12,12,12)
        setBackgroundColor(Color.MAGENTA)
    }

    private fun addChildView() {
        addParentConstrainView()

    }

    private fun addParentConstrainView() {
        parentConstratin.layoutParams = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.MATCH_PARENT)
        addView(parentConstratin)
    }


    fun addGifs(url:String){

        val imageView = ImageView(context)
        imageView.layoutParams.width = RelativeLayout.LayoutParams.WRAP_CONTENT
        Glide.with(this).asGif().load(url).into(imageView)
    }

}