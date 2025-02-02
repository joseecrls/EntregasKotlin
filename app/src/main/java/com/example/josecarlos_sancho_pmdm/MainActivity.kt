package com.example.josecarlos_sancho_pmdm

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.josecarlos_sancho_pmdm.Componentes.DrawerContent
import com.example.josecarlos_sancho_pmdm.Componentes.NavigationBottom
import com.example.josecarlos_sancho_pmdm.Modelo.ComponenteDieta
import com.example.josecarlos_sancho_pmdm.Modelo.AlimentosViewModel
import com.example.josecarlos_sancho_pmdm.Pantallas.Formulario
import com.example.josecarlos_sancho_pmdm.Pantallas.ListadoDetalle
import com.example.josecarlos_sancho_pmdm.Pantallas.Ruta
import com.example.josecarlos_sancho_pmdm.ui.theme.JoseCarlos_Sancho_PMDMTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        BD_Fichero.initialize("Fichero.obj")

        val viewModel: AlimentosViewModel = AlimentosViewModel()

        var lista=BD_Fichero.leer(this)
        Log.d("lista: ", lista.get(2).ingredientes.toString())

        enableEdgeToEdge()
        setContent {
            JoseCarlos_Sancho_PMDMTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Main(viewModel, lista,this, modifier = Modifier.padding(innerPadding),
                        name = "Examen Jose Carlos")

                }
            }
        }
    }
}

@Composable
fun Main(viewModel: AlimentosViewModel, lista: MutableList<ComponenteDieta>, context: Context, modifier: Modifier = Modifier, name: String){

    var alimentos = remember { mutableStateListOf<ComponenteDieta>() }
    alimentos.addAll(lista)
    val navigationController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    Column(modifier.padding(20.dp)){
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                DrawerContent {
                        route -> scope.launch { drawerState.close() }
                    navigationController.navigate(route)
                }
            }
        ){
            Scaffold(
                topBar = {
                    NavigationBottom(navigationController)
                }
            ){ paddingValues ->
                NavHost(
                    navController = navigationController,
                    startDestination = Ruta.Formulario.ruta,
                    modifier = Modifier.padding(paddingValues)
                ) {
                    composable(Ruta.Formulario.ruta) { Formulario(viewModel ,context, alimentos) }
                    composable(Ruta.ListadoDetalle.ruta) { ListadoDetalle(context,alimentos) }
                }
            }
        }
    }
}
