package org.practicatrim2.servicio

import org.practicatrim2.dominio.Reserva

interface IReservaService {
    fun crearReservaVuelo(descripcion: String, origen: String, destino: String, horaVuelo: String)
    fun crearReservaHotel(descripcion: String, ubicacion: String, numeroNoches: Int)
    fun listarReservas(): List<Reserva>
}
