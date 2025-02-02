package com.example.josecarlos_sancho_pmdm.Pantallas

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.josecarlos_sancho_pmdm.Componentes.AlertDialogo
import com.example.josecarlos_sancho_pmdm.Modelo.ComponenteDieta
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.platform.LocalContext
import com.example.josecarlos_sancho_pmdm.BD_Fichero
import com.example.josecarlos_sancho_pmdm.Componentes.EditarAlimento
import com.example.josecarlos_sancho_pmdm.DAO.ComponenteDAO

@Composable
fun ListadoDetalle(context: Context, alimentos: SnapshotStateList<ComponenteDieta>) {
    var refAlimento by remember { mutableStateOf<ComponenteDieta?>(null) }
    var mostrarDialogo by remember { mutableStateOf<Boolean>(false) }

    Row(modifier = Modifier.fillMaxSize().padding(25.dp, 15.dp)) {

        Column {
            if (mostrarDialogo && refAlimento != null) {
                EditarAlimento(
                    alimento = refAlimento!!,
                    onGuardar = { alimentoModificado ->
                        val index = alimentos.indexOf(refAlimento)
                        if(index != -1){
                            alimentos[index]=alimentoModificado
                            ComponenteDAO.updateComponente(context, alimentos[index], alimentoModificado)
                            ComponenteDAO.addListaCD(context, alimentos)
                        //ComponenteDAO.addListaCD(context, alimentos)
                            /*
                            ComponenteDAO.updateComponente(context, alimentos[index], alimentoModificado)
                            //alimentos.clear()
                            alimentos.addAll(ComponenteDAO.readComponentes(context))
                            */

                        }
                        mostrarDialogo=false
                    },
                    onBorrar = {
                        // Eliminar el componente
                        ComponenteDAO.deleteComponente(context, refAlimento!!)
                        alimentos.remove(refAlimento)
                        mostrarDialogo = false
                    },
                    onCancelar = { mostrarDialogo = false }
                )
            } else {
                LazyColumn {
                    items(alimentos) { alimento ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(4.dp)
                                .clickable {
                                    // Al hacer clic en el item, mostramos el diálogo de edición
                                    refAlimento = alimento
                                    mostrarDialogo = true
                                },
                            border = BorderStroke(1.dp, Color.Gray)
                        ) {
                            Box(modifier = Modifier.padding(16.dp)) {
                                Text(text = "${alimento.nombre}: ${alimento.Kcal} Kcal", modifier = Modifier.padding(8.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}
