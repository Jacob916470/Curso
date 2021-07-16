package com.jacob.curso.presentation.home.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton
import com.jacob.curso.R
import com.jacob.curso.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var fragmentHomeBinding : FragmentHomeBinding? = null

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