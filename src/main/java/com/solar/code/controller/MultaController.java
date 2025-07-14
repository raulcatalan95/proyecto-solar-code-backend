package com.solar.code.controller;

import com.solar.code.dto.MultaDTO;
import com.solar.code.model.Multa;
import com.solar.code.repository.MultaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/multas")
public class MultaController {

    @Autowired
    private MultaRepository multaRepository;

    @GetMapping("/por-departamento/{id}")
    public List<MultaDTO> getMultasPorDepartamento(@PathVariable Long id) {
        List<Multa> multas = multaRepository.findByDepartamentoId(id);
        return multas.stream()
                .map(m -> new MultaDTO(m.getId(), m.getDescripcion(), m.getMonto(), m.getEstado(), m.getFecha()))
                .collect(Collectors.toList());
    }

    // Puedes agregar más endpoints aquí
}
