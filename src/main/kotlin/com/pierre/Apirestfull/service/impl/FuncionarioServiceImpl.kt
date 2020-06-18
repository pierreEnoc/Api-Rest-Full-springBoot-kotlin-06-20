package com.pierre.Apirestfull.service.impl

import com.pierre.Apirestfull.model.Funcinario
import com.pierre.Apirestfull.repository.FuncionarioRepository
import com.pierre.Apirestfull.service.FuncionarioService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class FuncionarioServiceImpl(val funcionarioRepository: FuncionarioRepository) : FuncionarioService {
    override fun persistir(funcinario: Funcinario): Funcinario = funcionarioRepository.save(funcinario)
    
    override fun buscarPorCpf(cpf: String): Funcinario? = funcionarioRepository.findByCpf(cpf)
    
    override fun buscarPorEmail(email: String): Funcinario? = funcionarioRepository.findByEmail(email)
    
    override fun buscarPorId(id: String): Funcinario? = funcionarioRepository.findByIdOrNull(id)
}