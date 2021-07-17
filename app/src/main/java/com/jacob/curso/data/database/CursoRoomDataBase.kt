package com.jacob.curso.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jacob.curso.data.dao.UserDao
import com.jacob.curso.data.entities.User

/** Mandamos a llamar nuestra base de datos creada y le añadimos su versión */
@Database(
    /** entities = tables */
    entities = [
        User::class
    ],
    version = 1

)

/** Nos permite elegir que metodos aplicaremos cuando heredamos*/
abstract class CursoRoomDataBase: RoomDatabase() {

    abstract fun userDao(): UserDao

    /** Todo lo que cramos en "companion object", podra ser llamado y utilizado en donde lo solicitemos */
    companion object{

        /** Creamos una variable privada "INSTANCE", para verificar si hay datos o no (null o no null)*/
        @Volatile
        private var INSTANCE: CursoRoomDataBase? = null

        /** Creamos la función para verificar si hay alguna base de datos creada */
        fun getDataBase(context: Context): CursoRoomDataBase{

            /** Verificamos si ya hay alguna base de datos creada, si no hay ninguna base de datos, se lleva a cabo el proceso de crearla */
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context,
                    CursoRoomDataBase::class.java,
                    "curso_db"
                ).build()

                /** Si  ya hay una base de datos crada, la igualamos la nula (INSTANCE = instance) a la ya creada, para que no cree otra  */
                INSTANCE = instance

                /** instance = sincronizamos la base */
                instance
            }

        }

    }

}