package com.example.prctica02

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DestinationSelectionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_destination_selection)

        // Configurar ImageButtons para cada destino
        val buttonMexico = findViewById<ImageButton>(R.id.buttonMexico)
        val buttonCanada = findViewById<ImageButton>(R.id.buttonCanada)
        val buttonParis = findViewById<ImageButton>(R.id.buttonParis)
        val buttonRome = findViewById<ImageButton>(R.id.buttonRome)
        val buttonJapan = findViewById<ImageButton>(R.id.buttonJapan)

        // Configurar el evento click para cada ImageButton
        buttonMexico.setOnClickListener {
            navigateToTripRegistration("Playas de México")
        }

        buttonCanada.setOnClickListener {
            navigateToTripRegistration("Montañas de Canadá")
        }

        buttonParis.setOnClickListener {
            navigateToTripRegistration("París")
        }

        buttonRome.setOnClickListener {
            navigateToTripRegistration("Roma")
        }

        buttonJapan.setOnClickListener {
            navigateToTripRegistration("Japón")
        }
    }

    private fun navigateToTripRegistration(destination: String) {
        Toast.makeText(this, "Seleccionado: $destination", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, TripRegistrationActivity::class.java).apply {
            putExtra("selectedDestination", destination)
        }
        startActivity(intent)
    }
}
