package com.dam2.projecto4retos

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_reto1.*
import org.jetbrains.anko.browse
import org.jetbrains.anko.toast

class ActivityReto1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reto1)
        toast("¡¡TRATA DE ACERTARLO!!")
        answer1.setOnClickListener{(respuesta(it,1))}
        answer2.setOnClickListener{(respuesta(it,2))}
        answer3.setOnClickListener{(respuesta(it,3))}
        answer4.setOnClickListener{(respuesta(it,4))}
        helpbtn.setOnClickListener{(help(it))}
    }

//metodo para seleccionar la respuesta correcta (la 3); recibe un int que corresponde a la posición de la respuesta, si no es 3 false, si es, true
    private fun respuesta(v: View, r: Int){
        if (r == 3){
            val intent = Intent ()
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        finish()
    }


    private fun help (v: View){
        browse("/https://es.wikipedia.org/wiki/Categor%C3%ADa:Puentes_de_Europa")
        toast("¿En serio necesitas ayuda?")
    }

}
