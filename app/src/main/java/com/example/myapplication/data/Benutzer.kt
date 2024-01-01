package com.example.myapplication.data
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(tableName = "Benutzer")
data class Benutzer(
    @PrimaryKey(autoGenerate = true)  @ColumnInfo(name ="benutzerID") val benutzerID: Int?,
    @ColumnInfo(name ="username") val username: String,
    @ColumnInfo(name ="email") val email: String,
    @ColumnInfo(name ="password")val password: String,
)
