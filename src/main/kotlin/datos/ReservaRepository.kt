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
    override fun crear(entidad: Reserva): Boolean {
        if (reservas.any { it.id == entidad.id }) return false
        reservas.add(entidad)
        return true
    }

    /**
     * Devuelve todas las reservas almacenadas.
     *
     * @return lista inmutable con las reservas existentes.
     */
    override fun leer(id: Int): Reserva? {
        return reservas.find { it.id == id }
    }

    override fun actualizar(entidad: Reserva): Boolean {
        val indice = reservas.indexOfFirst { it.id == entidad.id }
        return if (indice != -1) {
            reservas[indice] = entidad
            true
        } else false
    }

    override fun borrar(id: Int): Boolean {
        return reservas.removeIf { it.id == id }
    }

    override fun obtenerTodas(): List<Reserva> = reservas.toList()
}