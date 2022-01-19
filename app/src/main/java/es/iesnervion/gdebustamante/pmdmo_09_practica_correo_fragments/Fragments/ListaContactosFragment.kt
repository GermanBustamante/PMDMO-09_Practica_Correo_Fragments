package es.iesnervion.gdebustamante.pmdmo_09_practica_correo_fragments.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import es.iesnervion.gdebustamante.pmdmo_09_practica_correo_fragments.Entidades.Contacto
import es.iesnervion.gdebustamante.pmdmo_09_practica_correo_fragments.R
import es.iesnervion.gdebustamante.pmdmo_09_practica_correo_fragments.ViewModels.MainActivityVM
import es.iesnervion.gdebustamante.pmdmo_09_practica_correo_fragments.databinding.FragmentListaContactosBinding
import es.iesnervion.gdebustamante.pmdmo_09_pruebas_fragments.Adapters.ContactoAdapter


/**
 * A simple [Fragment] subclass.
 * Use the [ListaContactosFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListaContactosFragment : Fragment() {
    //ViewModel
    private val viewModel: MainActivityVM by activityViewModels()

    //Binding
    private var _binding: FragmentListaContactosBinding? = null

    private val binding get() = _binding!!

    //NavController
    private lateinit var navController: NavController

    private val datos =
        MutableList(20) { i -> Contacto("Contacto $i", "Apellidos $i", "$i", "Calle C/$i") }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListaContactosBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Aquí inicializamos lo referente a la interfaz
        navController = findNavController()

        binding.rcVw.apply {
            layoutManager = LinearLayoutManager(view?.context)
            adapter = ContactoAdapter(datos) { onContactoSelected(it) }
        }
    }

    private fun onContactoSelected(contacto: Contacto) {
        viewModel.contactoSelected.postValue(contacto)//Podria pasarle el String pero es más correcto

        val action = ListaContactosFragmentDirections.actionListaContactosFragmentToDetalleContactoFragment("German")
        //TODO 2 FORMAS DE NAVEGAR ENTRE FRAGMENTS
        navController.navigate(R.id.action_listaContactosFragment_to_detalleContactoFragment)
        //Puedes usar un with para usar popBackStack() o popBackStackChetao()
        //O DICIENDO
//        Navigation.createNavigateOnClickListener(R.id.action_listaContactosFragment_to_detalleContactoFragment)//TODO NO FUNCIONA HAY QUE VER PQ
    }
}