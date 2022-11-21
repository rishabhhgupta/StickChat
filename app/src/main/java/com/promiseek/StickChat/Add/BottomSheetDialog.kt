package com.promiseek.StickChat.Add

import android.Manifest
import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.promiseek.StickChat.Add.Fragment.TenorGifs.GifsFragment

import com.promiseek.StickChat.R
import java.io.File

class MyBottomSheetDialog(var getSelectedItemFromFragment: GetSelectedItemFromFragment): BottomSheetDialogFragment() {

    lateinit var bottomNavigationView: BottomNavigationView



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottom_sheet_dialog_layout,container,false)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bottomNavigationView = view.findViewById(R.id.sliderBottomNav)
        childFragmentManager.beginTransaction()
            .add(R.id.gaphicRelativeLayout, GifsFragment(getSelectedItemFromFragment), "zero").commit()

        var bottomSheetBehavior = BottomSheetBehavior.from(view.parent as View)
        setupFullHeight(view.parent as View)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED

        //on bottom nav clicked
        bottomNavigationView.setOnItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.template -> {
                    selectItem(0)
//                    toolbar.title ="Home"
                    true
                }
                R.id.gallery -> {
                    selectItem(1)

                    true
                }
                R.id.text -> {
                    selectItem(2)
                    true
                }

                else -> false
            }
        })

    }

    fun selectItem(position:Int){
        when(position){
            0 ->{
                if (childFragmentManager.findFragmentByTag("zero")!=null) {
                    //if the fragment exists, show it.

                    childFragmentManager.beginTransaction()
                        .show(childFragmentManager.findFragmentByTag("zero")!!).commit()
                } else {
                    //if the fragment does not exist, add it to fragment manager.
                    childFragmentManager.beginTransaction()
                        .add(R.id.gaphicRelativeLayout, GifsFragment(getSelectedItemFromFragment), "zero").commit()
                }
            }

            1->{
                chooseFile()
            }
            2->{
                showText()
            }


        }
    }

    private fun showText() {
        getSelectedItemFromFragment.setText("hehehe")
    }

    private fun chooseFile() {
        if (checkStoragePermission(
                requireContext()
            )
        ) {
            val mRequestFileIntent = Intent(Intent.ACTION_GET_CONTENT)
            mRequestFileIntent.type = "image/*"
//            mRequestFileIntent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
            startActivityForResult(
                Intent.createChooser(mRequestFileIntent,"Choose your next sticker"), 1)

        } else {
            checkStoragePermission(requireContext())

        }
    }
    fun checkStoragePermission(context: Context): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (context.checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED && context.checkSelfPermission(
                    Manifest.permission.READ_EXTERNAL_STORAGE
                )
                == PackageManager.PERMISSION_GRANTED
            ) {
                //                 Permission is granted
                true
            } else {

                //                 Permission is not granted
                requestPermissions(
                    arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    1
                )
                requestPermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), 1)
                //                ActivityCompat.requestPermissions((Activity) getActivity(context), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                //                ActivityCompat.requestPermissions((Activity)getActivity(context), new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 2);
                false
            }
        } else { //permission is automatically granted on sdk<23 upon installation
            true
        }
    }

    //result after permission granted
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            val mRequestFileIntent = Intent(Intent.ACTION_GET_CONTENT)
            mRequestFileIntent.type = "image/*"
//            mRequestFileIntent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
            startActivityForResult(
                Intent.createChooser(mRequestFileIntent,"Choose your next sticker"), 1)
        } else {
            Toast.makeText(
                context, "Permission not granted",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    //after image selected from gallery
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data!!)

        if(resultCode!=RESULT_OK){
            // Exit without doing anything else
            Toast.makeText(requireContext(), "something went wrong", Toast.LENGTH_SHORT).show()
            return
        }else{
            if (data.data != null) {

                // Getting the URIs of the selected files and logging them into logcat at debug level
                val uri: Uri = data.data!!
                getSelectedItemFromFragment.GetImageUri(uri)

                Log.i("listofuriii", getPathFromUri(uri).toString())
            }
        }
    }


    private fun setupFullHeight(bottomSheetBehavior: View) {
        val layoutParams = bottomSheetBehavior.layoutParams
        layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT
        bottomSheetBehavior.layoutParams = layoutParams
    }


    override fun onDetach() {
        super.onDetach()
    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
    }

    fun getPathFromUri(uri: Uri): String? {
        return try {
            var FilePath: String?
            FilePath = uri.path
            FilePath = if (uri.toString().contains("storage/emulated")) {
                val split = uri.toString().split("storage/".toRegex()).toTypedArray()
                "storage/" + split[1]
            } else {
                //                FilePath = UploadingFiles.ImageFilePath.getPath(context.getApplicationContext(), selectedImageUri);
                GetFilePath.getPath(
                    requireContext().getApplicationContext(),
                    uri
                )
            }

            //                     recyclerview.setVisibility(View.VISIBLE);
            if (FilePath == null) {
                FilePath = ""
            }
            val file = File(FilePath)
            file.absolutePath
        } catch (e: Exception) {
            Toast.makeText(
                requireContext(),
                e.toString(),
                Toast.LENGTH_SHORT
            ).show()
            null
        }
    }

}