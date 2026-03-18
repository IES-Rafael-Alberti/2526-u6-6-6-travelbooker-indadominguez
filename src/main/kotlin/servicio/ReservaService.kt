package org.practicatrim2.servicio

import org.practicatrim2.dominio.ReservaHotel
import org.practicatrim2.dominio.ReservaVuelo
import org.practicatrim2.datos.IReservaRepository


class ReservaService(private val repositorio: IReservaRepository) : IReservaService {

    override fun crearReservaVuelo(descripcion: String, origen: String, destino: String, horaVuelo: String) {
        val reservaVuelo = ReservaVuelo.creaInstancia(descripcion, origen, destino, horaVuelo)
        repositorio.agregar(reservaVuelo)
    }

    override fun crearReservaHotel(descripcion: String, ubicacion: String, numeroNoches: Int) {
        val reservaHotel = ReservaHotel.creaInstancia(descripcion, ubicacion, numeroNoches)
        repositorio.agregar(reservaHotel)
    }

    override fun listarReservas() = repositorio.obtenerTodas()
}