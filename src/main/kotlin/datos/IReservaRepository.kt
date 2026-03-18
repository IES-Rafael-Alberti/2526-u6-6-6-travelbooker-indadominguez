package org.practicatrim2.datos

import org.practicatrim2.dominio.Reserva

interface IReservaRepository {
    fun agregar(reserva: Reserva): Boolean
    fun obtenerTodas(): List<Reserva>
}