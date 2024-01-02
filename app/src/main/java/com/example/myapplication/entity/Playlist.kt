package com.example.myapplication.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "Playlist",)
data class Playlist(
    @Relation(
        parentColumn = "benutzerID",
        entityColumn = "playlistID"
    )
    @PrimaryKey @ColumnInfo(name = "playlistID") val playlistID: Int,
    @ColumnInfo(name = "benutzerID") val benutzerID: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "tags") val tags: String,
    @ColumnInfo(name = "playlistDauer") val playlistDauer: String
)