package es.iesnervion.gdebustamante.pmdmo_09_pruebas_fragments.Adapters

import es.iesnervion.gdebustamante.pmdmo_09_practica_correo_fragments.Entidades.Correo

interface CorreosListener {
    fun onCorreoSeleccionado(correo: Correo)
}