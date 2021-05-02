package com.example.calculadora_simple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.lang.Exception

class Calculadora : AppCompatActivity() {
    private var operando: Double = 0.0
    private var operando_2: Double = 0.0
    private var operacion: Int = 0

    lateinit var txtResultado: TextView
    lateinit var txtOperacion: TextView
    lateinit var cero: Button
    lateinit var uno: Button
    lateinit var dos: Button
    lateinit var tres: Button
    lateinit var cuatro: Button
    lateinit var cinco: Button
    lateinit var seis: Button
    lateinit var siete: Button
    lateinit var ocho: Button
    lateinit var nueve: Button

    lateinit var sumar:Button
    lateinit var restar:Button
    lateinit var multiplicar:Button
    lateinit var dividir:Button
    lateinit var operar:Button
    lateinit var borrando:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        txtResultado = findViewById(R.id.finalizando)
        txtOperacion = findViewById(R.id.expresion)
        cero = findViewById(R.id.cero)
        uno = findViewById(R.id.uno)
        dos = findViewById(R.id.dos)
        tres = findViewById(R.id.tres)
        cuatro = findViewById(R.id.cuatro)
        cinco = findViewById(R.id.cinco)
        seis = findViewById(R.id.seis)
        siete = findViewById(R.id.siete)
        ocho = findViewById(R.id.ocho)
        nueve = findViewById(R.id.nueve)

        sumar = findViewById(R.id.sumando)
        restar = findViewById(R.id.restando)
        multiplicar = findViewById(R.id.multiplicando)
        dividir = findViewById(R.id.dividiendo)
        operar = findViewById(R.id.igual)

        borrando = findViewById(R.id.borrando)

        uno.setOnClickListener{presionando("1")}
        dos.setOnClickListener{presionando("2")}
        tres.setOnClickListener{presionando("3")}
        cuatro.setOnClickListener{presionando("4")}
        cinco.setOnClickListener{presionando("5")}
        seis.setOnClickListener{presionando("6")}
        siete.setOnClickListener{presionando("7")}
        ocho.setOnClickListener{presionando("8")}
        nueve.setOnClickListener{presionando("9")}
        cero.setOnClickListener{presionando("0")}

        sumar.setOnClickListener{operaciones(s)}
        restar.setOnClickListener{operaciones(r)}
        multiplicar.setOnClickListener{operaciones(m)}
        dividir.setOnClickListener{operaciones(d)}

        operar.setOnClickListener{
            var resultado = when(operacion){
                s -> operando + operando_2
                r -> operando - operando_2
                m -> operando * operando_2
                d -> operando / operando_2
                else -> 0
            }
            txtResultado.text = resultado.toString()
        }

        borrando.setOnClickListener{
            operando = 0.0
            operando_2 = 0.0
            txtResultado.text=""
            operacion = nada
        }
    }

    private fun presionando(ss:String){
        txtResultado.text = "${txtResultado.text}$ss"

        if(operacion==nada){
            operando = txtResultado.text.toString().toDouble()
        }else {
            operando_2 = txtResultado.text.toString().toDouble()
        }
    }
    private fun operaciones(operacion: Int){
        this.operacion = operacion



        txtResultado.text = "0"
    }

    companion object{
        const val s = 1
        const val r = 2
        const val m = 3
        const val d = 4
        const val nada = 0
    }


}