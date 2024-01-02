package com.example.myapplication.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.data.Benutzer

@Dao
interface UserDao {

    @Insert()
    fun insertBenutzer(benutzer: Benutzer)

    @Query("SELECT * FROM Benutzer WHERE username = :username AND password = :password")
    fun getUserByUsernameAndPassword(username: String, password: String): Benutzer?

    @Query("SELECT * FROM Benutzer ORDER BY BenutzerID ASC")
    fun readAllData(): LiveData<List<Benutzer>>

    @Query("DELETE FROM Benutzer")
    fun deleteAllUsers()

}