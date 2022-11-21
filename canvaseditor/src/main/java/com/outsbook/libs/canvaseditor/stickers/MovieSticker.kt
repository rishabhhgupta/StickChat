package com.outsbook.libs.canvaseditor.stickers

import android.content.Context
import android.graphics.Canvas
import android.graphics.Movie
import android.graphics.Rect
import android.graphics.drawable.AnimatedImageDrawable
import android.graphics.drawable.Drawable
import android.text.Layout
import android.text.TextPaint
import androidx.core.content.ContextCompat
import com.outsbook.libs.canvaseditor.R

internal class MovieSticker(private val context: Context, drawable: Drawable?): Sticker() {
    override lateinit var drawable: Drawable
    private val realBounds: Rect

    init {

        if (drawable == null) {
            this.drawable = ContextCompat.getDrawable(context, R.drawable.shape_transfarent_background)!!
        }else{
            this.drawable = drawable
        }
        realBounds = Rect(0, 0, width, height)

    }

    override val width: Int
        get() = drawable.intrinsicWidth
    override val height: Int
        get() = drawable.intrinsicHeight


    override fun draw(canvas: Canvas) {

        canvas.save()
        canvas.concat(matrix)
        drawable.bounds = realBounds
        drawable.draw(canvas)
        canvas.restore()


    }

    override fun setDrawable(drawable: Drawable): MovieSticker {
        this.drawable = drawable
        return this
    }

    override fun setAlpha(alpha: Int): MovieSticker {
        drawable.alpha = alpha
        return this
    }
}