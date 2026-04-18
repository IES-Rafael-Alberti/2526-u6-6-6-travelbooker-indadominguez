package org.practicatrim2.servicio

import org.practicatrim2.dominio.Reserva
import org.practicatrim2.dominio.ReservaHotel
import org.practicatrim2.dominio.ReservaVuelo
import org.practicatrim2.datos.IReservaRepository

/**
 * Implementación de la interfaz [IReservaService].
 *
 * Esta clase contiene la lógica de negocio para la creación
 * y gestión de reservas. Utiliza un repositorio que implementa
 * [IReservaRepository] para almacenar y recuperar las reservas.
 *
 * @property repositorio componente encargado de la persistencia
 * de las reservas.
 */
class ReservaService(private val repositorio: IReservaRepository) : IReservaService {

    /**
     * Crea una nueva reserva de vuelo y la guarda en el repositorio.
     *
     * Internamente utiliza el método de fábrica
     * [ReservaVuelo.creaInstancia] para generar la reserva.
     *
     * @param descripcion descripción o itinerario del vuelo.
     * @param origen lugar de salida.
     * @param destino lugar de llegada.
     * @param horaVuelo hora del vuelo en formato HH:mm.
     */
    override fun crearReservaVuelo(descripcion: String, origen: String, destino: String, horaVuelo: String) {
        val reservaVuelo = ReservaVuelo.creaInstancia(descripcion, origen, destino, horaVuelo)
        repositorio.crear(reservaVuelo)
    }

    /**
     * Crea una nueva reserva de hotel y la guarda en el repositorio.
     *
     * Utiliza el método de fábrica [ReservaHotel.creaInstancia]
     * para generar la instancia de la reserva.
     *
     * @param descripcion descripción de la reserva.
     * @param ubicacion ubicación del hotel.
     * @param numeroNoches número de noches reservadas.
     */
    override fun crearReservaHotel(descripcion: String, ubicacion: String, numeroNoches: Int) {
        val reservaHotel = ReservaHotel.creaInstancia(descripcion, ubicacion, numeroNoches)
        repositorio.crear(reservaHotel)
    }

    /**
     * Recupera todas las reservas almacenadas en el repositorio.
     *
     * @return lista de reservas registradas.
     */

    override fun listarReservas(): List<Reserva> {
        return repositorio.obtenerTodas()
    }

    override fun obtenerReserva(id: Int): Reserva? {
        return repositorio.leer(id)
    }

    override fun eliminarReserva(id: Int): Boolean {
        return repositorio.borrar(id)
    }
}