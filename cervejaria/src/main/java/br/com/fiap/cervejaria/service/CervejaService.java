package br.com.fiap.cervejaria.service;

import br.com.fiap.cervejaria.dto.CervejaDTO;
import br.com.fiap.cervejaria.dto.CreateCervejaDTO;
import br.com.fiap.cervejaria.dto.PrecoCervejaDTO;
import br.com.fiap.cervejaria.dto.Tipo;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CervejaService {
    List<CervejaDTO> findAll(Tipo tipo);
    Page<CervejaDTO> findAll(Integer size, Integer page, Tipo tipo);
    CervejaDTO findById(Integer id);
    CervejaDTO create(CreateCervejaDTO createCervejaDTO);
    CervejaDTO update(Integer id, CreateCervejaDTO createCervejaDTO);
    CervejaDTO update(Integer id, PrecoCervejaDTO precoCervejaDTO);
    void delete(Integer id);
}
