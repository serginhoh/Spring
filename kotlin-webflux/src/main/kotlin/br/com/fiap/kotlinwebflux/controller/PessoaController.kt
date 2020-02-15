package br.com.fiap.kotlinwebflux.controller

import br.com.fiap.kotlinwebflux.dto.PessoaDTO
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import java.time.Duration
import java.util.ArrayList

@RestController
class PessoaController {

    @GetMapping(produces = [MediaType.APPLICATION_STREAM_JSON_VALUE])
    fun getPessoas(): Flux<PessoaDTO> = Flux.just(
            arrayListOf(
                    PessoaDTO(id = 1, nome = "Teste 01", cpf = "123.123.123-12"),
                    PessoaDTO(id = 2, nome = "Teste 02", cpf = "124.124.124-14"),
                    PessoaDTO(id = 3, nome = "Teste 03", cpf = "125.125.125-15")
            )).flatMapIterable { it }
            .delayElements(Duration.ofSeconds(2))

    /*

    fun getPessoas(): Flux<PessoaDTO> = Flux.create{
        it.next(PessoaDTO(id = 1, nome = "Teste 01", cpf = "123.123.123-12"))
        it.next(PessoaDTO(id = 2, nome = "Teste 02", cpf = "124.124.124-14"))
        it.next(PessoaDTO(id = 3, nome = "Teste 03", cpf = "125.125.125-15"))
        it.complete()
    }

        fun getPessoas(): Flux<PessoaDTO> = Flux.create{emmitter ->
        emmitter.next(PessoaDTO(id = 1, nome = "Teste 01", cpf = "123.123.123-12"))
        emmitter.next(PessoaDTO(id = 2, nome = "Teste 02", cpf = "124.124.124-14"))
        emmitter.next(PessoaDTO(id = 3, nome = "Teste 03", cpf = "125.125.125-15"))
        emmitter.complete()
    }

    fun getPessoas(): List<PessoaDTO> = arrayListOf(
            PessoaDTO(id = 1, nome = "Teste 01", cpf = "123.123.123-12"),
            PessoaDTO(id = 2, nome = "Teste 02", cpf = "124.124.124-14"),
            PessoaDTO(id = 3, nome = "Teste 03", cpf = "125.125.125-15")
    )

     fun getPessoas(): = arrayListOf(
            PessoaDTO(id = 1, nome = "Teste 01", cpf = "123.123.123-12"),
            PessoaDTO(id = 2, nome = "Teste 02", cpf = "124.124.124-14"),
            PessoaDTO(id = 3, nome = "Teste 03", cpf = "125.125.125-15")
    )

    fun getPessoas(): List<PessoaDTO>{
        return arrayListOf(
                PessoaDTO(id = 1, nome = "Teste 01", cpf = "123.123.123-12"),
                PessoaDTO(id = 2, nome = "Teste 02", cpf = "124.124.124-14"),
                PessoaDTO(id = 3, nome = "Teste 03", cpf = "125.125.125-15")
        )
    }
*/

}