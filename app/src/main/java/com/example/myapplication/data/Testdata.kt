package com.example.myapplication.data

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class Testdata : AppCompatActivity(){
    private lateinit var mLiedViewModel: LiedViewModel
    private lateinit var mUserViewModel: UserViewModel
    private lateinit var mKuenstlerViewModel: KuenstlerViewModel
   fun createTestData(){
       mLiedViewModel = ViewModelProvider(this).get(LiedViewModel::class.java)
       mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
       mKuenstlerViewModel = ViewModelProvider(this).get(KuenstlerViewModel::class.java)


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