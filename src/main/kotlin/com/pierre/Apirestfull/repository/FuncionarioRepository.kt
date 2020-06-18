package com.pierre.Apirestfull.repository

import com.pierre.Apirestfull.model.Funcionario
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface FuncionarioRepository : JpaRepository<Funcionario, String> {
    fun findByEmail(email: String) : Funcionario ?
    fun findByCpf(cpf: String): Funcionario ?
    
}