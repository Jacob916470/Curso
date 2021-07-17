package com.jacob.curso.presentation.home.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jacob.curso.data.database.CursoRoomDataBase

class HomeViewModelFactory(
    private val cursoRoomDataBase: CursoRoomDataBase
) : ViewModelProvider.NewInstanceFactory() {

    /** overriede = sobre escribir una función ya establecida */
    /** T = accede a la vista del HomeViewModelFactory, verifica si es nula o no.
     * De ser nula, crea la vista, si no es nula muestra la ya creada */
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModel(cursoRoomDataBase) as T
    }
}