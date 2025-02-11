package com.example.josecarlos_sancho_pmdm.RoomDAO

import android.content.Context
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.josecarlos_sancho_pmdm.Modelo.ComponenteDieta
import com.example.josecarlos_sancho_pmdm.Modelo.Ingrediente
import com.example.josecarlos_sancho_pmdm.Modelo.TipoComponente
/*
@Dao
interface ComponenteRoomDAOI {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun CreateComponente(context: Context, componente: ComponenteDieta)

    @Query("")
    fun readComponentes(context: Context,): MutableList<ComponenteDieta>

    @Query("")
    fun readComponentesByTipo(context: Context, tipo: TipoComponente): MutableList<ComponenteDieta>

    @Query("")
    fun readComponente(context: Context, id:Int): ComponenteDieta?

    @Query("")
    fun readComponente(context: Context, nombre:String): ComponenteDieta?

    @Query("")
    fun readComponenteByIngrediente(context: Context, ing: Ingrediente): MutableList<ComponenteDieta>

    @Update(onConflict = OnConflictStrategy.ABORT)
    fun updateComponente(context: Context, componenteOld: ComponenteDieta, componenteNew: ComponenteDieta)

    @Delete
    fun deleteComponente(context: Context, componente: ComponenteDieta):Boolean
}*/