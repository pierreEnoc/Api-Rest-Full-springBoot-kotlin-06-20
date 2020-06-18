package com.pierre.Apirestfull.repository

import com.pierre.Apirestfull.model.Funcinario
import com.pierre.Apirestfull.model.Lancamento
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface LancamentoRepository : JpaRepository <Lancamento, String>{
 //   fun findByFuncinarioId(pageable: Pageable): Page<Lancamento>
 
}