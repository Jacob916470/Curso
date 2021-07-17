package com.jacob.curso.presentation.home.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton
import com.jacob.curso.R
import com.jacob.curso.data.database.CursoRoomDataBase
import com.jacob.curso.databinding.FragmentHomeBinding
import com.jacob.curso.presentation.home.viewModel.HomeViewModel
import com.jacob.curso.presentation.home.viewModel.HomeViewModelFactory

class HomeFragment : Fragment() {

    private var fragmentHomeBinding: FragmentHomeBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentHomeBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_home,
            container,
            false
        )

        /** Mandamos a llamar a nuestra variable "fragmentHomeBinding?", despues entramos a nuestro homeViewModel(Vista xml) */
        fragmentHomeBinding?.homeViewModel =

            /** Nos brinda las vistas creadas */
            ViewModelProvider(
                this,

                /** Accedemos a nuestra base de datos */
                HomeViewModelFactory(
                    cursoRoomDataBase = CursoRoomDataBase.getDataBase(requireContext())
                )

            /** Atraemos la vista del la clase "HomeViewModel" */
            ).get(HomeViewModel::class.java)

        return fragmentHomeBinding?.root
    }
    /** Despues de validar, detecta que no hay nulos (Se pueden crear tanto onCreateView como en onViewCreated) */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentHomeBinding?.catalogButton?.setOnClickListener {
            val bundle = bundleOf("welcome" to "Bienvenido")
            findNavController().navigate(R.id.action_homeFragment_to_catalogFragment,bundle)
        }
    }

}