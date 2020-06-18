package com.pierre.Apirestfull.dtos

data class EmpresaDto(
        val razaoSocial : String,
        val cnpj: String,
        val id: String? = null
)