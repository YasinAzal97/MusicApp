package com.example.myapplication.adapter

import android.content.Context
import android.media.MediaPlayer
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.TextView
import com.example.myapplication.R
import com.example.myapplication.db.entity.LiedMitKuenstler

class LiedAdapter(private val context: Context, private val liederListe: List<LiedMitKuenstler>) :
    ArrayAdapter<LiedMitKuenstler>(context, 0, liederListe) {

    private lateinit var mediaPlayer: MediaPlayer;

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater = LayoutInflater.from(context)
        val view = convertView ?: layoutInflater.inflate(R.layout.list_item, parent, false)
        mediaPlayer = MediaPlayer();
        val liedMitKuenstler = liederListe[position]
        view.findViewById<TextView>(R.id.liedname).text = liedMitKuenstler.lied.titel
        view.findViewById<TextView>(R.id.kuenstlerName).text = liedMitKuenstler.kuenstler.name
        val image = view.findViewById<ImageButton>(R.id.imageButton)
        image.setOnClickListener {
            mediaPlayer.reset()
            if (image.tag != null && image.tag as Boolean) {
                image.setBackgroundResource(R.drawable.baseline_play_arrow_24)
                image.tag = false;
            } else {
                val songAsMp3 = liedMitKuenstler.lied.songAsMp3
                val decodedBytes: ByteArray = Base64.decode(songAsMp3, Base64.DEFAULT)
                val tempAudioFile = createTempFile("temp_audio", ".mp3")
                tempAudioFile.writeBytes(decodedBytes)

                try {
                    // Set data source to the temporary file
                    mediaPlayer.setDataSource(tempAudioFile.absolutePath)
                    mediaPlayer.prepare()

                    // Start playing
                    mediaPlayer.start()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                image.setBackgroundResource(R.drawable.baseline_pause_24)
                image.tag = true;
            }

        }
        return view
    }
}