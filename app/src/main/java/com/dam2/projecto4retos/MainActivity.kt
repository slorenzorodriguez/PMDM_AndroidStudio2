package com.dam2.projecto4retos

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.singleTop
import org.jetbrains.anko.toast

const val RETO1_REQUEST = 1
const val RETO2_REQUEST = 2
const val RETO3_REQUEST = 3
const val RETO4_REQUEST = 4
class MainActivity : AppCompatActivity() {


    var retoscompletados = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnreto1.setOnClickListener { opentest(it, 1) }
        btnreto2.setOnClickListener { opentest(it, 2) }
        btnreto3.setOnClickListener { opentest(it, 3) }
        btnreto4.setOnClickListener { opentest(it, 4) }


    }


    private fun opentest(view: View, num: Int) {
        when (num) {
            1 -> {
                val intent = Intent(this, ActivityReto1::class.java)
                startActivityForResult(intent, RETO1_REQUEST)
            }

            2 -> {
                val intent = Intent(this, ActivityReto2::class.java)
                startActivityForResult(intent, RETO2_REQUEST)
            }

            3 -> {
                val intent = Intent(this, ActivityReto3::class.java)
                startActivityForResult(intent, RETO3_REQUEST)
            }

            4 -> {
                val intent = Intent(this, ActivityReto4::class.java)
                startActivityForResult(intent, RETO4_REQUEST)
            }

        }
    }

        private fun completo() {
            startActivity(intentFor<winActivity>().singleTop())
        }


        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
            if (requestCode == RETO1_REQUEST) {
                if (resultCode == Activity.RESULT_OK) {

                    toast("¡Enhorabuena, has superado el reto!")
                    btnreto1.setBackgroundResource(R.color.colorverde)
                    btnreto1.setEnabled(false)
                    retoscompletados += 1
                    //si completas correctamente los 4 retos
                    if (retoscompletados == 4) {
                        completo()
                    }
                } else {
                    toast("Incorrecto, vuelve a intertarlo")
                    btnreto1.setBackgroundResource(R.color.colorrojo)

                }
            }

            if (requestCode == RETO2_REQUEST) {
                if (resultCode == Activity.RESULT_OK) {
                    toast("¡Enhorabuena has acertado!")
                    btnreto2.setBackgroundResource(R.color.colorverde) //cambiamos el icono a color
                    btnreto2.setEnabled(false) //desactivamos el boton
                    retoscompletados += 1
                    //si ganas todos los retos
                    if (retoscompletados == 4) {
                        completo()

                    }

                } else {
                    toast("Has fallado... ¡Vuelve a intentarlo!")
                    btnreto2.setBackgroundResource(R.color.colorrojo)
                }
            }



            if (requestCode == RETO3_REQUEST) {
                if (resultCode == Activity.RESULT_OK) {
                    toast("¡RETO SUPERADO!")
                    btnreto3.setBackgroundResource(R.color.colorverde) //cambiamos el icono a color
                    btnreto3.setEnabled(false) //desactivamos el boton
                    retoscompletados += 1
                    //si ganas todos los retos
                    if (retoscompletados == 4) {
                        completo()

                    }

                } else {
                    toast("Has fallado... ¡Vuelve a intentarlo!")
                    btnreto3.setBackgroundResource(R.color.colorrojo)
                }
            }
            if (requestCode == RETO4_REQUEST) {
                if (resultCode == Activity.RESULT_OK) {
                    toast("¡HAS SUPERADO EL RETO!")
                    btnreto4.setBackgroundResource(R.color.colorverde) //cambiamos el icono a color
                    btnreto4.setEnabled(false) //desactivamos el boton
                    retoscompletados += 1
                    //si ganas todos los retos
                    if (retoscompletados == 4) {
                        completo()

                    }

                } else {
                    toast("Has fallado... ¡Vuelve a intentarlo!")
                    btnreto4.setBackgroundResource(R.color.colorrojo)
                }
            }
        }
    }


