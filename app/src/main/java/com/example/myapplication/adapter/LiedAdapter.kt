package com.example.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.myapplication.R
import com.example.myapplication.db.entity.Lied

class LiedAdapter(private val context: Context, private val liederListe: List<Lied>) : ArrayAdapter<Lied>(context, 0, liederListe) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater = LayoutInflater.from(context)
        val view = convertView ?: layoutInflater.inflate(R.layout.list_item, parent, false)

        val lied = liederListe[position]
        val liednameTextView = view.findViewById<TextView>(R.id.liedname)
        liednameTextView.text = lied.titel


        return view
    }
}