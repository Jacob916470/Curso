package com.jacob.curso.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.jacob.curso.data.entities.User

@Dao
interface UserDao {


    @Query("SELECT * from user")
    suspend fun getUser(): List<User>?

}