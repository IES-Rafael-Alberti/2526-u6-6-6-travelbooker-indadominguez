package org.practicatrim2.dominio


import java.time.LocalDateTime


class ReservaHotel private constructor(
    id: Int,
    descripcion: String,
    val ubicacion: String,
    val numeroNoches: Int
) : Reserva(id, descripcion, LocalDateTime.now()) {

    override val detalle: String
        get() = "$id - $ubicacion - $descripcion"

    override fun toString(): String {
        return "Reserva de Hotel: $detalle [Noches: $numeroNoches, Fecha creación: $fechaCreacion]"
    }

    companion object {
        private var contador: Int = 1

        fun creaInstancia(descripcion: String, ubicacion: String, numeroNoches: Int): ReservaHotel {
            require(numeroNoches > 0) { "El número de noches debe ser mayor a 0" }
            val reserva = ReservaHotel(contador, descripcion, ubicacion, numeroNoches)
            contador++
            return reserva
        }
    }
}