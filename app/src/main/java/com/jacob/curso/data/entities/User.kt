package com.jacob.curso.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val mail: String,
    val password: String,
    val age: Int,
    @ColumnInfo(name = "auto_accept")
    val autoAccept: Boolean
)