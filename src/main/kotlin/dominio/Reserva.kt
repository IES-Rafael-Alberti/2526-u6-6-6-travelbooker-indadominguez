package org.practicatrim2.dominio

import java.time.LocalDateTime

/**
 * Clase abstracta que representa una reserva genérica.
 *
 * Sirve como clase base para los distintos tipos de reservas
 * del sistema (por ejemplo, reservas de hotel o de vuelo).
 *
 * @property id identificador único de la reserva.
 * @property descripcion descripción general de la reserva.
 * @property fechaCreacion fecha y hora en la que se creó la reserva.
 */
abstract class Reserva(
    val id: Int,
    val descripcion: String,
    val fechaCreacion: LocalDateTime
) {

    /**
     * Información básica de la reserva.
     *
     * Puede ser sobrescrita por las clases hijas para añadir
     * más información específica.
     */
    open val detalle: String
        get() = "$id - $descripcion"

    /**
     * Devuelve el detalle de la reserva en formato texto.
     *
     * @return cadena con el detalle de la reserva.
     */
    open fun mostrarDetalle(): String = detalle
}