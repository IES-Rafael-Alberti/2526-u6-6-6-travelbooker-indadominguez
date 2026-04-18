package org.practicatrim2.dao

import org.practicatrim2.dominio.*
import java.io.File
import java.time.LocalDateTime

class ReservaFileDAO(private val filePath: String) : Dao<Reserva, Int> {

    private fun leerArchivo(): MutableList<Reserva> {
        val file = File(filePath)

        if (!file.exists()) return mutableListOf()

        return file.readLines().mapNotNull { linea ->
            val partes = linea.split("|")

            try {
                when (partes[1]) {
                    "HOTEL" -> {
                        val id = partes[0].toInt()
                        val descripcion = partes[2]
                        val ubicacion = partes[3]
                        val noches = partes[4].toInt()
                        val fecha = LocalDateTime.parse(partes[5])

                        ReservaHotel.desdeArchivo(id, descripcion, ubicacion, noches, fecha)
                    }

                    "VUELO" -> {
                        val id = partes[0].toInt()
                        val descripcion = partes[2]
                        val origen = partes[3]
                        val destino = partes[4]
                        val hora = partes[5]
                        val fecha = LocalDateTime.parse(partes[6])

                        ReservaVuelo.desdeArchivo(id, descripcion, origen, destino, hora, fecha)
                    }

                    else -> null
                }
            } catch (e: Exception) {
                null
            }
        }.toMutableList()
    }

    private fun escribirArchivo(reservas: List<Reserva>) {
        val file = File(filePath)

        val lineas = reservas.map { reserva ->
            when (reserva) {
                is ReservaHotel ->
                    "${reserva.id}|HOTEL|${reserva.descripcion}|${reserva.ubicacion}|${reserva.numeroNoches}|${reserva.fechaCreacion}"

                is ReservaVuelo ->
                    "${reserva.id}|VUELO|${reserva.descripcion}|${reserva.origen}|${reserva.destino}|${reserva.horaVuelo}|${reserva.fechaCreacion}"

                else -> ""
            }
        }

        file.writeText(lineas.joinToString("\n"))
    }

    override fun crear(entidad: Reserva): Boolean {
        val reservas = leerArchivo()

        if (reservas.any { it.id == entidad.id }) return false

        reservas.add(entidad)
        escribirArchivo(reservas)
        return true
    }

    override fun leer(id: Int): Reserva? =
        leerArchivo().find { it.id == id }

    override fun actualizar(entidad: Reserva): Boolean {
        val reservas = leerArchivo()
        val index = reservas.indexOfFirst { it.id == entidad.id }

        return if (index != -1) {
            reservas[index] = entidad
            escribirArchivo(reservas)
            true
        } else false
    }

    override fun borrar(id: Int): Boolean {
        val reservas = leerArchivo()
        val nuevaLista = reservas.filter { it.id != id }

        if (reservas.size == nuevaLista.size) return false

        escribirArchivo(nuevaLista)
        return true
    }
}