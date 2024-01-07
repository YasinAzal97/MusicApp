package com.example.myapplication.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.myapplication.db.entity.Lied

@Dao
interface LiederDao {
    @Insert()
    fun insertLied(lied: Lied)

    @Transaction
    @Query("DELETE FROM Lied")
    fun deleteAllSongs()

    @Query("SELECT * FROM Lied ORDER BY liedID ASC")
    fun readAllData(): LiveData<List<Lied>>

}