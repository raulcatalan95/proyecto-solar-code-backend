package com.solar.code.controller;

import com.solar.code.dto.DepartamentoDTO;
import com.solar.code.model.Departamento;
import com.solar.code.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/departamento")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @PostMapping("/guardar")
    public Departamento guardarDepartamento(@RequestBody Departamento departamento) {
        return departamentoService.guardarDepartamento(departamento);
    }

    @GetMapping("/obtener")
    public List<Departamento> obtenerDepartamentos() {
        return departamentoService.obtenerDepartamentos();
    }

    @GetMapping("/obtener/{id}")
    public Optional<Departamento> obtenerDepartamentoPorId(@PathVariable Integer id) {
        return departamentoService.obtenerDepartamentoPorId(id);
    }

    @GetMapping("/por-usuario/{rutUsuario}")
    public List<DepartamentoDTO> obtenerDepartamentosPorRutUsuario(@PathVariable String rutUsuario) {
        return departamentoService.obtenerDepartamentosPorRutUsuarioDTO(rutUsuario);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarDepartamento(@PathVariable Integer id) {
        departamentoService.eliminarDepartamento(id);
    }
}