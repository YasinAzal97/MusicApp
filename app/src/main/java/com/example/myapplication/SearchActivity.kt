package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.data.Lied
import com.example.myapplication.data.LiedViewModel

class SearchActivity : AppCompatActivity() {
    private lateinit var mLiedViewModel: LiedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        mLiedViewModel = ViewModelProvider(this).get(LiedViewModel::class.java)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val lied1 = Lied(liedID = 1, albumID = 101, kuenstlerID = 201, titel = "Song1", jahr = 2020, genre = "Pop")
        val lied2 = Lied(liedID = 2, albumID = 102, kuenstlerID = 201, titel = "Song2", jahr = 2019, genre = "Rock")
        val lied3 = Lied(liedID = 3, albumID = 101, kuenstlerID = 202, titel = "Song3", jahr = 2021, genre = "Jazz")
        val lied4 = Lied(liedID = 4, albumID = 103, kuenstlerID = 203, titel = "Song4", jahr = 2018, genre = "Electronic")
        val lied5 = Lied(liedID = 5, albumID = 104, kuenstlerID = 204, titel = "Song5", jahr = 2022, genre = "R&B")
        val lied6 = Lied(liedID = 6, albumID = 102, kuenstlerID = 204, titel = "Song6", jahr = 2017, genre = "Hip Hop")
        val lied7 = Lied(liedID = 7, albumID = 105, kuenstlerID = 205, titel = "Song7", jahr = 2016, genre = "Classical")
        val lied8 = Lied(liedID = 8, albumID = 103, kuenstlerID = 206, titel = "Song8", jahr = 2023, genre = "Funk")
        val lied9 = Lied(liedID = 9, albumID = 104, kuenstlerID = 207, titel = "Song9", jahr = 2015, genre = "Reggae")
        val lied10 = Lied(liedID = 10, albumID = 105, kuenstlerID = 207, titel = "Song10", jahr = 2024, genre = "Blues")

        mLiedViewModel.db.liedDao().insertLied(lied1)
        mLiedViewModel.db.liedDao().insertLied(lied2)
        mLiedViewModel.db.liedDao().insertLied(lied3)
        mLiedViewModel.db.liedDao().insertLied(lied4)
        mLiedViewModel.db.liedDao().insertLied(lied5)
        mLiedViewModel.db.liedDao().insertLied(lied6)
        mLiedViewModel.db.liedDao().insertLied(lied7)
        mLiedViewModel.db.liedDao().insertLied(lied8)
        mLiedViewModel.db.liedDao().insertLied(lied9)
        mLiedViewModel.db.liedDao().insertLied(lied10)


    }
}