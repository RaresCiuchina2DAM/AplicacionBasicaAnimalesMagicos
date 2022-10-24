package com.example.myapplication


import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.core.view.isNotEmpty


class MainActivity : AppCompatActivity() {

    private lateinit var txtNombre: EditText
    private lateinit var txtEdad: EditText
    private lateinit var txtClase: EditText
    private lateinit var txtRaza: EditText
    private lateinit var btnAceptar: Button
    private lateinit var txtMochila: EditText
    private lateinit var cmbOpciones: Spinner
    private lateinit var btnGoblin: Button
    private lateinit var btnHumano: Button
    private lateinit var btnElfo: Button
    private lateinit var btnEnano: Button


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Obtenemos una referencia a los controles de la interfaz

        txtNombre = findViewById(R.id.txtNombre)
        txtEdad = findViewById(R.id.txtEdad)
        txtMochila = findViewById(R.id.txtMochila)
        btnAceptar = findViewById(R.id.aceptar)
        txtClase = findViewById(R.id.Clase)
        btnGoblin = findViewById(R.id.esGOBLIN)
        btnHumano = findViewById(R.id.esHUMANO)
        btnElfo = findViewById(R.id.esELFO)
        btnEnano = findViewById(R.id.esENANO)
        cmbOpciones = findViewById(R.id.cmbOpciones)


        val datos = arrayOf("Mago", "Ladron", "Guerrero", "Berserker")
        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, datos)
        cmbOpciones.adapter = adaptador


        cmbOpciones.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                txtClase.setText(datos[position])
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                txtClase.error = "Debe seleccionar una clase"
            }
        }


        if (btnGoblin.isPressed){
            txtRaza.setText("Goblin")
            btnGoblin.setBackgroundColor(getColor(R.color.purple_500))
            //reseteo
            btnHumano.setBackgroundColor(getColor(R.color.colorPrimary))
            btnElfo.setBackgroundColor(getColor(R.color.colorPrimary))
            btnEnano.setBackgroundColor(getColor(R.color.colorPrimary))
        }

        if (btnHumano.isPressed){
            txtRaza.setText("Humano")
            btnHumano.setBackgroundColor(getColor(R.color.purple_500))
            //reseteo de los demas
            btnGoblin.setBackgroundColor(getColor(R.color.colorPrimary))
            btnElfo.setBackgroundColor(getColor(R.color.colorPrimary))
            btnEnano.setBackgroundColor(getColor(R.color.colorPrimary))
        }

        if (btnElfo.isPressed){
            txtRaza.setText("Elfo")
            btnElfo.setBackgroundColor(getColor(R.color.purple_500))
            //reseteo de los demas
            btnGoblin.setBackgroundColor(getColor(R.color.colorPrimary))
            btnHumano.setBackgroundColor(getColor(R.color.colorPrimary))
            btnEnano.setBackgroundColor(getColor(R.color.colorPrimary))
        }

        if (btnEnano.isPressed){
            txtRaza.setText("Enano")
            btnEnano.setBackgroundColor(getColor(R.color.purple_500))
            //reseteo de los demas
            btnGoblin.setBackgroundColor(getColor(R.color.colorPrimary))
            btnHumano.setBackgroundColor(getColor(R.color.colorPrimary))
            btnElfo.setBackgroundColor(getColor(R.color.colorPrimary))
        }



        btnAceptar.setOnClickListener {
                validar(it)
        }
    }

    //fun validar (v: View){
    fun validar(view: View) {

        //clase
        if (txtClase.text.isEmpty()) {
            txtClase.error = "Debe seleccionar una clase"
        }
        if (txtNombre.text.isEmpty()) {
             txtNombre.error = "Debe ingresar un nombre"
        }
        if (txtEdad.text.isEmpty()) {
                txtEdad.error = "Debe ingresar una edad"
        }
        if (txtMochila.text.isEmpty()) {
                txtMochila.error = "Debe ingresar una mochila"
        }
        if (txtRaza.text.isEmpty()) {
                txtRaza.error = "Debe seleccionar una raza"
        }
        if (txtNombre.text.isNotEmpty() &&
            txtEdad.text.isNotEmpty() &&
            txtMochila.text.isNotEmpty() &&
            txtRaza.text.isNotEmpty() &&
            txtClase.text.isNotEmpty()) {

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


