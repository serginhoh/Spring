package br.com.fiap.cervejaria.controller;

import br.com.fiap.cervejaria.dto.CervejaDTO;
import br.com.fiap.cervejaria.dto.CreateCervejaDTO;
import br.com.fiap.cervejaria.dto.PrecoCervejaDTO;
import br.com.fiap.cervejaria.dto.Tipo;
import br.com.fiap.cervejaria.service.CervejaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("cervejas")
public class CervejaController {

    private final CervejaService service;

    public CervejaController(CervejaService service) {
        this.service = service;
    }

    //http://localhost:8081/cervejas/getAll?tipo=PILSEN
    @GetMapping("/getAll")
    public List<CervejaDTO> getAll(@RequestParam(required = false) Tipo tipo) {
        return service.findAll(tipo);
    }

    //http://localhost:8081/cervejas/1
    @GetMapping("{id}")
    public CervejaDTO findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hellooo..";
    }

    @GetMapping
    public String padrao() {
        return "Cervejas....";
    }

    //http://localhost:8081/cervejas/
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CervejaDTO create(@RequestBody @Valid CreateCervejaDTO createCervejaDTO) {
        return service.create(createCervejaDTO);
    }

    //http://localhost:8081/cervejas/1
    @PutMapping("{id}")
    public CervejaDTO update(@PathVariable Integer id, @RequestBody CreateCervejaDTO createCervejaDTO) {
        return service.update(id, createCervejaDTO);
    }

    @PatchMapping("{id}")
    public CervejaDTO update(@PathVariable Integer id, @RequestBody PrecoCervejaDTO precoCervejaDTO) {
        return service.update(id, precoCervejaDTO);
    }

    //http://localhost:8081/cervejas/1
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

}
