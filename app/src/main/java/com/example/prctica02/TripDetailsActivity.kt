package com.example.prctica02

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TripDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trip_details)

        val travelDetails = intent.getParcelableExtra<TravelDetails>("travelDetails")

        val textViewDetails = findViewById<TextView>(R.id.textViewDetails)
        travelDetails?.let {
            val details = """
                Destino: ${it.destination}
                Hotel: ${it.hotelName}
                Ubicación: ${it.location}
                Costo: ${it.cost}
                Transporte: ${it.transportOptions}
                Acompañantes: ${it.companions}
            """.trimIndent()

            textViewDetails.text = details
        }
    }
}
