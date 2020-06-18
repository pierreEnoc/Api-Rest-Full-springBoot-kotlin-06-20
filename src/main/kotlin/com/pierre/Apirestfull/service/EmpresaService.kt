package com.pierre.Apirestfull.service

import com.pierre.Apirestfull.model.Empresa

interface EmpresaService {
    fun buscarPorCnpj(cnpj:String): Empresa?
    fun persistir(empresa: Empresa): Empresa
    
}