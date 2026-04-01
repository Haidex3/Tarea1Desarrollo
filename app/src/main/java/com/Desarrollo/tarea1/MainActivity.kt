package com.Desarrollo.tarea1

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.Desarrollo.tarea1.ui.theme.Tarea1Theme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("APP_INIT", "Aplicación iniciada")

        setContent {
            Tarea1Theme {
                AppUI()
            }
        }
    }
}

@Composable
fun AppUI() {

    val universidad = remember {
        Universidad().apply {
            agregarArticulo(Articulo("Inteligencia Artificial", 3, 120))
            agregarArticulo(Articulo("Big Data", 2, 80))
            agregarArticulo(Articulo("Ciberseguridad", 4, 60))
        }
    }

    var titulo by remember { mutableStateOf("") }
    var autores by remember { mutableStateOf("") }
    var citas by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {

        OutlinedTextField(
            value = titulo,
            onValueChange = { titulo = it },
            label = { Text("Título") }
        )

        OutlinedTextField(
            value = autores,
            onValueChange = { autores = it },
            label = { Text("Autores") }
        )

        OutlinedTextField(
            value = citas,
            onValueChange = { citas = it },
            label = { Text("Citas") }
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(onClick = {
            val art = Articulo(
                titulo,
                autores.toIntOrNull() ?: 0,
                citas.toIntOrNull() ?: 0
            )
            universidad.agregarArticulo(art)
            resultado = "Artículo agregado"
        }) {
            Text("Agregar")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            resultado = universidad.listarCatalogo()
        }) {
            Text("Listar")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = resultado)
    }
}