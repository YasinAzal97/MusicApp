package com.example.myapplication.db.repo

import androidx.lifecycle.LiveData
import com.example.myapplication.db.dao.KuenstlerDao
import com.example.myapplication.db.entity.Kuenstler

class KuenstlerRepo(private val kuenstlerDao: KuenstlerDao) {

    val readAllData: LiveData<List<Kuenstler>> = kuenstlerDao.readAllData()

    suspend fun addLied(kuenstler: Kuenstler) {
        kuenstlerDao.insertKuenstler(kuenstler)
    }

}