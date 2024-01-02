package com.example.myapplication.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.data.Lied

@Dao
interface LiederDao {
    @Insert()
    fun insertLied(lied: Lied)

    @Query("DELETE FROM Lied")
    fun deleteAllUsers()

    @Query("SELECT * FROM Lied ORDER BY liedID ASC")
    fun readAllData(): LiveData<List<Lied>>

}