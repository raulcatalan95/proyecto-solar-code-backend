package com.solar.code.controller;

import com.solar.code.dto.GastoComunDTO;
import com.solar.code.model.GastoComun;
import com.solar.code.service.GastoComunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/gasto-comun")
public class GastoComunController {

    @Autowired
    private GastoComunService gastoComunService;

    @PostMapping("/guardar")
    public GastoComun guardarGastoComun(@RequestBody GastoComun gastoComun) {
        return gastoComunService.guardarGastoComun(gastoComun);
    }

    @GetMapping("/obtener")
    public List<GastoComun> obtenerGastosComunes() {
        return gastoComunService.obtenerGastosComunes();
    }

    @GetMapping("/obtener/{id}")
    public Optional<GastoComun> obtenerGastoComunPorId(@PathVariable Integer id) {
        return gastoComunService.obtenerGastoComunPorId(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarGastoComun(@PathVariable Integer id) {
        gastoComunService.eliminarGastoComun(id);
    }

    @GetMapping("/por-departamento/{idDepartamento}")
    public List<GastoComunDTO> obtenerGastosPorDepartamento(@PathVariable Integer idDepartamento) {
        return gastoComunService.obtenerGastosPorDepartamentoDTO(idDepartamento);
    }

    @GetMapping("/pendientes-por-departamento/{idDepartamento}")
    public List<GastoComunDTO> obtenerGastosPendientesPorDepartamento(@PathVariable Integer idDepartamento) {
        return gastoComunService.obtenerGastosPendientesPorDepartamentoDTO(idDepartamento);
    }

    @PutMapping("/actualizar-estado")
    public GastoComun actualizarEstado(@RequestBody EstadoGastoRequest request) {
        return gastoComunService.actualizarEstado(request.getIdGasto(), request.getNuevoEstado());
    }

    // DTO para la petición
    static class EstadoGastoRequest {
        private Integer idGasto;
        private String nuevoEstado;

        public Integer getIdGasto() { return idGasto; }
        public void setIdGasto(Integer idGasto) { this.idGasto = idGasto; }
        public String getNuevoEstado() { return nuevoEstado; }
        public void setNuevoEstado(String nuevoEstado) { this.nuevoEstado = nuevoEstado; }
    }
}