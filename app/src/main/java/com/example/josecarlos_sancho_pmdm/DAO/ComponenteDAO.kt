package com.example.josecarlos_sancho_pmdm.DAO

import android.content.Context
import com.example.josecarlos_sancho_pmdm.BD_Fichero
import com.example.josecarlos_sancho_pmdm.Modelo.ComponenteDieta
import com.example.josecarlos_sancho_pmdm.Modelo.Ingrediente
import com.example.josecarlos_sancho_pmdm.Modelo.TipoComponente


object ComponenteDAO:ComponenteDAOI{

    override fun addListaCD(context: Context, lista: MutableList<ComponenteDieta>) {
        BD_Fichero.guardar(context, lista)
    }

    override fun CreateComponente(context: Context, componente: ComponenteDieta) {
        val lista=  BD_Fichero.leer(context)
        lista.add(componente)
        BD_Fichero.guardar(context, lista)
    }

    override fun readComponentes(context: Context): MutableList<ComponenteDieta> {
        return BD_Fichero.leer(context)
    }

    override fun readComponentesByTipo(
        context: Context,
        tipo: TipoComponente
    ): MutableList<ComponenteDieta> {
        val lista=BD_Fichero.leer(context)
        return lista.filter { it.tipo===tipo }.toMutableList()
    }

    override fun readComponente(context: Context, id: Int): ComponenteDieta? {
        val lista=BD_Fichero.leer(context)
        if(id>lista.size-1) return null
        else return lista[id]
    }

    override fun readComponente(context: Context, nombre: String): ComponenteDieta? {
        val lista=BD_Fichero.leer(context)
        return lista.first { it.nombre===nombre}
    }

    override fun readComponenteByIngrediente(context: Context, ing: Ingrediente): MutableList<ComponenteDieta>{
        val lista=BD_Fichero.leer(context)
        return lista.filter { it.ingredientes.contains(ing) }.toMutableList()
    }

    override fun updateComponente(
        context: Context,
        componenteOld: ComponenteDieta,
        componenteNew: ComponenteDieta
    ) {
        val lista=BD_Fichero.leer(context)
        if(lista.contains(componenteOld)){
            val inx=lista.indexOf(componenteOld)
            lista[inx]=componenteNew
            addListaCD(context, lista)
        }
    }

    override fun deleteComponente(context: Context, componente: ComponenteDieta): Boolean {
        val lista=BD_Fichero.leer(context)
        if(lista.contains(componente)){
            lista.remove(componente)
            addListaCD(context, lista)

            return true
        }else
            return false
    }


}