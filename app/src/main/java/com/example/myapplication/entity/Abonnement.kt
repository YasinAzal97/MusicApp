package com.example.myapplication.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "Abonnements")
data class Abonnement(
    @Relation(
        parentColumn = "benutzerID",
        entityColumn = "aboID"
    )
    @PrimaryKey @ColumnInfo(name = "aboID") val aboID: Int,
    @ColumnInfo(name = "benutzerID") val benutzerID: Int,
    @ColumnInfo(name = "ablaufsdatum") val ablaufsdatum: String,
    @ColumnInfo(name = "aboTyp") val aboTyp: String,
    @ColumnInfo(name = "kuenstlerID") val kuenstlerID: Int
)