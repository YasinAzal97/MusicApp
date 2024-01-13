package com.example.myapplication.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.db.dao.KuenstlerDao
import com.example.myapplication.db.dao.LiederDao
import com.example.myapplication.db.dao.UserDao
import com.example.myapplication.db.entity.Benutzer
import com.example.myapplication.db.entity.Kuenstler
import com.example.myapplication.db.entity.Lied

@Database(
    entities = [Benutzer::class, Lied::class, Kuenstler::class],
    version = 2,
    exportSchema = false
)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun liedDao(): LiederDao
    abstract fun kuenstlerDao(): KuenstlerDao

    companion object {

        @Volatile
        private var INSTANCE: UserDatabase? = null
        fun getDatabase(context: Context): UserDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "testdb"
                )
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
                INSTANCE = instance
                instance.openHelper.writableDatabase

                return instance
            }
        }
    }
}