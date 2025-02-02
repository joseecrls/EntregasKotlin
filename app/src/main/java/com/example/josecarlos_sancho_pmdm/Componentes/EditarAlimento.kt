package com.example.josecarlos_sancho_pmdm.Componentes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.josecarlos_sancho_pmdm.Modelo.ComponenteDieta

@Composable
fun EditarAlimento(
    alimento: ComponenteDieta,
    onGuardar: (ComponenteDieta) -> Unit,
    onBorrar: () -> Unit,
    onCancelar: () -> Unit
) {
    // Hacemos una copia mutable de los valores de alimento para poder editarlos
    var nombre by remember { mutableStateOf(alimento.nombre) }
    var grPro by remember { mutableStateOf(alimento.grPro_ini.toString()) }
    var grHC by remember { mutableStateOf(alimento.grHC_ini.toString()) }
    var grLip by remember { mutableStateOf(alimento.grLip_ini.toString()) }

    AlertDialog(
        onDismissRequest = { onCancelar() }, // Cuando se hace click fuera del AlertDialog, se cierra
        title = { Text("Editar Componente") },
        text = {
            LazyColumn(modifier = Modifier.padding(16.dp)) {
                // Campos de texto para editar los valores
                item {
                    TextField(
                        value = nombre,
                        onValueChange = { nombre = it },
                        label = { Text("Nombre") }
                    )
                    TextField(
                        value = grPro,
                        onValueChange = { grPro = it },
                        label = { Text("Proteínas (g)") },
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                    )
                    TextField(
                        value = grHC,
                        onValueChange = { grHC = it },
                        label = { Text("Hidratos de carbono (g)") },
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                    )
                    TextField(
                        value = grLip,
                        onValueChange = { grLip = it },
                        label = { Text("Lípidos (g)") },
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                    )
                }

            }
        },
        confirmButton = {
            Button(onClick = {
                // Crear una nueva instancia de ComponenteDieta con los valores editados
                val alimentoModificado = alimento.copy(
                    nombre = nombre,
                    grPro_ini = grPro.toDoubleOrNull() ?: alimento.grPro_ini,
                    grHC_ini = grHC.toDoubleOrNull() ?: alimento.grHC_ini,
                    grLip_ini = grLip.toDoubleOrNull() ?: alimento.grLip_ini
                )
                // Pasamos el alimento modificado al callback
                onGuardar(alimentoModificado)
            }) {
                Text("Guardar")
            }

            Spacer(modifier=Modifier.height(5.dp))
            Button(onClick = onBorrar) {
                Text("Borrar")
            }
        },
        dismissButton = {
            Button(onClick = onCancelar) {
                Text("Cancelar")
            }
        },
        // Tercer botón "Cancelar"

    )
}