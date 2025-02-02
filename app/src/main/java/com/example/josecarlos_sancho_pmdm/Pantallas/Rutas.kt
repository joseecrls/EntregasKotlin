package com.example.josecarlos_sancho_pmdm.Pantallas

sealed class Ruta(val ruta:String) {

    object Formulario:Ruta("formulario")
    object ListadoDetalle:Ruta("listas")

}