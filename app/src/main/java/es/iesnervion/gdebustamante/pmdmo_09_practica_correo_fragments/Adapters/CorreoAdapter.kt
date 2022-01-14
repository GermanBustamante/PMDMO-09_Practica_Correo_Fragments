package es.iesnervion.gdebustamante.pmdmo_09_pruebas_fragments.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import es.iesnervion.gdebustamante.pmdmo_09_practica_correo_fragments.Entidades.Correo
import es.iesnervion.gdebustamante.pmdmo_09_practica_correo_fragments.Fragments.ListaCorreosFragment
import es.iesnervion.gdebustamante.pmdmo_09_practica_correo_fragments.R
import es.iesnervion.gdebustamante.pmdmo_09_practica_correo_fragments.databinding.FragmentListaCorreosBinding
import es.iesnervion.gdebustamante.pmdmo_09_practica_correo_fragments.databinding.ListItemCorreoBinding

class CorreoAdapter(private val correosList: MutableList<Correo>, private val listener: (Correo)-> Unit) :
    RecyclerView.Adapter<CorreoAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ListItemCorreoBinding.bind(view)

        init {
            //TODO ENTENDER LISTENER
            // Define click listener for the ViewHolder's View.
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context

        val view = LayoutInflater.from(context).inflate(R.layout.list_item_correo, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val correo = correosList[position]
        with(holder) {
            binding.tvDe.text = correo.de
            binding.tvAsunto.text = correo.asunto
            itemView.setOnClickListener{listener(correo)}
        }
    }

    override fun getItemCount(): Int = correosList.size
}