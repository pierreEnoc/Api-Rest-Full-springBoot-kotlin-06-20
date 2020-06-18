package com.pierre.Apirestfull.service.impl

import com.pierre.Apirestfull.model.Funcionario
import com.pierre.Apirestfull.repository.FuncionarioRepository
import com.pierre.Apirestfull.service.FuncionarioService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class FuncionarioServiceImpl(val funcionarioRepository: FuncionarioRepository) : FuncionarioService {
    override fun persistir(funcinario: Funcionario): Funcionario = funcionarioRepository.save(funcinario)
    
    override fun buscarPorCpf(cpf: String): Funcionario? = funcionarioRepository.findByCpf(cpf)
    
    override fun buscarPorEmail(email: String): Funcionario? = funcionarioRepository.findByEmail(email)
    
    override fun buscarPorId(id: String): Funcionario? = funcionarioRepository.findByIdOrNull(id)
}