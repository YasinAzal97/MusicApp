package com.example.myapplication.data

import androidx.lifecycle.LiveData
import com.example.myapplication.dao.LiederDao

class LiedRepository(private val liedDao: LiederDao) {

    val readAllData: LiveData<List<Lied>> = liedDao.readAllData()

    suspend fun addLied(lied: Lied) {
        liedDao.insertLied(lied)
    }

    /*suspend fun searchUser(username: String, password: String) {
        liedDao.getUserByUsernameAndPassword(username,password)
    }*/
}