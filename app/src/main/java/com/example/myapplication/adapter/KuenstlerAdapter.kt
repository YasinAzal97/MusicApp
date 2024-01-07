package com.example.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.myapplication.R
import com.example.myapplication.db.entity.Kuenstler

class KuenstlerAdapter(private val context: Context, private val kuenstlerListe: List<Kuenstler>) : ArrayAdapter<Kuenstler>(context, 0, kuenstlerListe) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater = LayoutInflater.from(context)
        val view = convertView ?: layoutInflater.inflate(R.layout.list_item, parent, false)

        val kuenstler = kuenstlerListe[position]
        val kuenstlerNameTextView = view.findViewById<TextView>(R.id.kuenstlerName)

        kuenstlerNameTextView.text = kuenstler.name

        return view
    }
}