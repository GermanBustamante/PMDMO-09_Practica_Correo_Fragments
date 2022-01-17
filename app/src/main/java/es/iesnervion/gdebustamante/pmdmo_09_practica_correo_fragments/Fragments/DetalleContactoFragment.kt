package es.iesnervion.gdebustamante.pmdmo_09_practica_correo_fragments.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import es.iesnervion.gdebustamante.pmdmo_09_practica_correo_fragments.Entidades.Contacto
import es.iesnervion.gdebustamante.pmdmo_09_practica_correo_fragments.ViewModels.MainActivityVM
import es.iesnervion.gdebustamante.pmdmo_09_practica_correo_fragments.databinding.FragmentDetalleContactoBinding

/**
 * A simple [Fragment] subclass.
 * Use the [DetalleContactoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetalleContactoFragment : Fragment() {
    //ViewModel
    private val viewModel: MainActivityVM by activityViewModels()
    //ViewBinding
    private var _binding : FragmentDetalleContactoBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetalleContactoBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.contactoSelected.observe(this, this::onContactoChanged)
    }

    private fun onContactoChanged(contacto: Contacto) {
        binding.tvNombreVM.text = contacto.nombre
        binding.tvApellidosVM.text = contacto.apellidos
        binding.tvDireccionVM.text = contacto.direccion
        binding.tvTelefonoVM.text = contacto.telefono
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DetalleCorreoFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(/*: String, param2: String*/) =
            DetalleContactoFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}