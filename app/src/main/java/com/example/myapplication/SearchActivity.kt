package com.example.myapplication

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.data.Kuenstler
import com.example.myapplication.data.KuenstlerAdapter
import com.example.myapplication.data.KuenstlerViewModel
import com.example.myapplication.data.Lied
import com.example.myapplication.data.LiedAdapter
import com.example.myapplication.data.LiedViewModel

class SearchActivity : AppCompatActivity() {
    private lateinit var mLiedViewModel: LiedViewModel
    private lateinit var mKuenstlerViewModel: KuenstlerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        mLiedViewModel = ViewModelProvider(this).get(LiedViewModel::class.java)
        mKuenstlerViewModel = ViewModelProvider(this).get(KuenstlerViewModel::class.java)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        test()


        val inflatedView = getLayoutInflater().inflate(R.layout.list_item, null);
        val imageButton: ImageButton = inflatedView.findViewById(R.id.imageButton)

        imageButton.setOnClickListener {
                imageButton.setBackgroundResource(R.drawable.baseline_pause_24)
        }


        val listView = findViewById<ListView>(R.id.listview)
        val listViewKuenstler = findViewById<ListView>(R.id.listview)


        // LiveData beobachten
        mLiedViewModel.readAllData.observe(this, Observer { lieder ->
            val adapter = LiedAdapter(this, lieder)
            listView.adapter = adapter
        })

        mKuenstlerViewModel.readAllData.observe(this, Observer { kuenstler ->
            val adapter = KuenstlerAdapter(this, kuenstler)
            listViewKuenstler.adapter = adapter
        })
    }





    private fun test(){
        mLiedViewModel.db.liedDao().deleteAllSongs()
        mKuenstlerViewModel.db.kuenstlerDao().deleteAllUsers()

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


        val kuenstler1 = Kuenstler(1, "Max Mustermann", "max@example.com", "Berlin", "Abstract")
        val kuenstler2 = Kuenstler(2, "Maria Musterfrau", "maria@example.com", "Hamburg", "Impressionismus")
        val kuenstler3 = Kuenstler(3, "Fritz Fantasie", "fritz@example.com", "München", "Realismus")
        val kuenstler4 = Kuenstler(4, "Anna Kunst", "anna@example.com", "Köln", "Expressionismus")
        val kuenstler5 = Kuenstler(5, "Tom Test", "tom@example.com", "Frankfurt", "Moderne")
        val kuenstler6 = Kuenstler(6, "Eva Exemplar", "eva@example.com", "Stuttgart", "Kubismus")
        val kuenstler7 = Kuenstler(7, "Paul Proben", "paul@example.com", "Dresden", "Fauvismus")
        val kuenstler8 = Kuenstler(8, "Klara Kreativ", "klara@example.com", "Leipzig", "Surrealismus")
        val kuenstler9 = Kuenstler(9, "Robert Künstler", "robert@example.com", "Düsseldorf", "Pop-Art")
        val kuenstler10 = Kuenstler(10, "Sophie Stilvoll", "sophie@example.com", "Bremen", "Post-Impressionismus")

        mKuenstlerViewModel.db.kuenstlerDao().insertKuenstler(kuenstler1)
        mKuenstlerViewModel.db.kuenstlerDao().insertKuenstler(kuenstler2)
        mKuenstlerViewModel.db.kuenstlerDao().insertKuenstler(kuenstler3)
        mKuenstlerViewModel.db.kuenstlerDao().insertKuenstler(kuenstler4)
        mKuenstlerViewModel.db.kuenstlerDao().insertKuenstler(kuenstler5)
        mKuenstlerViewModel.db.kuenstlerDao().insertKuenstler(kuenstler6)
        mKuenstlerViewModel.db.kuenstlerDao().insertKuenstler(kuenstler7)
        mKuenstlerViewModel.db.kuenstlerDao().insertKuenstler(kuenstler8)
        mKuenstlerViewModel.db.kuenstlerDao().insertKuenstler(kuenstler9)
        mKuenstlerViewModel.db.kuenstlerDao().insertKuenstler(kuenstler10)
    }
}