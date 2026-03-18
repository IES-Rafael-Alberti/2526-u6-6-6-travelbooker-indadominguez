package org.practicatrim2

import org.practicatrim2.presentacion.IUserInterface
import org.practicatrim2.presentacion.ConsolaUI
import org.practicatrim2.servicio.ReservaService
import org.practicatrim2.datos.ReservaRepository
import org.practicatrim2.servicio.IReservaService



fun main() {
    val repositorio = ReservaRepository()

    val reservaService: IReservaService = ReservaService(repositorio)

    val ui: IUserInterface = ConsolaUI(reservaService)

    ui.iniciar()
}