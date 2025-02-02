package com.example.josecarlos_sancho_pmdm.DAO

import android.content.Context
import com.example.josecarlos_sancho_pmdm.Modelo.ComponenteDieta
import com.example.josecarlos_sancho_pmdm.Modelo.Ingrediente

interface IngredienteDAOI {
    fun createIngrediente(context: Context, padre: ComponenteDieta, ing: ComponenteDieta, cantidad: Double):Boolean
    fun readIngredienteByComponente(context: Context,componente: ComponenteDieta, ing: Ingrediente):Ingrediente?
    fun readIngredientesByComponente(context: Context,Componente:ComponenteDieta):MutableList<Ingrediente>
    fun updateIngrediente (context: Context,componente: ComponenteDieta, ingrediente:Ingrediente, cantidad:Double):Boolean
    fun deleteIngredientebyComponente(context: Context,cd: ComponenteDieta, ing:Ingrediente):Boolean
}