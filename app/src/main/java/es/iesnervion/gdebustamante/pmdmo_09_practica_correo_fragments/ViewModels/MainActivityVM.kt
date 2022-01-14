package es.iesnervion.gdebustamante.pmdmo_09_practica_correo_fragments.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import es.iesnervion.gdebustamante.pmdmo_09_practica_correo_fragments.Entidades.Correo

class MainActivityVM : ViewModel() {

    val correoSelected = MutableLiveData<Correo>()
    val visualizacion = MutableLiveData<String>()

}