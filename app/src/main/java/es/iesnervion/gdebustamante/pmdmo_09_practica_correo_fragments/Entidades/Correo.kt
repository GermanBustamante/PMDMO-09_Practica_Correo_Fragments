package es.iesnervion.gdebustamante.pmdmo_09_practica_correo_fragments.Entidades

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class Correo(val de: String, val asunto: String, val texto: String)