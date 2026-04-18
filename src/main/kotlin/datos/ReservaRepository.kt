package org.practicatrim2.datos

import org.practicatrim2.dominio.Reserva
import org.practicatrim2.dao.Dao

class ReservaRepository(private val dao: Dao<Reserva, Int>) : IReservaRepository {

    override fun crear(entidad: Reserva): Boolean = dao.crear(entidad)

    override fun leer(id: Int): Reserva? = dao.leer(id)

    override fun actualizar(entidad: Reserva): Boolean = dao.actualizar(entidad)

    override fun borrar(id: Int): Boolean = dao.borrar(id)

    override fun obtenerTodas(): List<Reserva> {
        return (1..1000).mapNotNull { dao.leer(it) }
    }
}