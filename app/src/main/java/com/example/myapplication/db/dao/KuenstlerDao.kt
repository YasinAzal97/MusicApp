package com.example.myapplication.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.db.entity.Kuenstler


@Dao
interface KuenstlerDao {
    @Insert()
    fun insertKuenstler(kuenstler: Kuenstler)

    @Query("DELETE FROM Kuenstler")
    fun deleteAllUsers()

    @Query("SELECT * FROM Kuenstler ORDER BY kuenstlerID ASC")
    fun readAllData(): LiveData<List<Kuenstler>>
}