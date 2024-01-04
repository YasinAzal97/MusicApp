package com.example.myapplication.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.dao.KuenstlerDao
import com.example.myapplication.dao.LiederDao
import com.example.myapplication.dao.UserDao

@Database(entities = [Benutzer::class, Lied::class, Kuenstler::class], version = 1, exportSchema = false)
abstract class UserDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun liedDao(): LiederDao
    abstract fun kuenstlerDao(): KuenstlerDao

    companion object{

        @Volatile
        private var INSTANCE: UserDatabase? = null
        fun getDatabase(context: Context): UserDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
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