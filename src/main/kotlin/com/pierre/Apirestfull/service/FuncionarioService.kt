package com.pierre.Apirestfull.service

import com.pierre.Apirestfull.model.Funcionario
import net.bytebuddy.NamingStrategy

interface FuncionarioService {
    fun persistir(funcinario: Funcionario): Funcionario
    fun buscarPorCpf(cpf: String): Funcionario?
    fun buscarPorEmail(email: String): Funcionario?
    fun buscarPorId(id: String): Funcionario?
}