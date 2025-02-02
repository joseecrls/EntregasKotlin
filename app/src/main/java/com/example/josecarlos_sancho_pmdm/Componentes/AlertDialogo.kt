package com.example.josecarlos_sancho_pmdm.Componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@Composable
fun AlertDialogo(texto: String, lambda: (borrado: Boolean) -> Unit) {
    /*
    Esta implementado en la clase EditarAlimento, esta no la uso
     */
    AlertDialog(
        onDismissRequest = { lambda(false) },
        title = {
            Text(text = "Confirmación", textAlign = TextAlign.Center)
        },
        text = {
            Text(text = texto)
        },
        confirmButton = {
            Button(onClick = { lambda(true) }) {
                Text("Aceptar")
            }
        },
        dismissButton = {
            Button(onClick = { lambda(false) }) {
                Text("Cancelar")
            }
        }
    )
}
