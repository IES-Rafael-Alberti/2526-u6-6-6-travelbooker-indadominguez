package org.practicatrim2.dominio

import java.time.LocalDateTime

/**
 * Representa una reserva de hotel.
 *
 * Esta clase hereda de [Reserva] e incluye información específica
 * sobre la ubicación del hotel y el número de noches reservadas.
 *
 * El constructor es privado para forzar la creación de instancias
 * mediante el método de fábrica [creaInstancia].
 *
 * @property ubicacion ciudad o ubicación del hotel.
 * @property numeroNoches número de noches de la estancia.
 */
class ReservaHotel private constructor(
    id: Int,
    descripcion: String,
    val ubicacion: String,
    val numeroNoches: Int
) : Reserva(id, descripcion, LocalDateTime.now()) {

    /**
     * Detalle extendido de la reserva de hotel.
     */
    override val detalle: String
        get() = "$id - $ubicacion - $descripcion"

    /**
     * Representación en texto de la reserva.
     *
     * @return cadena con toda la información relevante de la reserva.
     */
    override fun toString(): String {
        return "Reserva de Hotel: $detalle [Noches: $numeroNoches, Fecha creación: $fechaCreacion]"
    }

    companion object {

        /**
         * Contador utilizado para generar identificadores únicos
         * para cada reserva creada.
         */
        private var contador: Int = 1

        /**
         * Método de fábrica que crea una instancia de [ReservaHotel].
         *
         * @param descripcion descripción de la reserva.
         * @param ubicacion ubicación del hotel.
         * @param numeroNoches número de noches de la reserva.
         *
         * @throws IllegalArgumentException si el número de noches es menor o igual a 0.
         *
         * @return nueva instancia de [ReservaHotel].
         */
        fun creaInstancia(descripcion: String, ubicacion: String, numeroNoches: Int): ReservaHotel {
            require(numeroNoches > 0) { "El número de noches debe ser mayor a 0" }

            val reserva = ReservaHotel(contador, descripcion, ubicacion, numeroNoches)
            contador++
            return reserva
        }
    }
}