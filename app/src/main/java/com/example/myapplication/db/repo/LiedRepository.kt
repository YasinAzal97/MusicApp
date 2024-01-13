package com.example.myapplication.db.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.db.dao.LiederDao
import com.example.myapplication.db.entity.LiedMitKuenstler

class LiedRepository(private val liedDao: LiederDao) {

    val readAllDataMitKuenstler: List<LiedMitKuenstler> =
        liedDao.readAllDataLiedMitKuenstler()
}