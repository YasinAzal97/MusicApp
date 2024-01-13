package com.example.myapplication.db.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.db.UserDatabase
import com.example.myapplication.db.entity.LiedMitKuenstler
import com.example.myapplication.db.repo.LiedRepository


class LiedViewModel(application: Application) : AndroidViewModel(application) {

    // LiveData für die Liste aller Benutzer
    var data: MutableLiveData<List<LiedMitKuenstler>> = MutableLiveData();

    // Repository zur Behandlung von Datenzugriffe
    private val repository: LiedRepository

    var db: UserDatabase = UserDatabase.getDatabase(application);

    init {
        // Zugriff auf die UserDao-Datenbank
        val liedDao = db.liedDao()
        // Initialisierung des UserRepository mit dem UserDao
        repository = LiedRepository(liedDao)
        // Abrufen der LiveData-Liste aller Benutzer über das Repository
        data.value = repository.readAllDataMitKuenstler
    }

    fun search(search: String?) {
        if (search != null) {
            var searchForLike = "%$search%";
            data.value = db.liedDao().sucheLiedMitKuenstler(searchForLike);
        } else {
            data.value = db.liedDao().readAllDataLiedMitKuenstler();
        }
    }
}
