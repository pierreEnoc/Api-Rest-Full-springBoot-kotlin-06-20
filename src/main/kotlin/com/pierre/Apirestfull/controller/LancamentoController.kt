package com.pierre.Apirestfull.controller

import com.pierre.Apirestfull.dtos.LancamentoDto
import com.pierre.Apirestfull.enums.TipoEnum
import com.pierre.Apirestfull.model.Funcionario
import com.pierre.Apirestfull.model.Lancamento
import com.pierre.Apirestfull.response.Response
import com.pierre.Apirestfull.service.FuncionarioService
import com.pierre.Apirestfull.service.LancamentoService
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.ObjectError
import org.springframework.web.bind.annotation.*
import java.text.SimpleDateFormat
import javax.validation.Valid

@RestController
@RequestMapping("/api/lancamentos")
class LancamentoController(val lancamentoService: LancamentoService,
                           val funcionarioService: FuncionarioService) {
    private val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    
    @PostMapping
    fun adicionar(@Valid @RequestBody lancamentoDto: LancamentoDto, result: BindingResult): ResponseEntity<Response<LancamentoDto>> {
        val response: Response<LancamentoDto> = Response<LancamentoDto>()
        validarFuncionario(lancamentoDto, result)
        
        if (result.hasErrors()) {
            for (erro in result.allErrors) response.erros.add(erro.defaultMessage!!)
            return ResponseEntity.badRequest().body(response)
        }
           var lancamento: Lancamento = converterDtoParaLancamento(lancamentoDto, result)
           lancamento = lancamentoService.persistir(lancamento)
           response.data = converterLancamentoDto(lancamento)
        
        return ResponseEntity.ok(response)
    }
    
    
    @GetMapping("/{id}")
    fun listarPorId(@PathVariable("id") id: String): ResponseEntity<Response<LancamentoDto>>{
        
        val response: Response<LancamentoDto> = Response<LancamentoDto>()
        val lancamento: Lancamento? = lancamentoService.buscarPorId(id)
        
        if(lancamento == null){
            response.erros.add("Lançamento não encontrado para o id $id")
            return ResponseEntity.badRequest().body(response)
        }
        
        response.data = converterLancamentoDto(lancamento)
        return ResponseEntity.ok(response)
    }
    
    @PutMapping("/{id}")
    fun atualizar(@PathVariable("id") id: String, @Valid @RequestBody lancamentoDto: LancamentoDto,
                  result: BindingResult): ResponseEntity<Response<LancamentoDto>>{
        
        val response: Response<LancamentoDto> = Response<LancamentoDto>()
        validarFuncionario(lancamentoDto, result)
        lancamentoDto.id = id
        
        var lancamento: Lancamento = converterDtoParaLancamento(lancamentoDto, result)
        
        if(result.hasErrors()){
            for(erro in result.allErrors) response.erros.add(erro.defaultMessage!!)
            return ResponseEntity.badRequest().body(response)
        }
        
        lancamento = lancamentoService.persistir(lancamento)
        response.data = converterLancamentoDto(lancamento)
        return ResponseEntity.ok(response)
    }
    
    @DeleteMapping("/{id}")
   // @PreAuthorize("hasAnyRole('ADMIN')")
    fun remover(@PathVariable("id") id: String): ResponseEntity<Response<String>> {
        
        val response: Response<String> = Response<String>()
        val lancamento: Lancamento? = lancamentoService.buscarPorId(id)
        
        if(lancamento == null){
            response.erros.add("Erro ao remover lançamento. Registro não encontrado para o id $id")
            return ResponseEntity.badRequest().body(response)
        }
        
        lancamentoService.remover(id)
        return ResponseEntity.ok(response)
        
    }
    
    /**
     * private fun ṕara converter Lancamento para LancamentoDto
     */
    private fun converterLancamentoDto(lancamento: Lancamento): LancamentoDto = LancamentoDto(dateFormat.format(lancamento.data), lancamento.tipo.toString(),
            lancamento.descricao, lancamento.localizacao, lancamento.funcionarioId, lancamento.id)
    
    /**
     * private fun para converter LancamentoDto para Lancamento.
     */
    private fun converterDtoParaLancamento(lancamentoDto: LancamentoDto, result: BindingResult): Lancamento {
        if(lancamentoDto.id != null){
            val lanc: Lancamento? = lancamentoService.buscarPorId(lancamentoDto.id!!)
            if(lanc == null) result.addError(ObjectError("lancamento", "Lançamento não encontrado."))
        }
        
        return Lancamento(dateFormat.parse(lancamentoDto.data), TipoEnum.valueOf(lancamentoDto.tipo!!), lancamentoDto.funcionarioId!!,
                lancamentoDto.descricao, lancamentoDto.localizacao, lancamentoDto.id)
        
    }
    
    
    /**
     * private fun para validar funcionario recebido por parametro.
     */
    private fun validarFuncionario(lancamentoDto: LancamentoDto, result: BindingResult) {
        if (lancamentoDto.funcionarioId == null) {
            result.addError(ObjectError("funcionario", "Funcionário não informado."))
            return
        }
        
        val funcionario: Funcionario? = funcionarioService.buscarPorId(lancamentoDto.funcionarioId)
        
        if (funcionario == null) {
            result.addError(ObjectError("funcionario", "Funcionário não encontrado. ID inexistente."))
        }
        
    }
}