package com.jacob.curso.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/** Creamamos nuestra tabla */
@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val mail: String,
    val password: String,
    val age: Int,
    /** Sirve para generar un nombre externo al codigo y mostrarlo diferente la escritura en la base de datos */
    @ColumnInfo( name = "auto_accept")
    val autoAccept : Boolean
    /** Boolean = true / false */
)
