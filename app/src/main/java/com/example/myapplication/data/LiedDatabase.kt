package com.example.myapplication.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.dao.LiederDao

@Database(entities = [Lied::class], version = 1, exportSchema = false)
abstract class LiedDatabase: RoomDatabase() {
    abstract fun liedDao(): LiederDao

    companion object{

        @Volatile
        private var INSTANCE: LiedDatabase? = null
        fun getDatabase(context: Context): LiedDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LiedDatabase::class.java,
                    "testdb"
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                instance.openHelper.writableDatabase
                instance.liedDao().deleteAllUsers()
                return instance
            }
        }
    }
}