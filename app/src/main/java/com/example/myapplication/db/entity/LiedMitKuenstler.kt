package com.example.myapplication.db.entity

import androidx.room.Embedded
import androidx.room.Relation

data class LiedMitKuenstler(
    @Embedded val lied: Lied,
    @Relation(
        parentColumn = "liedID",
        entityColumn = "kuenstlerID"
    )
    val kuenstler: Kuenstler
)