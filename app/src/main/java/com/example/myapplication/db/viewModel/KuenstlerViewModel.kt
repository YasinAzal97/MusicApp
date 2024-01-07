package com.example.myapplication.db.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.myapplication.db.UserDatabase
import com.example.myapplication.db.entity.Kuenstler
import com.example.myapplication.db.repo.KuenstlerRepo

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