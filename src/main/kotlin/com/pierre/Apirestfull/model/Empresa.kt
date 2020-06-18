package com.pierre.Apirestfull.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Empresa (
        val razaoSocial: String,
        val cnpj: String,
   @GeneratedValue(strategy = GenerationType.IDENTITY)   @Id val id: String? = null
)