package es.iesnervion.gdebustamante.pmdmo_09_practica_correo_fragments.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import es.iesnervion.gdebustamante.pmdmo_09_practica_correo_fragments.Entidades.Contacto

class MainActivityVM : ViewModel() {

    val contactoSelected = MutableLiveData<Contacto>()
    val visualizacion = MutableLiveData<String>()

}