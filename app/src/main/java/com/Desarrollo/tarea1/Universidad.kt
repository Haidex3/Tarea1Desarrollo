package com.Desarrollo.tarea1

class Universidad {

    private val articulos = mutableListOf<Articulo>()

    fun agregarArticulo(articulo: Articulo) {
        articulos.add(articulo)
    }

    fun eliminarArticulo(titulo: String) {
        articulos.removeIf { it.titulo == titulo }
    }

    fun actualizarCitas(titulo: String, nuevasCitas: Int) {
        articulos.find { it.titulo == titulo }?.citas = nuevasCitas
    }

    fun listarCatalogo(): String {
        return articulos.joinToString("\n") {
            "Titulo: ${it.titulo}, Autores: ${it.autores}, Citas: ${it.citas}"
        }
    }
}