package org.practicatrim2.servicio

import org.practicatrim2.dominio.Reserva

/**
 * Interfaz que define las operaciones de negocio
 * relacionadas con la gestión de reservas.
 *
 * Actúa como capa intermedia entre la interfaz de usuario
 * y el repositorio de datos, encapsulando la lógica necesaria
 * para crear y consultar reservas.
 */
interface IReservaService {

    /**
     * Crea una nueva reserva de vuelo.
     *
     * @param descripcion descripción o itinerario del vuelo.
     * @param origen lugar de salida del vuelo.
     * @param destino lugar de destino del vuelo.
     * @param horaVuelo hora programada del vuelo en formato HH:mm.
     */
    fun crearReservaVuelo(descripcion: String, origen: String, destino: String, horaVuelo: String)

    /**
     * Crea una nueva reserva de hotel.
     *
     * @param descripcion descripción de la reserva.
     * @param ubicacion ubicación o ciudad del hotel.
     * @param numeroNoches número de noches de la estancia.
     */
    fun crearReservaHotel(descripcion: String, ubicacion: String, numeroNoches: Int)

    /**
     * Obtiene todas las reservas registradas en el sistema.
     *
     * @return lista de objetos [Reserva] almacenados.
     */
    fun listarReservas(): List<Reserva>
}