package es.iesnervion.gdebustamante.pmdmo_09_practica_correo_fragments.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import es.iesnervion.gdebustamante.pmdmo_09_practica_correo_fragments.Entidades.Correo
import es.iesnervion.gdebustamante.pmdmo_09_practica_correo_fragments.MainActivity
import es.iesnervion.gdebustamante.pmdmo_09_practica_correo_fragments.R
import es.iesnervion.gdebustamante.pmdmo_09_practica_correo_fragments.ViewModels.MainActivityVM
import es.iesnervion.gdebustamante.pmdmo_09_pruebas_fragments.Adapters.CorreoAdapter


/**
 * A simple [Fragment] subclass.
 * Use the [ListaCorreosFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListaCorreosFragment : Fragment() {

    private val viewModel : MainActivityVM by activityViewModels()

    private val datos =
        MutableList(20) { i -> Correo("Persona $i", "Asunto del correo $i", "Texto del correo $i") }

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        arguments?.let { //TODO ESTUDIAR LET()
//            //TODO AQUÍ IRIAN SI RECOGIESE DATOS DEL BUNDLE
//        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_lista_correos, container, false)
        //Aquí inicializamos lo referente a la interfaz
        recyclerView = view.findViewById<RecyclerView>(R.id.rcVw).apply {
            layoutManager = LinearLayoutManager(view?.context)
            adapter = CorreoAdapter(datos) { onCorreoSelected(it) }
        }

        return view
    }

    private fun onCorreoSelected(correo: Correo){
        //Actualizamos el frg llamando al observer del viewModel
        viewModel.visualizacion.postValue(getString(R.string.VISUALIZACION_DETALLE))
        viewModel.correoSelected.postValue(correo)//Podria pasarle el String pero es más correcto
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ListaCorreosFragment.
         */
        @JvmStatic
        fun newInstance() =
            ListaCorreosFragment().apply {
                arguments = Bundle().apply {
                    //Aquí irian los parámetros que quisiera meter
                }
            }
    }
}