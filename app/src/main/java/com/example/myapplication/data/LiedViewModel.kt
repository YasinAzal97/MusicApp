package com.example.myapplication.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData


class LiedViewModel(application: Application): AndroidViewModel(application) {

    // LiveData für die Liste aller Benutzer
    private val readAllData: LiveData<List<Lied>>
    // Repository zur Behandlung von Datenzugriffe
    private val repository: LiedRepository

    var db: UserDatabase = UserDatabase.getDatabase(application);
    init {
        // Zugriff auf die UserDao-Datenbank
        val liedDao = db.liedDao()
        // Initialisierung des UserRepository mit dem UserDao
        repository = LiedRepository(liedDao)
        // Abrufen der LiveData-Liste aller Benutzer über das Repository
        readAllData = repository.readAllData
    }
}
