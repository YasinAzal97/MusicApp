package com.example.myapplication.db.repo

import androidx.lifecycle.LiveData
import com.example.myapplication.db.dao.LiederDao
import com.example.myapplication.db.entity.Lied

class LiedRepository(private val liedDao: LiederDao) {

    val readAllData: LiveData<List<Lied>> = liedDao.readAllData()

    suspend fun addLied(lied: Lied) {
        liedDao.insertLied(lied)
    }
}