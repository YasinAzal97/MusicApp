package com.example.myapplication.data

import androidx.room.Embedded
import androidx.room.Relation

data class LiedMitKuenstler(
    @Embedded val lied: Lied,
    @Relation(
        parentColumn = "kuenstlerID",
        entityColumn = "liedID"
    )
    val kuenstler: Kuenstler
)