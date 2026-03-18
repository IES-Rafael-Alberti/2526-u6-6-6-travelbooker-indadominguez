package org.practicatrim2.dominio


import java.time.LocalDateTime


class ReservaVuelo private constructor(
    id: Int,
    descripcion: String,
    val origen: String,
    val destino: String,
    val horaVuelo: String
) : Reserva(id, descripcion, LocalDateTime.now()) {

    override val detalle: String
        get() = "$id - $origen -> $destino - $descripcion"

    override fun toString(): String {
        return "Reserva de Vuelo: $detalle [Hora de vuelo: $horaVuelo, Fecha creación: $fechaCreacion]"
    }

    companion object {
        private var contador: Int = 1

        fun creaInstancia(descripcion: String, origen: String, destino: String, horaVuelo: String): ReservaVuelo {
            val regex = Regex("^([01]?\\d|2[0-3]):[0-5]\\d\$")
            require(regex.matches(horaVuelo)) { "El formato de la hora debe ser HH:mm" }
            val reserva = ReservaVuelo(contador, descripcion, origen, destino, horaVuelo)
            contador++
            return reserva
        }
    }
}