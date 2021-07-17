package com.jacob.curso.presentation.core.callBack

/** Listener para escuchar eventos con un tipo generico */
interface OnItemClickListener<T> {

    fun onItemClick(item: T, type: String? = null)

}