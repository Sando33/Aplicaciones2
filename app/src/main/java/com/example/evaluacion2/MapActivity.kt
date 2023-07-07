package com.example.evaluacion2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var map: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.mapFragment) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        // Agregar marcadores
        addMarker(LatLng(-12.147647812104639, -76.98666679936792), "Bolichera", "Bolichera")
        addMarker(LatLng(-12.127527413643316, -77.00068826149533), "Cabitos", "Cabitos")
        addMarker(LatLng(-12.134542618119582, -76.9969199613361), "Ayacucho", "Ayacucho")

        // Establecer posición y nivel de zoom
        val initialPosition = LatLng(37.7749, -122.4194)
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(initialPosition, 10f))
    }

    private fun addMarker(position: LatLng, title: String, snippet: String) {
        map.addMarker(MarkerOptions().position(position).title(title).snippet(snippet))
    }
}