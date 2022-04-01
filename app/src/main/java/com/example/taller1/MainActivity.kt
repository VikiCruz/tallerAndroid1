package com.example.taller1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    var operaciones: Operaciones?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)



        operaciones = Operaciones()
        iniciarComponentes()
    }
    private val response=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ valor ->
        if (valor.resultCode== RESULT_OK){
            //resp y resp 2 almacenan el mismo dato, solo se muestran 2 formas como podria capturarse el dato

            val resp2=valor?.data?.getStringExtra("resultado")
            println("la resps2=$resp2")

            //capturamos el objeto nuevo y lo asignamos a operaciones
            operaciones= valor?.data?.extras?.get("objetoOperaciones") as Operaciones?
            operaciones?.imprimirListaEstudiantes()
        }
    }

    private fun iniciarComponentes() {

        val botonRegistro:Button=findViewById(R.id.btnRegistro)
        val botonEstadisticas:Button=findViewById(R.id.btnEStadistica)
        val botonAyuda:Button=findViewById(R.id.btnAyuda)

        botonRegistro.setOnClickListener { onClick(1) }
        botonEstadisticas.setOnClickListener { onClick(2) }
        botonAyuda.setOnClickListener { onClick(3) }
    }

    private fun onClick(boton: Int) {

        when(boton){
            1->{
                var miIntent:Intent= Intent(this,Registro::class.java)
                var miBundle:Bundle= Bundle()
                miIntent.putExtras(miBundle)
                // startActivity(miIntent)
                response.launch(miIntent)
            }

            2->startActivity(Intent(this,EstadisticasP::class.java))
            3-> startActivity(Intent(this,Ayuda::class.java))
        }

    }



}