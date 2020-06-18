package com.pierre.Apirestfull.service

import com.pierre.Apirestfull.model.Lancamento
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import javax.persistence.Id

interface LancamentoService {
    fun buscarPorFuncionario(pageable: Pageable ) : Page<Lancamento>
    fun buscarPorId(id: String): Lancamento?
    fun persistir(lancamento: Lancamento): Lancamento
    fun remover(id: String)
}