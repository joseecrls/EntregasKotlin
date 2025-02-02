package com.example.josecarlos_sancho_pmdm

import android.content.Context
import android.util.Log
import com.example.josecarlos_sancho_pmdm.Modelo.ComponenteDieta
import java.io.IOException
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

object BD_Fichero {

    lateinit var nombreFichero: String
    var initialized=false

    fun initialize(nombreFichero: String){
        if (!initialized){
            this.nombreFichero=nombreFichero
            initialized=true
        }
    }

    fun guardar(context: Context, listaCD:MutableList<ComponenteDieta>) {
        try {
            context.openFileOutput(nombreFichero, Context.MODE_PRIVATE).use { fos ->
                ObjectOutputStream(fos).use { oos ->
                    oos.writeObject(listaCD.toMutableList())
                }

            }
        } catch (e: IOException) {
            Log.e("Error", "Error al guardar el archivo", e)
        }
    }

    fun leer(context: Context):MutableList<ComponenteDieta> {
        return if (context.getFileStreamPath(nombreFichero).exists()) {
            try {
                context.openFileInput(nombreFichero).use { fis ->
                    ObjectInputStream(fis).use { ois ->
                        ois.readObject() as MutableList<ComponenteDieta>

                    }

                }
            } catch (e: IOException) {
                Log.e("Error", "Error al leer el archivo", e)
                mutableListOf()
            } catch (e: ClassNotFoundException) {
                Log.e("Error", "Clase no encontrada", e)
                mutableListOf()
            }
        } else {
            mutableListOf() // Lista vacía si no hay archivo
        }
    }

    fun borrarArchivos(context: Context) {
        val archivo = context.getFileStreamPath(nombreFichero)
        if (archivo.exists() && !archivo.delete()) {
            Log.e("Error", "No se pudo eliminar el archivo")
        }
    }


}

