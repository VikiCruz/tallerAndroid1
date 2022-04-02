package com.example.taller1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText

class Registro : AppCompatActivity() {

    var campoDocumento: EditText?=null
    var campoNombre:EditText?=null
    var campoEdad:EditText?=null
    var campoTelefono:EditText?=null
    var campoDireccion:EditText?=null

    var campoMateria1:EditText?=null
    var campoMateria2:EditText?=null
    var campoMateria3:EditText?=null
    var campoMateria4:EditText?=null
    var campoMateria5:EditText?=null
    var campoNota1:EditText?=null
    var campoNota2:EditText?=null
    var campoNota3:EditText?=null
    var campoNota4:EditText?=null
    var campoNota5:EditText?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)


        supportActionBar?.hide()
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        iniciarComponentes()
    }

    private fun iniciarComponentes() {
        //Se instancia la clase operaciones
        campoDocumento=findViewById(R.id.editTextTextDocumento)
        campoNombre=findViewById(R.id.editTextTextNombre)
        campoEdad=findViewById(R.id.editTextEdad)
        campoTelefono=findViewById(R.id.editTextTextTelefono)
        campoDireccion=findViewById(R.id.editTextTextDireccion)

        campoMateria1=findViewById(R.id.editTextMateria1)
        campoMateria2=findViewById(R.id.editTextMateria2)
        campoMateria3=findViewById(R.id.editTextMateria3)
        campoMateria4=findViewById(R.id.editTextMateria4)
        campoMateria5=findViewById(R.id.editTextMateria5)

        campoNota1=findViewById(R.id.editTextTextNota1)
        campoNota2=findViewById(R.id.editTextTextNota2)
        campoNota3=findViewById(R.id.editTextTextNota3)
        campoNota4=findViewById(R.id.editTextTextNota4)
        campoNota5=findViewById(R.id.editTextTextNota5)

        var btnCalcular:Button=findViewById(R.id.btnCalcular)
        btnCalcular.setOnClickListener { registrarEstudiante() }

    }

    private fun registrarEstudiante() {
        //Se instancia la clase estudiante y se mapean los elementos del formulario
        val est:Estudiante= Estudiante()
        est.documento= campoDocumento?.text.toString()
        est.nombre=campoNombre?.text.toString()
        est.edad=campoEdad?.text.toString().toInt()
        est.direccion=campoDireccion?.text.toString()
        est.telefono=campoTelefono?.text.toString()

        est.materia1=campoMateria1?.text.toString()
        est.materia2=campoMateria2?.text.toString()
        est.materia3=campoMateria3?.text.toString()
        est.materia4=campoMateria4?.text.toString()
        est.materia5=campoMateria5?.text.toString()

        est.nota1= campoNota1?.text.toString().toDouble()
        est.nota2= campoNota2?.text.toString().toDouble()
        est.nota3= campoNota3?.text.toString().toDouble()
        est.nota4= campoNota4?.text.toString().toDouble()
        est.nota5= campoNota5?.text.toString().toDouble()

        est.promedio= Operaciones.calcularPromedio(est)
        Operaciones.registrarEstudiante(est)
        Operaciones.imprimirListaEstudiantes()
}

}
