package com.example.myapplication.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication.dao.UserDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class UserViewModel(application: Application): AndroidViewModel(application) {

    // LiveData für die Liste aller Benutzer
    private val readAllData: LiveData<List<Benutzer>>
    // Repository zur Behandlung von Datenzugriffe
    private val repository: UserRepository

    public var db: UserDatabase = UserDatabase.getDatabase(application) ;
    init {
        // Zugriff auf die UserDao-Datenbank
        val userDao = db.userDao()
        // Initialisierung des UserRepository mit dem UserDao
        repository = UserRepository(userDao)
        // Abrufen der LiveData-Liste aller Benutzer über das Repository
        readAllData = repository.readAllData
    }

    // Funktion, um einen Benutzer hinzuzufügen
    fun addUser(user: Benutzer){
        // Startet eine Coroutine im Hintergrund für die Datenbankoperation
        viewModelScope.launch(Dispatchers.IO) {
            // Fügt den Benutzer über das Repository hinzu
            repository.addUser(user)
        }
    }

    // Funktion, um einen Benutzer hinzuzufügen
    fun searchUser(username: String, password: String){
        // Startet eine Coroutine im Hintergrund für die Datenbankoperation
        viewModelScope.launch(Dispatchers.IO) {
            // Fügt den Benutzer über das Repository hinzu
            repository.searchUser(username, password)
        }
    }

}
