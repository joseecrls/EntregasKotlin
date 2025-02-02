package com.example.josecarlos_sancho_pmdm.Modelo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AlimentosViewModel : ViewModel() {

    private val _nombre=MutableLiveData<String>("")
    private val _tipo=MutableLiveData<TipoComponente>(TipoComponente.MENU)
    private val _grHc=MutableLiveData<Double>(0.0)
    private val _grLip=MutableLiveData<Double>(0.0)
    private val _grPro=MutableLiveData<Double>(0.0)

    val nombre:LiveData<String> = _nombre
    val tipo:LiveData<TipoComponente> = _tipo
    val grHc:LiveData<Double> = _grHc
    val grLip:LiveData<Double> = _grLip
    val grPro:LiveData<Double> = _grPro


    // LiveData para la lista de componentes de dieta
    private val _alimentos = MutableLiveData<List<ComponenteDieta>>(emptyList())

    val alimentos: LiveData<List<ComponenteDieta>> = _alimentos

    fun updateAlimentos(lista:List<ComponenteDieta>){
        _alimentos.value=lista
    }

    fun updateNombre(nombre:String){
        _nombre.value=nombre
    }
    fun updatetipo(tp:TipoComponente){
        _tipo.value=tp
    }
    fun updateGrHc(grHc:Double){
        _grHc.value=grHc
    }
    fun updateGrLip(grLip:Double){
        _grLip.value=grLip
    }
    fun updateGrPro(grPro:Double){
        _grPro.value=grPro
    }

    fun resetFormulario() {
        _nombre.value = ""
        _tipo.value = TipoComponente.SIMPLE
        _grHc.value = 0.0
        _grLip.value = 0.0
        _grPro.value = 0.0
        _alimentos.value = emptyList()
    }

}
