package com.example.myapplication.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.dao.UserDao

// Definiert die Datenbank mit der Entität "Benutzer", Version 1 und deaktivierter Schema-Exportierung
@Database(entities = [Benutzer::class], version = 1, exportSchema = false)
abstract class UserDatabase: RoomDatabase() {

    // Abstrakte Methode, um auf die DAO für Benutzer zuzugreifen
    abstract fun userDao(): UserDao

    // Begleitobjekt, um auf die Datenbank zuzugreifen und die Instanz zu verwalten
    companion object{

        // Volatile Variable zur Speicherung der Datenbankinstanz für Thread-Sicherheit
        @Volatile
        private var INSTANCE: UserDatabase? = null

        // Funktion zum Abrufen der Datenbankinstanz
        fun getDatabase(context: Context): UserDatabase{
            // Holt sich die aktuelle Instanz (falls vorhanden)
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance // Gibt die vorhandene Instanz zurück
            }
            // Synchronisierter Block, um Thread-Sicherheit beim Instanzenzugriff sicherzustellen
            synchronized(this){
                // Erstellt eine neue Instanz der Datenbank mithilfe des Room-Builders
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "testdb"
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                instance.openHelper.writableDatabase// Weist die neu erstellte Instanz der Variablen zu
                return instance // Gibt die neue Instanz zurück
            }
        }
    }
}