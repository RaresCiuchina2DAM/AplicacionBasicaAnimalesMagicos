package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText


class MainActivity : AppCompatActivity() {

    private lateinit var txtNombre : EditText
    private lateinit var txtOficio : EditText
    private lateinit var txtEdad : EditText
    private lateinit var txtClase : EditText
    private lateinit var txtRaza : EditText
    private lateinit var btnAceptar : Button
    private lateinit var txtMochila :EditText





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Obtenemos una referencia a los controles de la interfaz
        txtNombre = findViewById(R.id.txtNombre)
        txtOficio = findViewById(R.id.txtOficio)
        txtEdad = findViewById(R.id.txtEdad)
        txtClase = findViewById(R.id.txtClase)
        txtRaza = findViewById(R.id.txtRaza)
        txtMochila = findViewById(R.id.CapacidadMochila)
        btnAceptar = findViewById(R.id.CrearPersonaje)

        var personaje = Jugador(txtOficio.toString(),
                            txtNombre.toString(),
                            txtMochila.toString().toDouble(),
                            txtEdad.toString().toInt(),
                            txtRaza.toString(),
                            txtClase.toString())

        //Creamos el Intent
        btnAceptar.setOnClickListener {
            val intent = Intent(this@MainActivity, SaludoActivity::class.java)
            //Añadimos al intent la información a pasar entre actividades
            var bundle = Bundle()
            bundle.putSerializable("personaje",personaje)
            intent.putExtras(bundle)
            //Iniciamos la nueva actividad
            startActivity(intent)
        }
    }
}