package com.pierre.Apirestfull.service

import com.pierre.Apirestfull.model.Funcinario
import net.bytebuddy.NamingStrategy

interface FuncionarioService {
    fun persistir(funcinario: Funcinario): Funcinario
    fun buscarPorCpf(cpf: String): Funcinario?
    fun buscarPorEmail(email: String): Funcinario?
    fun buscarPorId(id: String): Funcinario?
}