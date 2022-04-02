package com.example.taller1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager

class EstadisticasP : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estadisticas_p)

        supportActionBar?.hide()
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        Operaciones.listaEstudiantes
    }

}