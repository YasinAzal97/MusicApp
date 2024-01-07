package com.example.myapplication.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "Album")
data class Album(
    @Relation(
        parentColumn = "kuenstlerID",
        entityColumn = "albumID"
    )
    @PrimaryKey @ColumnInfo(name = "albumID") val albumID: Int,
    @ColumnInfo(name = "kuenstlerID") val kuenstlerID: Int,
    @ColumnInfo(name = "Dauer") val dauer: String
)