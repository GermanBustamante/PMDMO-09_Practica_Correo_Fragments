package es.iesnervion.gdebustamante.pmdmo_09_pruebas_fragments.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import es.iesnervion.gdebustamante.pmdmo_09_practica_correo_fragments.Entidades.Contacto
import es.iesnervion.gdebustamante.pmdmo_09_practica_correo_fragments.R
import es.iesnervion.gdebustamante.pmdmo_09_practica_correo_fragments.databinding.ListItemContactoBinding

class ContactoAdapter(
    private val correosList: MutableList<Contacto>,
    private val listener: (Contacto) -> Unit
) :
    RecyclerView.Adapter<ContactoAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ListItemContactoBinding.bind(view)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context

        val view = LayoutInflater.from(context).inflate(R.layout.list_item_contacto, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val correo = correosList[position]
        with(holder) {
            binding.tvDe.text = correo.nombre
            binding.tvAsunto.text = correo.apellidos
            itemView.setOnClickListener { listener(correo) }
        }
    }

    override fun getItemCount(): Int = correosList.size
}