package com.promiseek.StickChat.Add


import android.graphics.Bitmap
import android.graphics.Matrix
import android.graphics.Typeface
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.outsbook.libs.canvaseditor.CanvasEditorView
import com.promiseek.StickChat.R
import java.net.URL


class MyCanvas : AppCompatActivity(),
    GetSelectedItemFromFragment {

    lateinit var fragmentManager: FragmentManager
    lateinit var canvasEditor: CanvasEditorView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        fragmentManager = supportFragmentManager




//        val mRequestFileIntent = Intent(Intent.ACTION_GET_CONTENT)
//        mRequestFileIntent.type = "*/*"
//        mRequestFileIntent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
//        startActivityForResult(mRequestFileIntent, 1)
        canvasEditor = findViewById(R.id.canvasEditor)


        var addGraphics = findViewById<ImageView>(R.id.addGraphics)
        addGraphics.setOnClickListener(View.OnClickListener {
            showBottomSheetDialog()
        })

        //AIzaSyDYwIAnNu9Jb6Y5tIiDo6bQ6nrxtLmi1g4
        //tenor implementation



    }



//    fun CanvasEditorView.addGifs("")


    private fun showBottomSheetDialog() {

        val bottomSheetDialog:MyBottomSheetDialog = MyBottomSheetDialog(this)
        bottomSheetDialog.show(supportFragmentManager, "bottomSheetOpen")
    }

    interface OnClicked{
        fun gifsClicked(gifs:String)
    }

    override fun GetGifs(gifs: String) {
//        canvasEditor.addGifsUrl(gifs)
//        Glide.with(this).asGif().load(gifs).into(canvasEditor)
    }

    override fun setText(text: String) {
        val font: Typeface = Typeface.createFromAsset(
            getAssets(),
            "fonts/noyhr.ttf"
        )

        canvasEditor.addTextSticker(text,R.color.colorPrimary,font)
    }

    override fun GetImageUri(uri: Uri) {
        val bitmap: Bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, uri)
        canvasEditor.addBitmapSticker(bitmap)
    }


    fun getResizedBitmap(bm: Bitmap, newWidth: Int, newHeight: Int): Bitmap? {
        val width = bm.width
        val height = bm.height
        val scaleWidth = newWidth.toFloat() / width
        val scaleHeight = newHeight.toFloat() / height
        // CREATE A MATRIX FOR THE MANIPULATION
        val matrix = Matrix()
        // RESIZE THE BIT MAP
        matrix.postScale(scaleWidth, scaleHeight)

        // "RECREATE" THE NEW BITMAP
        val resizedBitmap = Bitmap.createBitmap(
            bm, 0, 0, width, height, matrix, false
        )
        bm.recycle()
        return resizedBitmap
    }

    fun getUriFromUrl(thisUrl: String?): Uri? {
        val builder: Uri.Builder

        val url = URL(thisUrl)
        builder = Uri.Builder()
            .scheme(url.getProtocol())
            .authority(url.getAuthority())
            .appendPath(url.getPath())
        return builder.build()
    }






}


