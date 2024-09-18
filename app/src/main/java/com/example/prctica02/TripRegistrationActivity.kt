package com.example.prctica02

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TripRegistrationActivity : AppCompatActivity() {

    private lateinit var editTextHotelName: EditText
    private lateinit var editTextLocation: EditText
    private lateinit var editTextCost: EditText
    private lateinit var switchCar: Switch
    private lateinit var switchBus: Switch
    private lateinit var switchPlane: Switch
    private lateinit var editTextCompanions: EditText

    // Datos del viaje
    private var travelDetails: TravelDetails? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trip_registration)

        // Recibir el destino seleccionado de la actividad anterior
        val selectedDestination = intent.getStringExtra("selectedDestination")

        // Inicializar vistas
        editTextHotelName = findViewById(R.id.editTextHotelName)
        editTextLocation = findViewById(R.id.editTextLocation)
        editTextCost = findViewById(R.id.editTextCost)
        switchCar = findViewById(R.id.switchCar)
        switchBus = findViewById(R.id.switchBus)
        switchPlane = findViewById(R.id.switchPlane)
        editTextCompanions = findViewById(R.id.editTextCompanions)

        // Botón Guardar
        findViewById<Button>(R.id.buttonSave).setOnClickListener {
            saveTripDetails(selectedDestination ?: "")
        }

        // Botón Consultar
        findViewById<Button>(R.id.buttonShow).setOnClickListener {
            showTripDetails()
        }
    }

    private fun saveTripDetails(destination: String) {
        val hotelName = editTextHotelName.text.toString()
        val location = editTextLocation.text.toString()
        val cost = editTextCost.text.toString().toDoubleOrNull() ?: 0.0
        val companions = editTextCompanions.text.toString()

        val transportOptions = mutableListOf<String>()
        if (switchCar.isChecked) transportOptions.add("Coche")
        if (switchBus.isChecked) transportOptions.add("Autobús")
        if (switchPlane.isChecked) transportOptions.add("Avión")

        travelDetails = TravelDetails(destination, hotelName, location, cost, transportOptions.joinToString(", "), companions)

        Toast.makeText(this, "Datos del viaje guardados", Toast.LENGTH_SHORT).show()
    }

    private fun showTripDetails() {
        travelDetails?.let {
            val intent = Intent(this, TripDetailsActivity::class.java).apply {
                putExtra("travelDetails", it)
            }
            startActivity(intent)
        } ?: run {
            Toast.makeText(this, "No hay datos guardados", Toast.LENGTH_SHORT).show()
        }
    }
}
