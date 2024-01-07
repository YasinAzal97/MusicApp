package com.example.myapplication.db.repo

import androidx.lifecycle.LiveData
import com.example.myapplication.db.dao.UserDao
import com.example.myapplication.db.entity.Benutzer

class UserRepository(private val userDao: UserDao) {

    val readAllData: LiveData<List<Benutzer>> = userDao.readAllData()

    suspend fun addUser(user: Benutzer) {
        userDao.insertBenutzer(user)
    }

    suspend fun searchUser(username: String, password: String) {
        userDao.getUserByUsernameAndPassword(username,password)
    }
}