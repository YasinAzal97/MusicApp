package com.example.myapplication.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Künstler")
data class Kuenstler(
    @PrimaryKey @ColumnInfo(name = "kuenstlerID") val kuenstlerID: Int,
    @ColumnInfo(name = "Name") val name: String,
    @ColumnInfo(name = "eMail") val eMail: String,
    @ColumnInfo(name = "adresse") val adresse: String,
    @ColumnInfo(name = "style") val style: String
)