package com.example.myapplication


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText


class MainActivity : AppCompatActivity() {

    private lateinit var txtNombre: EditText
    private lateinit var txtEdad: EditText
    private lateinit var txtClase: EditText
    private lateinit var txtRaza: EditText
    private lateinit var btnAceptar: Button
    private lateinit var txtMochila: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Obtenemos una referencia a los controles de la interfaz

        txtNombre = findViewById(R.id.txtNombre)
        txtEdad = findViewById(R.id.txtEdad)
        txtMochila = findViewById(R.id.txtMochila)
        btnAceptar = findViewById(R.id.aceptar)
        txtRaza = findViewById(R.id.txtRaza)
        txtClase = findViewById(R.id.txtClase)

        btnAceptar.setOnClickListener {
            validar(it)
        }
    }

    //fun validar (v: View){
    fun validar(view: View) {

        if (txtNombre.text.toString().isEmpty()) {
            txtNombre.error = "Campo obligatorio"
        }
        if (txtEdad.text.toString().isEmpty()) {
            txtEdad.error = "Campo obligatorio"
        }

        if (txtClase.text.toString().isEmpty()) {
            txtClase.error = "Campo obligatorio"
        } else if (txtClase.text.toString() != "Guerrero"
            && txtClase.text.toString() != "Mago"
            && txtClase.text.toString() != "Arquero"
        ) {
            txtClase.error = "Solo puede ser Guerrero, Mago o Arquero"
        }

        if (txtRaza.text.toString().isEmpty()) {
            txtRaza.error = "Campo obligatorio"
        } else if (txtRaza.text.toString() != "Humano"
            && txtRaza.text.toString() != "Elfo"
            && txtRaza.text.toString() != "Enano"
        ) {
            txtRaza.error = "Solo puede ser Humano, Elfo o Enano"
        }

        if (txtMochila.text.toString().isEmpty()) {
            txtMochila.error = "Campo obligatorio"
        }

        if ((txtClase.text.toString() == "Guerrero"
            || txtClase.text.toString() == "Mago"
            || txtClase.text.toString() == "Arquero"
        )&& (txtRaza.text.toString() == "Humano"
            || txtRaza.text.toString() == "Elfo"
            || txtRaza.text.toString() == "Enano"
                    )&& txtNombre.text.toString().isNotEmpty()
            && txtEdad.text.toString().isNotEmpty()
            && txtClase.text.toString().isNotEmpty()
            && txtRaza.text.toString().isNotEmpty()
            && txtMochila.text.toString().isNotEmpty()

        ) {
            val intent = Intent(this, SaludoActivity::class.java)

            //Creamos la información a pasar entre actividades
            val b = Bundle()
            b.putString("txtNombre", txtNombre.text.toString())
            b.putInt("txtEdad", txtEdad.text.toString().toInt())
            b.putString("txtClase", txtClase.text.toString())
            b.putString("txtRaza", txtRaza.text.toString())
            b.putDouble("txtMochila", txtMochila.text.toString().toDouble())

            //Añadimos la información al intent
            intent.putExtras(b)

            //Iniciamos la nueva actividad
            startActivity(intent)
        }

    }

}


