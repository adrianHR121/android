package com.example.prctica02

import android.os.Parcel
import android.os.Parcelable

//aqui se guardan los datos registrados
data class TravelDetails(
    val destination: String,         // Nombre del destino de viaje
    val hotelName: String,           // Nombre del hotel
    val location: String,            // Ubicación del hotel
    val cost: Double,                // Costo del viaje
    val transportOptions: String,    // Opciones de transporte
    val companions: String           // Personas que acompañan en el viaje
) : Parcelable {                     // Implementación de la interfaz 'Parcelable'

    // Constructor secundario que recibe un 'Parcel' y extrae los valores en el mismo orden en el que se escribieron.
    // Si algun valor es null, se usa el operador '?:' para asignar un valor por defecto.
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",           // Leer el destino desde el Parcel
        parcel.readString() ?: "",           // Leer el nombre del hotel
        parcel.readString() ?: "",           // Leer la ubicación del hotel
        parcel.readDouble(),                 // Leer el costo del viaje (no puede ser null)
        parcel.readString() ?: "",           // Leer las opciones de transporte
        parcel.readString() ?: ""            // Leer los acompañantes
    )

    // Método que se llama para escribir los datos en el 'Parcel'. Los datos se escriben en el mismo orden
    // en que serán leídos en el constructor secundario.
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(destination)      // Escribir el destino en el Parcel
        parcel.writeString(hotelName)        // Escribir el nombre del hotel
        parcel.writeString(location)         // Escribir la ubicación del hotel
        parcel.writeDouble(cost)             // Escribir el costo del viaje
        parcel.writeString(transportOptions) // Escribir las opciones de transporte
        parcel.writeString(companions)       // Escribir los acompañantes
    }

    // Método que describe el contenido del Parcelable. Usualmente retorna 0 si no se usan File Descriptors.
    override fun describeContents(): Int {
        return 0
    }

    // Objeto estático 'CREATOR' que se usa para crear instancias de 'TravelDetails' a partir de un 'Parcel'.
    companion object CREATOR : Parcelable.Creator<TravelDetails> {
        // Crea una instancia de 'TravelDetails' desde el Parcel, llamando al constructor secundario.
        override fun createFromParcel(parcel: Parcel): TravelDetails {
            return TravelDetails(parcel)
        }

        // Crea un array de objetos 'TravelDetails', útil cuando se pasan múltiples objetos.
        override fun newArray(size: Int): Array<TravelDetails?> {
            return arrayOfNulls(size)
        }
    }
}
