package com.jacob.curso.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.jacob.curso.data.entities.User

@Dao
interface UserDao {
    /** Sirve para hacer una SELECT(Consulta), INSERT(Insertar), UPDATE(Actualizar), DELETE(Eliminar) */
    @Query("SELECT * from user")

    /*** Nos sirve para traer la información de todos nuestros usuarios que proviene
     *  de nustra "data class User y lo igualamos a una lista" */
    suspend fun getUser() : List<User>?
}