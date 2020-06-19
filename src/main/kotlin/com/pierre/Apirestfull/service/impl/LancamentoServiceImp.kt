package com.pierre.Apirestfull.service.impl

import com.pierre.Apirestfull.model.Lancamento
import com.pierre.Apirestfull.repository.LancamentoRepository
import com.pierre.Apirestfull.service.LancamentoService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class LancamentoServiceImp (val lancamentoRepository: LancamentoRepository): LancamentoService {
    override fun buscarPorFuncionario( pageable: Pageable): Page<Lancamento> {
        return lancamentoRepository.findAll(pageable)
    }
    
    override fun buscarPorId(id: String): Lancamento? = lancamentoRepository.findById(id).orElse(null)
    
    override fun persistir(lancamento: Lancamento): Lancamento = lancamentoRepository.save(lancamento)
 
    
    override fun remover(id: String) = lancamentoRepository.deleteById(id)
    
    
}