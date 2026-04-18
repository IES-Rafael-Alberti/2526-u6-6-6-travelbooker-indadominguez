package org.practicatrim2.presentacion

import org.practicatrim2.dominio.Reserva
import org.practicatrim2.servicio.IReservaService

/**
 * Implementación de la interfaz de usuario basada en consola.
 *
 * Esta clase se encarga de interactuar con el usuario a través
 * de la terminal, permitiendo crear y listar reservas mediante
 * un menú interactivo.
 *
 * Utiliza el servicio [IReservaService] para delegar la lógica
 * de negocio relacionada con la gestión de reservas.
 *
 * @property reservaService servicio encargado de gestionar las operaciones
 * relacionadas con las reservas.
 */
class ConsolaUI(private val reservaService: IReservaService) : IUserInterface {

    /**
     * Inicia la ejecución de la interfaz de usuario.
     *
     * Muestra el menú principal en un bucle hasta que el usuario
     * selecciona la opción de salir de la aplicación.
     */
    override fun iniciar() {
        var salir = false
        while (!salir) {
            mostrarMenu()
            when (leerOpcion()) {
                1 -> crearReserva()
                2 -> listarReservas()
                3 -> {
                    println("Saliendo de la aplicación. ¡Hasta luego!")
                    salir = true
                }

                else -> println("Opción no válida. Intente nuevamente.")
            }
        }
    }

    /**
     * Muestra el menú principal de la aplicación.
     */
    private fun mostrarMenu() {
        println("\n----- Gestor de Reservas -----")
        println("1. Crear nueva reserva")
        println("2. Listar reservas")
        println("3. Salir")
        print("Seleccione una opción: ")
    }

    /**
     * Lee la opción introducida por el usuario desde la consola.
     *
     * @return número entero correspondiente a la opción seleccionada.
     * Si ocurre un error de conversión, devuelve `-1`.
     */
    private fun leerOpcion(): Int = try {
        readln().toInt()
    } catch (e: Exception) {
        -1
    }

    /**
     * Permite al usuario crear una nueva reserva.
     *
     * El usuario puede elegir entre crear:
     * - una reserva de vuelo
     * - una reserva de hotel
     *
     * Los datos se solicitan por consola y se envían al
     * servicio [IReservaService] para su creación.
     *
     * Si ocurre un error de validación, se muestra el mensaje
     * correspondiente al usuario.
     */
    private fun crearReserva() {
        println("\nSeleccione el tipo de reserva a crear:")
        println("1. Reserva de Vuelo")
        println("2. Reserva de Hotel")
        print("Opción: ")
        when (leerOpcion()) {
            1 -> {
                print("Ingrese la descripción (itinerario) de la reserva de vuelo: ")
                val descripcion = readln()
                print("Ingrese el origen: ")
                val origen = readln()
                print("Ingrese el destino: ")
                val destino = readln()
                print("Ingrese la hora de vuelo (HH:mm): ")
                val horaVuelo = readln()
                try {
                    reservaService.crearReservaVuelo(descripcion, origen, destino, horaVuelo)
                    println("Reserva de vuelo creada exitosamente.")
                } catch (e: IllegalArgumentException) {
                    println("Error al crear la reserva: ${e.message}")
                }
            }

            2 -> {
                print("Ingrese la descripción de la reserva de hotel: ")
                val descripcion = readln()
                print("Ingrese la ubicación: ")
                val ubicacion = readln()
                print("Ingrese el número de noches: ")
                val numeroNoches = try {
                    readln().toInt()
                } catch (e: Exception) {
                    println("Número inválido de noches, se asignará 1 por defecto.")
                    1
                }
                try {
                    reservaService.crearReservaHotel(descripcion, ubicacion, numeroNoches)
                    println("Reserva de hotel creada exitosamente.")
                } catch (e: IllegalArgumentException) {
                    println("Error al crear la reserva: ${e.message}")
                }
            }

            else -> println("Opción no válida.")
        }
    }

    /**
     * Obtiene y muestra todas las reservas registradas.
     *
     * Solicita al servicio [IReservaService] la lista de reservas
     * existentes y las muestra por consola. Si no hay reservas,
     * se informa al usuario.
     */
    private fun listarReservas() {
        println("\n--- Lista de Reservas ---")
        val reservas: List<Reserva> = reservaService.listarReservas()
        if (reservas.isEmpty()) {
            println("No hay reservas registradas.")
        } else {
            reservas.forEach { println(it.toString()) }
        }
    }
}