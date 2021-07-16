package com.jacob.curso.presentation.catalog.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jacob.curso.R
import com.jacob.curso.databinding.FragmentCatalogBinding
import com.jacob.curso.presentation.catalog.adapters.ColorAdapter
import com.jacob.curso.presentation.catalog.viewModel.CatalogViewModel

class CatalogFragment : Fragment() {

    private var fragmentCatalogBinding: FragmentCatalogBinding? = null
    var welcome = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            welcome = it.getString("welcome").orEmpty()
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragmentCatalogBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_catalog,
            container,
            false
        )
        fragmentCatalogBinding?.catalogViewModel =
            ViewModelProvider(this).get(CatalogViewModel::class.java)

        return fragmentCatalogBinding?.root
    }

    /** Vista creada */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /** Accedemos por medio de un observador a la lista */
        fragmentCatalogBinding?.catalogViewModel?.colorList?.observe(
            viewLifecycleOwner, { colors ->
                /** Validamos que la lista no este vacia */
                if (colors.isNotEmpty()) {
                    /** Pasamos a nuestro recyclerView los componentes para su creación */
                    fragmentCatalogBinding?.rvColors?.apply {
                        layoutManager = LinearLayoutManager(context)
                        adapter = ColorAdapter(colors)
                    }
                }
            }
        )
    }
}