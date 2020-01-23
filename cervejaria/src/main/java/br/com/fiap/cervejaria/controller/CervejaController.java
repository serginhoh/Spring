package br.com.fiap.cervejaria.controller;

import br.com.fiap.cervejaria.dto.CervejaDTO;
import br.com.fiap.cervejaria.dto.Tipo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CervejaController {

    private List<CervejaDTO> cervejaDTOList;

    public CervejaController(){
        cervejaDTOList = new ArrayList<>();

        cervejaDTOList.add(new CervejaDTO(1, "Marca 1", 4.5, Tipo.PILSEN, BigDecimal.valueOf(12.9), ZonedDateTime.now().minusYears(3)));
        cervejaDTOList.add(new CervejaDTO(2, "Marca 3", 3.5, Tipo.ALE, BigDecimal.valueOf(10.9), ZonedDateTime.now().minusYears(2)));
        cervejaDTOList.add(new CervejaDTO(3, "Marca 3", 7.5, Tipo.WEISS, BigDecimal.valueOf(17.9), ZonedDateTime.now().minusYears(1)));
    }

    @GetMapping("/getAll")

    public List<CervejaDTO> getAll(){
        return cervejaDTOList;
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hellooo..";
    }

    @GetMapping
    public String padrao(){
        return "Default....";
    }

}
