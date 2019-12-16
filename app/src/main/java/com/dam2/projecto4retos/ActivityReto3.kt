package com.dam2.projecto4retos

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_reto3.*
import org.jetbrains.anko.toast

class ActivityReto3 : AppCompatActivity() {

    var condicion = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reto3)
        toast("¿Serás capaz?")
        btncamera.setOnClickListener { camera(it) }
        btn6.setOnClickListener {
            val data = Intent()
            data.putExtra("resp", condicion)
            setResult(Activity.RESULT_OK,data)
            finish()
        }

    }

    val REQUEST_IMAGE_CAPTURE = 1

    private fun camera(view: View) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
            != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    Manifest.permission.CAMERA
                )
            ) {


                ActivityCompat.requestPermissions(
                    this, arrayOf(Manifest.permission.CAMERA),
                    1
                )
            } else {
                toast("PERMISO DENEGADO")
            }
        }else{

                    val intent = Intent (MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
                        takePictureIntent.resolveActivity(packageManager)?.also {
                            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
                        }
                    }
                }
            }
     @SuppressLint("MissingSuperCall")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
         if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
             val imageBitmap = data?.extras?.get("data") as Bitmap
             imageView4.setImageBitmap(imageBitmap)
             condicion = true

         }
     }
        }






