package es.iesnervion.gdebustamante.pmdmo_09_practica_correo_fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.*
import es.iesnervion.gdebustamante.pmdmo_09_practica_correo_fragments.Fragments.DetalleContactoFragment
import es.iesnervion.gdebustamante.pmdmo_09_practica_correo_fragments.ViewModels.MainActivityVM

class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityVM by viewModels()

    private var smallScreen: Boolean = false//TODO VER COMO MEJORAR ESTO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        smallScreen = (findViewById<FragmentContainerView>(R.id.frgCVMovil) != null)

        viewModel.visualizacion.observe(this, this::onVisualizacionChanged)
    }

    private fun onVisualizacionChanged(visualizacion : String) {
        if (smallScreen) {
            supportFragmentManager.beginTransaction().apply{
                replace(R.id.frgCVMovil, DetalleContactoFragment.newInstance())
                setReorderingAllowed(true)
                addToBackStack(null)
                commit()
            }
        }else{
//            val fragment = supportFragmentManager.findFragmentById(R.id.frgCVMovil) as DetalleCorreoFragment
        }
    }
}

