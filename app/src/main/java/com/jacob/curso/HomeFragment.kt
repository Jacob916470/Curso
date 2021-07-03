package com.jacob.curso

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton

class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val catalogButton = root.findViewById<MaterialButton>(R.id.catalogButton)
        catalogButton.setOnClickListener {
            val bundle = bundleOf("welcome" to "Bienvenido")
            findNavController().navigate(R.id.action_homeFragment_to_catalogFragment,bundle)
        }
        return root
    }

}