package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SaludoActivity : AppCompatActivity() {

    private lateinit var txtSaludo : TextView
    private lateinit var txtEdad : TextView
    private lateinit var txtClase : TextView
    private lateinit var txtRaza : TextView
    private lateinit var txtCapacidadMochila :  TextView

    private lateinit var vamosAHablar: EditText
    private lateinit var respuesta1 : TextView
    private lateinit var botonAceptar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saludo)

        //Obtenemos una referencia a los controles de la interfaz
        txtSaludo = findViewById(R.id.txtSaludo)
        txtEdad = findViewById(R.id.txtEdad)
        txtClase = findViewById(R.id.txtClase)
        txtRaza = findViewById(R.id.txtRaza)
        txtCapacidadMochila = findViewById(R.id.txtCapacidadMochilaSaludo)

        vamosAHablar = findViewById(R.id.hablemos)
        respuesta1 = findViewById(R.id.respuesta1)
        botonAceptar = findViewById(R.id.botonhablar)

        //Recuperamos la información pasada en el intent
        val saludo = intent.getStringExtra("txtNombre")
        val edad = intent.getIntExtra("txtEdad",0)
        val clase = intent.getStringExtra("txtClase")
        val raza = intent.getStringExtra("txtRaza")
        val mochila = intent.getDoubleExtra("txtMochila", 0.0)

        //Creamos el personaje y mostramos sus información
        var personaje = Jugador(saludo, mochila,edad, raza, clase)
        txtSaludo.text = "Hola ${personaje.nombre}!"
        txtEdad.text = "Tu edad es ${personaje.estadoVital}"
        txtClase.text = "Tu clase es ${personaje.clase}"
        txtRaza.text = "Tu raza es ${personaje.razas}"
        txtCapacidadMochila.text = "Tu capacidad de mochila es ${personaje.capacidadPesoMochilaMax}"


        //Hablar con el personaje
        botonAceptar.setOnClickListener {
            var respuesta = vamosAHablar.text.toString()
            respuesta1.text = comunicacion(respuesta,personaje)
        }



    }
}