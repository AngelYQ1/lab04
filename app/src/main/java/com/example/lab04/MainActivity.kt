package com.example.lab04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Icon

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ShowAlertDialog()
        Spacer(modifier = Modifier.height(16.dp))
        CheckBox()
        Spacer(modifier = Modifier.height(16.dp))
        FloatingActionButton()
    }
}

@Composable
fun ShowAlertDialog() {
    var showDialog by remember { mutableStateOf(false) }

    Button(onClick = { showDialog = true }) {
        Text("Mostrar Diálogo")
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text("Título del Diálogo") },
            text = { Text("Este es un mensaje.") },
            confirmButton = {
                Button(onClick = { showDialog = false }) {
                    Text("Aceptar")
                }
            },
            dismissButton = {
                Button(onClick = { showDialog = false }) {
                    Text("Cancelar")
                }
            }
        )
    }
}

@Composable
fun CheckBox() {
    val checkedState = remember { mutableStateOf(false) }

    Checkbox(
        checked = checkedState.value,
        onCheckedChange = { checkedState.value = it }
    )
    Text(text = if (checkedState.value) "Seleccionado" else "No Seleccionado")
}

@Composable
fun FloatingActionButton() {
    FloatingActionButton(onClick = { }) {
        Icon(Icons.Filled.Add, contentDescription = "Agregar")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    MainScreen()
}