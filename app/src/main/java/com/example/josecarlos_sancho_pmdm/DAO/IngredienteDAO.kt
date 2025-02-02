package com.example.josecarlos_sancho_pmdm.DAO

import android.content.Context
import com.example.josecarlos_sancho_pmdm.BD_Fichero
import com.example.josecarlos_sancho_pmdm.Modelo.ComponenteDieta
import com.example.josecarlos_sancho_pmdm.Modelo.Ingrediente


object DaoIngrediente: IngredienteDAOI {
    override fun createIngrediente(
        context: Context,
        padre: ComponenteDieta,
        ing: ComponenteDieta,
        cantidad: Double
    ): Boolean {
        val lista=  BD_Fichero.leer(context)
        if(lista.contains(padre)){
            val ingrediente=Ingrediente(ing, cantidad)
            val inx=lista.indexOf(padre)
            val comp=lista.get(inx)

            if(!comp.ingredientes.contains(ingrediente)){
                comp.addIngrediente(ingrediente)
                lista[inx]=comp
                ComponenteDAO.addListaCD(context, lista)
                return true
            }else
                return false
        }else
            return false
    }

    override fun readIngredienteByComponente(
        context: Context,
        componente: ComponenteDieta,
        ing: Ingrediente
    ): Ingrediente? {
        val lista= BD_Fichero.leer(context)
        val comp= lista.filter { it==componente }
        if (!comp.isEmpty()){
            val compEnc=comp.first()
            return compEnc.ingredientes.filter { it==ing }.first()
        }else{
            return null
        }
    }

    override fun readIngredientesByComponente(
        context: Context,
        Componente: ComponenteDieta
    ): MutableList<Ingrediente> {
        val listaComp= BD_Fichero.leer(context)
        val compEnc = listaComp.filter { it==Componente }.first()
        return compEnc.ingredientes
    }

    override fun updateIngrediente(
        context: Context,
        componente: ComponenteDieta,
        ingrediente: Ingrediente,
        cantidad: Double
    ): Boolean {

        val listaComp= BD_Fichero.leer(context)
        val comp = listaComp.filter { it==componente }
        if (!comp.isEmpty()){
            val compEnc=comp.first()
            compEnc.ingredientes.filter { it==ingrediente }.first().cantidad=cantidad
            BD_Fichero.guardar(context, listaComp)
            return true
        }else return false

    }

    override fun deleteIngredientebyComponente(
        context: Context,
        cd: ComponenteDieta,
        ing: Ingrediente
    ): Boolean {
        val lista= BD_Fichero.leer(context)
        val comp= lista.filter { it==cd }
        if (!comp.isEmpty()){
            val compEnc=comp.first()
            val ingEnc=compEnc.ingredientes.filter { it==ing }.first()
            compEnc.removeIngrediente(ingEnc)
            BD_Fichero.guardar(context, lista)
            return true
        }else{
            return false
        }
    }
}