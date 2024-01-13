package com.example.myapplication.db.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.myapplication.db.UserDatabase
import com.example.myapplication.db.entity.Benutzer
import com.example.myapplication.db.repo.UserRepository


class UserViewModel(application: Application): AndroidViewModel(application) {

    // LiveData für die Liste aller Benutzer
    // Repository zur Behandlung von Datenzugriffe
    private val readAllData: LiveData<List<Benutzer>>
    private val repository: UserRepository

    public var db: UserDatabase = UserDatabase.getDatabase(application);
    init {
        // Zugriff auf die UserDao-Datenbank
        // Initialisierung des UserRepository mit dem UserDao
        // Abrufen der LiveData-Liste aller Benutzer über das Repository
        val userDao = db.userDao()
        repository = UserRepository(userDao)
        readAllData = repository.readAllData
    }


}
