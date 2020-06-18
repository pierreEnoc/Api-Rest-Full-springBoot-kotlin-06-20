package com.pierre.Apirestfull.service.impl

import com.pierre.Apirestfull.model.Empresa
import com.pierre.Apirestfull.repository.EmpresaRepository
import com.pierre.Apirestfull.service.EmpresaService
import org.springframework.stereotype.Service

@Service
class EmpresaServiceImpl(val empresaRepository: EmpresaRepository) : EmpresaService{
    override fun buscarPorCnpj(cnpj: String): Empresa? = empresaRepository.findByCnpj(cnpj)
    
    override fun persistir(empresa: Empresa): Empresa = empresaRepository.save(empresa)
}