package com.pierre.Apirestfull

import com.pierre.Apirestfull.enums.PerfilEnum
import com.pierre.Apirestfull.model.Empresa
import com.pierre.Apirestfull.model.Funcionario
import com.pierre.Apirestfull.repository.EmpresaRepository
import com.pierre.Apirestfull.repository.FuncionarioRepository
import com.pierre.Apirestfull.repository.LancamentoRepository
import com.pierre.Apirestfull.utils.SenhaUtils
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.servlet.config.annotation.EnableWebMvc

//@SpringBootApplication
//class ApiRestFullApplication

@SpringBootApplication
//@EnableWebMvc
class ApiRestFullApplication

(val empresaRepository: EmpresaRepository,
								  val funcionarioRepository: FuncionarioRepository,
								  val lancamentoRepository: LancamentoRepository): CommandLineRunner {
	
	override fun run(vararg args: String?) {
		empresaRepository.deleteAll()
		funcionarioRepository.deleteAll()
		lancamentoRepository.deleteAll()
		
		var empresa: Empresa = Empresa("RazaoSocial", "71593640000109")
		empresa = empresaRepository.save(empresa)
		
		var admin: Funcionario = Funcionario("Admin", "admin@teste.com.br", SenhaUtils().gerarBcrypt("123456"), "12920460702",
				PerfilEnum.ROLE_ADMIN, empresa.id!!)
		admin = funcionarioRepository.save(admin)
		
		var funcionario: Funcionario = Funcionario("Usuario", "usuario@teste.com.br", SenhaUtils().gerarBcrypt("123456"), "12920460702",
				PerfilEnum.ROLE_USUARIO, empresa.id!!)
		funcionario = funcionarioRepository.save(funcionario)
		
		System.out.println("Empresa ID: " + empresa.id)
		System.out.println("Admin ID: " + admin.id)
		System.out.println("Funcionario ID: " + funcionario.id)
		
	}
	

}


fun main(args: Array<String>) {
	runApplication<ApiRestFullApplication>(*args)
}
