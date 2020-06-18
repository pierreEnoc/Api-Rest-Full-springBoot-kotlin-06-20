package com.pierre.Apirestfull.repository

import com.pierre.Apirestfull.model.Funcinario
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface FuncionarioRepository : JpaRepository<Funcinario, String> {
    fun findByEmail(email: String) : Funcinario ?
    fun findByCpf(cpf: String): Funcinario ?
    
}