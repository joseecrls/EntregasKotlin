package com.example.josecarlos_sancho_pmdm.Componentes


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.josecarlos_sancho_pmdm.Pantallas.Ruta


@Composable
fun NavigationBottom(navController: NavController) {

    Row (
        modifier = Modifier.fillMaxWidth().fillMaxHeight(0.1f)
    ){
        Column(
            Modifier.weight(0.5f).fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(onClick = {
                navController.navigate(Ruta.Formulario.ruta)
            }){
                Text("Formulario")
            }


        }
        Column(
            Modifier.weight(0.5f).fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(onClick = {
                navController.navigate(Ruta.ListadoDetalle.ruta)
            }){
                Text("Listado")
            }
        }
    }
}




/*
@Composable
@Preview(showBackground = true)
fun Prev(modifier: Modifier = Modifier) {
    Column(Modifier.fillMaxSize()) {
        NavigationBottom(null)
    }
}
*/






/*
@Composable
@Preview(showBackground = true)
fun Prev(modifier: Modifier = Modifier) {
    Column(Modifier.fillMaxSize()) {
        NavigationBottom(null)
    }
}
*/
