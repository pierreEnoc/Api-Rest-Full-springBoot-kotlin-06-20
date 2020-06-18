package com.pierre.Apirestfull.model

import com.pierre.Apirestfull.enums.TipoEnum
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Lancamento (
        val data: Date,
        val tipo: TipoEnum,
        val funcionarioId: String,
        val descricao: String? = "",
        val localizacao: String? = "",
        @GeneratedValue(strategy = GenerationType.IDENTITY) @Id val id: String? = null
)


/*
* data class Lancamento(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: String ,
        val data: TipoEnum,
        val tipo: String,
        val funcionarioId: String?,
        val descricao: String? = "",
        val localizacao: String? = ""
)

*
*
*
*
*
* */