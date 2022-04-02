package com.example.taller1

class Operaciones {
    companion object {
        val listaEstudiantes: ArrayList<Estudiante> =arrayListOf<Estudiante>()

        fun registrarEstudiante(estudiante: Estudiante){
            this.listaEstudiantes.add(estudiante)
        }

        fun imprimirListaEstudiantes(){
            for(est in listaEstudiantes){
                println(est)
            }
        }

        fun calcularPromedio(est: Estudiante): Double {
            return (est.nota1+est.nota2+est.nota3+est.nota4+est.nota5)/5
        }

    }
}
