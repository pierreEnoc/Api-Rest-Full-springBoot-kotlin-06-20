package com.pierre.Apirestfull.model

import com.pierre.Apirestfull.enums.TipoEnum
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Lancamento (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: String? = null,
        val data: Date,
        val  tipoEnum: TipoEnum,
        val funcinarioId: String,
        val descricao: String ="",
        val localizacao: String =""
)