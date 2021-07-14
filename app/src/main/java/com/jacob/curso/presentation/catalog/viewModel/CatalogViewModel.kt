package com.jacob.curso.presentation.catalog.viewModel

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jacob.curso.R
import com.jacob.curso.presentation.catalog.model.Color

class CatalogViewModel : ViewModel() {
    val colorList = MutableLiveData<List<Color>>()
    var name = ObservableField("")

    init {
        getColorsWS()
        name.set("Jacob")
    }

    private fun getColorsWS() {
        val colors = listOf(
            Color("red", R.color.red),
            Color("blue", R.color.blue),
            Color("pink", R.color.pink)
        )
        colorList.postValue(colors)
    }
}