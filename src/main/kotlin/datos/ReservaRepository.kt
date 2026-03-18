package org.practicatrim2.datos

import org.practicatrim2.dominio.Reserva

/**
 * Implementación en memoria de la interfaz [IReservaRepository].
 *
 * Este repositorio almacena las reservas utilizando una lista mutable
 * durante la ejecución del programa.
 */
class ReservaRepository : IReservaRepository {

    /**
     * Lista interna donde se almacenan las reservas.
     */
    private val reservas = mutableListOf<Reserva>()

    /**
     * Añade una reserva al repositorio si no existe previamente.
     *
     * @param reserva reserva que se desea agregar.
     * @return `true` si la reserva fue añadida, `false` si ya existía.
     */
    override fun agregar(reserva: Reserva): Boolean {
        var agregado = false
        if (!reservas.contains(reserva)) {
            reservas.add(reserva)
            agregado = true
        }
        return agregado
    }

    /**
     * Devuelve todas las reservas almacenadas.
     *
     * @return lista inmutable con las reservas existentes.
     */
    override fun obtenerTodas(): List<Reserva> = reservas.toList()
}