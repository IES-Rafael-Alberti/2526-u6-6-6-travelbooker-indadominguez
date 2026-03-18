package org.practicatrim2.dominio

import java.time.LocalDateTime


abstract class Reserva(
    val id: Int,
    val descripcion: String,
    val fechaCreacion: LocalDateTime
) {

    open val detalle: String
        get() = "$id - $descripcion"

    open fun mostrarDetalle(): String = detalle
}