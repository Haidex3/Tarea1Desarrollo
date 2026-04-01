package com.Desarrollo.tarea1

class PlataformaStreaming {

    private val usuarios = mutableListOf<Usuario>()

    fun agregarUsuario(usuario: Usuario) {
        usuarios.add(usuario)
    }

    fun eliminarUsuario(username: String) {
        usuarios.removeIf { it.username == username }
    }

    fun totalHoras(): Double {
        return usuarios.sumOf { it.tiempoTotal }
    }

    fun usuarioCinefilo(): Usuario? {
        return usuarios.maxByOrNull { it.vistos.size }
    }
}