package com.example.myapplication.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.myapplication.db.entity.Lied
import com.example.myapplication.db.entity.LiedMitKuenstler

@Dao
interface LiederDao {
    @Insert()
    fun insertLied(lied: Lied)

    @Transaction
    @Query("DELETE FROM Lied")
    fun deleteAllSongs()

    @Query("SELECT * FROM Lied ORDER BY liedID ASC")
    fun readAllData(): List<Lied>

    @Query("SELECT * FROM Lied ORDER BY liedID ASC")
    fun readAllDataLiedMitKuenstler(): List<LiedMitKuenstler>

    @Query(
        """
        SELECT * FROM Lied 
        join Kuenstler on Lied.kuenstlerID = Kuenstler.kuenstlerID 
        where Lied.titel LIKE  :suche OR Kuenstler.name LIKE  :suche
    """
    )
    fun sucheLiedMitKuenstler(suche: String): List<LiedMitKuenstler>

}