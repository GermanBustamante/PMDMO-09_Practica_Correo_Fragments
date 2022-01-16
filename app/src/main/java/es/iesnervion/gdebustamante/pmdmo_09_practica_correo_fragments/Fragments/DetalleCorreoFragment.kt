package es.iesnervion.gdebustamante.pmdmo_09_practica_correo_fragments.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import es.iesnervion.gdebustamante.pmdmo_09_practica_correo_fragments.Entidades.Correo
import es.iesnervion.gdebustamante.pmdmo_09_practica_correo_fragments.R
import es.iesnervion.gdebustamante.pmdmo_09_practica_correo_fragments.ViewModels.MainActivityVM
import es.iesnervion.gdebustamante.pmdmo_09_practica_correo_fragments.databinding.FragmentDetalleCorreoBinding
import org.w3c.dom.Text

/**
 * A simple [Fragment] subclass.
 * Use the [DetalleCorreoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetalleCorreoFragment : Fragment() {
    //ViewModel
    private val viewModel: MainActivityVM by activityViewModels()
    //ViewBinding
    private var _binding : FragmentDetalleCorreoBinding? = null
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
        _binding = FragmentDetalleCorreoBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {//TODO MEJORAR
        super.onActivityCreated(savedInstanceState)
//        tvDetalle.text = viewModel.correoSelected.value?.texto
        viewModel.correoSelected.observe(this, this::onCorreoChanged)
    }

    private fun onCorreoChanged(correo: Correo) {
        binding.tvDetalleCorreo.text = correo.texto
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
            DetalleCorreoFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}