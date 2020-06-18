package com.pierre.Apirestfull.controller

import com.pierre.Apirestfull.dtos.LancamentoDto
import com.pierre.Apirestfull.response.Response
import com.pierre.Apirestfull.service.FuncionarioService
import com.pierre.Apirestfull.service.LancamentoService
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
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
       
}