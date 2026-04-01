package com.Desarrollo.tarea1

data class Usuario(
    val username: String,
    val vistos: MutableList<String>,
    var tiempoTotal: Double
)