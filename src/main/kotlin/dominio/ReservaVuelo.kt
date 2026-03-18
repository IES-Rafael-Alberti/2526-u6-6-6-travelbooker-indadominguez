package org.practicatrim2.dominio

import java.time.LocalDateTime

/**
 * Representa una reserva de vuelo.
 *
 * Incluye información sobre el origen, destino y la hora del vuelo.
 * El constructor es privado para asegurar que las instancias se
 * creen mediante el método de fábrica [creaInstancia].
 *
 * @property origen aeropuerto o ciudad de salida.
 * @property destino aeropuerto o ciudad de llegada.
 * @property horaVuelo hora programada del vuelo en formato HH:mm.
 */
class ReservaVuelo private constructor(
    id: Int,
    descripcion: String,
    val origen: String,
    val destino: String,
    val horaVuelo: String
) : Reserva(id, descripcion, LocalDateTime.now()) {

    /**
     * Detalle extendido de la reserva de vuelo.
     */
    override val detalle: String
        get() = "$id - $origen -> $destino - $descripcion"

    /**
     * Representación textual de la reserva de vuelo.
     *
     * @return cadena con la información del vuelo.
     */
    override fun toString(): String {
        return "Reserva de Vuelo: $detalle [Hora de vuelo: $horaVuelo, Fecha creación: $fechaCreacion]"
    }

    companion object {

        /**
         * Contador utilizado para generar identificadores únicos
         * para cada reserva de vuelo.
         */
        private var contador: Int = 1

        /**
         * Método de fábrica que crea una nueva instancia de [ReservaVuelo].
         *
         * La hora debe seguir el formato **HH:mm**.
         *
         * @param descripcion descripción de la reserva.
         * @param origen lugar de salida.
         * @param destino lugar de llegada.
         * @param horaVuelo hora del vuelo en formato HH:mm.
         *
         * @throws IllegalArgumentException si la hora no cumple el formato HH:mm.
         *
         * @return nueva instancia de [ReservaVuelo].
         */
        fun creaInstancia(descripcion: String, origen: String, destino: String, horaVuelo: String): ReservaVuelo {
            val regex = Regex("^([01]?\\d|2[0-3]):[0-5]\\d\$")
            require(regex.matches(horaVuelo)) { "El formato de la hora debe ser HH:mm" }

            val reserva = ReservaVuelo(contador, descripcion, origen, destino, horaVuelo)
            contador++
            return reserva
        }
    }
}