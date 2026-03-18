package org.practicatrim2.datos

import org.practicatrim2.dominio.Reserva

class ReservaRepository : IReservaRepository {
    private val reservas = mutableListOf<Reserva>()

    override fun agregar(reserva: Reserva): Boolean {
        var agregado = false
        if (!reservas.contains(reserva)) {
            reservas.add(reserva)
            agregado = true
        }
        return agregado
    }

    override fun obtenerTodas(): List<Reserva> = reservas.toList()
}