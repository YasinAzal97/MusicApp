package com.example.myapplication.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "Lied")
data class Lied(
    @Relation(parentColumn = "kuenstlerID", entityColumn = "liedID")
    @PrimaryKey(autoGenerate = true) val liedID: Int?,
    @ColumnInfo(name = "albumID") val albumID: Int,
    @ColumnInfo(name = "titel") val titel: String,
    @ColumnInfo(name = "jahr") val jahr: Int,
    @ColumnInfo(name = "genre") val genre: String,
    @ColumnInfo(name = "kuenstlerID") val kuenstlerID: Int,
)
