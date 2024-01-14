package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CircleOptions
import com.google.android.gms.maps.model.LatLng

internal class MapsActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMapClickListener {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Setze den Click-Listener für die Karte
        mMap.setOnMapClickListener(this)
    }

    override fun onMapClick(latLng: LatLng) {
        // Entferne vorherige Kreise (optional)
        mMap.clear()

        // Füge einen Kreis mit einem Radius von 100 km an der angeklickten Position hinzu
        val circleOptions = CircleOptions()
            .center(latLng)
            .radius(200000.0) // Radius in Metern (100 km = 100,000 Meter)
            .strokeColor(Color.YELLOW) // Farbe des Kreisrands
            .fillColor(Color.argb(70, 0, 0, 255)) // Füllfarbe des Kreises mit Transparenz
        mMap.addCircle(circleOptions)

        // Optional: Bewege die Kamera zur Klick-Position
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng))
    }
}


      