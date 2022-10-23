package com.example.myapplication

import java.io.Serializable

class Jugador : Serializable {
    //variables
    var sumValor = 0
    var sumPeso = 0
    var oficio = ""
    var nombre = ""
    var capacidadPesoMochilaMax = 0.0
    var estadoVital = 0
    var razas = ""
    var clase = ""


    //contructor
    constructor(nombre: String?, capacidadPesoMochilaMax: Double, estadoVital: Int, razas: String?, clase: String?) {
        if (nombre != null) {
            this.nombre = nombre
        }
        this.capacidadPesoMochilaMax = capacidadPesoMochilaMax.toDouble()
        this.estadoVital =estadoVital
        if (razas != null) {
            this.razas = razas
        }
        if (clase != null) {
            this.clase = clase
        }
    }

    //impresión
    override fun toString(): String {
        return "Jugador(nombre='$nombre'," +
                " capacidadPesoMochilaMax=$capacidadPesoMochilaMax, " +
                "estadoVital = $estadoVital,"+
                "razas = $razas," +
                "clase = $clase)"
    }

    fun getNombre(jugador : Jugador): String {
        return jugador.nombre
    }

    @JvmName("setNombre1")
    fun setNombre(variable: String) {
        this.nombre = variable
    }

}


//Objeto a robar
class Objeto {
    var peso = 0
    var valor = 0

    constructor(peso : Int , valor : Int){
        this.peso=peso
        this.valor=valor
    }

}



