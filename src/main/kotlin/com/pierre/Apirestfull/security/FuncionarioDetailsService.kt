package com.pierre.Apirestfull.security

import com.pierre.Apirestfull.model.Funcionario
import com.pierre.Apirestfull.service.FuncionarioService
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class FuncionarioDetailsService(val funcionarioService: FuncionarioService) : UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails {
       if (username !=null){
           funcionarioService.buscarPorEmail(username)
           val funcionario = funcionarioService.buscarPorEmail(username)
            if (funcionario != null){
                return FuncionarioPrincipal(funcionario)
            }
       }
        throw UsernameNotFoundException(username)
    }
    
}