package com.example.justo.viewmodel

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.justo.model.data.Person
import com.example.justo.model.remote.PersonApi
import com.example.justo.view.fragment.list.PersonListFragment
import kotlinx.coroutines.launch

class PersonViewModel : ViewModel() {

    private val _response = MutableLiveData<List<Person>>()
    val response: LiveData<List<Person>> = _response

    private var _person = MutableLiveData<Person>()
    var person :LiveData<Person> = _person

    val lista: MutableList<Person> = mutableListOf()

    var loadList: Boolean = PersonListFragment.band

    var loading: String = "visible"


    init {
        getPerson()
    }

    private fun getPerson(){
        viewModelScope.launch {

            var respuesta: Person

            var init = 1
            val pass = 5
            val finalHero = 10
            val iterations: Int = finalHero/pass
            var end = pass

            if(!loadList){
                for (flag in 0..iterations){
                    for (id in init..end) {
                        respuesta = PersonApi.retrofitService.getPerson()

                        lista.add(respuesta)

                        if (lista.size > 0) loading = "gone"

                        updateData()
                    }
                }

                PersonListFragment.band = true
                cargarResultados(lista)
            }

            Log.d("size ", lista.size.toString())

        }
    }

    private fun cargarResultados(resultado: List<Person>? = null){

        listaPersonas = arrayListOf()

        if(resultado != null && resultado.size > 0){
            (listaPersonas as ArrayList<Person>).addAll(resultado)
        }
    }

    fun getPersonDetails(id: Int) {
        viewModelScope.launch {
            try {
                _person.value = listaPersonas[id]

                Log.d("person", _person.toString())
            } catch (e: Exception) {
                Log.e("RestService","Failure: ${e.message}")
            }
        }
    }

    fun setContentVisibility(view: View) {
        if (view.visibility == View.GONE) {
            view.visibility = View.VISIBLE
        } else {
            view.visibility = View.GONE
        }
    }

    fun updateData() {
        _response.value = lista

    }

    companion object {
        var listaPersonas : List<Person> = arrayListOf()
    }

}
