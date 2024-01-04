package com.example.myapplication.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class KuenstlerViewModel (application: Application): AndroidViewModel(application) {
    // LiveData für die Liste aller Benutzer
    val readAllData: LiveData<List<Kuenstler>>
    // Repository zur Behandlung von Datenzugriffe
    private val repository: KuenstlerRepo

    var db: UserDatabase = UserDatabase.getDatabase(application);
    init {
        // Zugriff auf die UserDao-Datenbank
        val kuenstlerDao = db.kuenstlerDao()
        // Initialisierung des UserRepository mit dem UserDao
        repository =  KuenstlerRepo(kuenstlerDao)
        // Abrufen der LiveData-Liste aller Benutzer über das Repository
        readAllData = repository.readAllData
    }
}