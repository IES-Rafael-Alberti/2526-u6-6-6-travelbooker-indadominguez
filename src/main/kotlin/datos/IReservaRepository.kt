package org.practicatrim2.datos

import org.practicatrim2.dominio.Reserva
import org.practicatrim2.dao.Dao

/**
 * Interfaz que define las operaciones básicas de persistencia
 * para la gestión de objetos [Reserva].
 *
 * Esta interfaz permite abstraer el mecanismo de almacenamiento
 * de las reservas, facilitando la implementación de diferentes
 * repositorios (memoria, base de datos, etc.).
 */
interface IReservaRepository : Dao<Reserva, Int> {
    fun obtenerTodas(): List<Reserva>

    /**
     * Agrega una nueva reserva al repositorio.
     *
     * @param reserva objeto [Reserva] que se desea almacenar.
     * @return `true` si la reserva se ha añadido correctamente,
     * `false` si la reserva ya existía en el repositorio.
     */
}