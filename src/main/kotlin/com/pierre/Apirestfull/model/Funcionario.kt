package com.pierre.Apirestfull.model

import com.pierre.Apirestfull.enums.PerfilEnum
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Funcionario (
        val nome: String,
        val email: String,
        val senha: String,
        val cpf: String,
        val perfil: PerfilEnum,
        val empresaId: String,
        val valorHora: Double? = 0.0,
        val qtdHorasTrabalhoDia: Float? = 0.0f,
        val qtdHorasAlmoco: Float? = 0.0f,
        @GeneratedValue(strategy = GenerationType.IDENTITY)  @Id val id: String? = null
)