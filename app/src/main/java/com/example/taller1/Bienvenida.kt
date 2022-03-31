package com.example.taller1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button

class Bienvenida : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenida)
        supportActionBar?.hide()
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        val btnRegistro = findViewById<Button>(R.id.btnRegistro)//OBTENER EL BTN
        btnRegistro.setOnClickListener { onRegistroClick() }//Asignar la funcion de control para el clic del btn

        val btnEStadistica = findViewById<Button>(R.id.btnEStadistica)
        btnEStadistica.setOnClickListener { onEStadisticaClick() }

        val btnAyuda = findViewById<Button>(R.id.btnAyuda)
        btnAyuda.setOnClickListener { onAyudaClick() }
    }

    fun onRegistroClick() {
        val iniciar = Intent(this,MainActivity::class.java)
        startActivity(iniciar)//inicio la actividad
    }

    fun onEStadisticaClick() {
        val iniciar = Intent(this,Bienvenida::class.java)
        startActivity(iniciar)//inicio la actividad
    }

    fun onAyudaClick() {
        val iniciar = Intent(this,Ayuda::class.java)
        startActivity(iniciar)//inicio la actividad
    }


}