package com.example.myapplication.data

import androidx.lifecycle.LiveData
import com.example.myapplication.dao.KuenstlerDao

class KuenstlerRepo(private val kuenstlerDao: KuenstlerDao) {

    val readAllData: LiveData<List<Kuenstler>> = kuenstlerDao.readAllData()

    suspend fun addLied(kuenstler: Kuenstler) {
        kuenstlerDao.insertKuenstler(kuenstler)
    }

}