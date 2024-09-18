package com.example.prctica02

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class TripDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trip_details)

        val travelDetails = intent.getParcelableExtra<TravelDetails>("travelDetails")

        val imageViewDestination = findViewById<ImageView>(R.id.imageViewDestination)
        val textViewDetails = findViewById<TextView>(R.id.textViewDetails)

        travelDetails?.let {
            // Establecer la imagen del destino
            val imageResId = when (it.destination) {
                "Playas de México" -> R.drawable.playas_mexico
                "Montañas de Canadá" -> R.drawable.montanas_canada
                "París" -> R.drawable.paris
                "Roma" -> R.drawable.roma
                "Japón" -> R.drawable.japon
                else -> R.drawable.logo
            }
            imageViewDestination.setImageDrawable(ContextCompat.getDrawable(this, imageResId as Int))

            // Establecer los detalles del viaje
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
