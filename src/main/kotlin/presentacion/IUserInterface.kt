package org.practicatrim2.presentacion

/**
 * Define el contrato de una interfaz de usuario del sistema.
 *
 * Las implementaciones de esta interfaz son responsables de
 * interactuar con el usuario (por ejemplo, mediante consola,
 * interfaz gráfica o aplicación web) y de iniciar el flujo
 * principal de la aplicación.
 */
interface IUserInterface {

    /**
     * Inicia la ejecución de la interfaz de usuario.
     *
     * Este método suele contener el bucle principal de interacción
     * con el usuario y el acceso a las funcionalidades del sistema.
     */
    fun iniciar()
}