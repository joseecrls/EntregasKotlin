package com.example.josecarlos_sancho_pmdm.DAO

import android.content.Context
import com.example.josecarlos_sancho_pmdm.Modelo.ComponenteDieta
import com.example.josecarlos_sancho_pmdm.Modelo.Ingrediente
import com.example.josecarlos_sancho_pmdm.Modelo.TipoComponente

interface ComponenteDAOI {

    fun addListaCD(context: Context, lista: MutableList<ComponenteDieta>)
    fun CreateComponente(context: Context, componente:ComponenteDieta)
    fun readComponentes(context: Context,): MutableList<ComponenteDieta>
    fun readComponentesByTipo(context: Context, tipo: TipoComponente): MutableList<ComponenteDieta>
    fun readComponente(context: Context, id:Int):ComponenteDieta?
    fun readComponente(context: Context, nombre:String):ComponenteDieta?
    fun readComponenteByIngrediente(context: Context, ing:Ingrediente): MutableList<ComponenteDieta>
    fun updateComponente(context: Context, componenteOld: ComponenteDieta, componenteNew:ComponenteDieta)
    fun deleteComponente(context: Context, componente:ComponenteDieta):Boolean
}