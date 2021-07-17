package com.jacob.curso.presentation.home.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jacob.curso.data.database.CursoRoomDataBase

class HomeViewModelFactory(
    private val cursoRoomDataBase: CursoRoomDataBase
): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModel(cursoRoomDataBase) as T
    }

}