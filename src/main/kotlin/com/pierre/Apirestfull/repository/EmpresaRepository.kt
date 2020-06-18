package com.pierre.Apirestfull.repository

import com.pierre.Apirestfull.model.Empresa
import org.springframework.data.jpa.repository.JpaRepository

interface EmpresaRepository : JpaRepository<Empresa, String> {
    fun findByCnpj(cnpj: String): Empresa ?
}