package com.jacob.curso.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jacob.curso.data.dao.UserDao
import com.jacob.curso.data.entities.User


@Database(
    entities = [
        User::class
    ],
    version = 1
)
abstract class CursoRoomDataBase: RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {

        @Volatile
        private var INSTANCE : CursoRoomDataBase? = null

        fun getDataBase(context: Context): CursoRoomDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    CursoRoomDataBase::class.java,
                    "curso_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }

    }

}