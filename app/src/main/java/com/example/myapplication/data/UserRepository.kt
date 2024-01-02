package com.example.myapplication.data

import androidx.lifecycle.LiveData
import com.example.myapplication.entity.Benutzer

class UserRepository(private val userDao: UserDao) {

    val readAllData: LiveData<List<Benutzer>> = userDao.readAllData()

    suspend fun addUser(user: Benutzer) {
        userDao.insertBenutzer(user)
    }

    suspend fun searchUser(username: String, password: String) {
        userDao.getUserByUsernameAndPassword(username,password)
    }
}