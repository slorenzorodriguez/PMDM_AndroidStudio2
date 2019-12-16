package com.dam2.projecto4retos

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_reto2.*
import org.jetbrains.anko.toast

class ActivityReto2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reto2)
        toast("Un poco de matemáticas...")
        num1.setEnabled(false)
        num2.setEnabled(false)
        num3.setEnabled(false)
        okbutton.setOnClickListener{( calcular(it))}
    }

    //método para calcular y comprobar que la respuesta es la correcta
    private fun calcular(v: View){
        var num1 = Integer.parseInt(num1.text.toString())
        var num2 = Integer.parseInt(num2.text.toString())
        var num3 = Integer.parseInt(num3.text.toString())

        var calculo = 65
        var respuesta = Integer.parseInt(respuestacalc.text.toString())

        if (calculo == respuesta) {
            var resp = true
            val intent = Intent()
            intent.putExtra("resp", resp)
            setResult(Activity.RESULT_OK, intent)
            finish()
        } else {
            finish()
        }

    }
    }



