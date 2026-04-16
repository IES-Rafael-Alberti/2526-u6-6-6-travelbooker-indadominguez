package org.practicatrim2.dao

import org.practicatrim2.dominio.Identificable

interface Dao<T : Identificable<ID>, ID> {

    fun crear(entidad: T): Boolean

    fun leer(id: ID): T?

    fun actualizar(entidad: T): Boolean

    fun borrar(id: ID): Boolean
}