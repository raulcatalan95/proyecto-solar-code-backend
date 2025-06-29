package com.solar.code.service;

import com.solar.code.dto.GastoComunDTO;
import com.solar.code.model.GastoComun;
import com.solar.code.repository.GastoComunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GastoComunService {

    @Autowired
    private GastoComunRepository gastoComunRepository;

    public GastoComun guardarGastoComun(GastoComun gastoComun) {
        return gastoComunRepository.save(gastoComun);
    }

    public List<GastoComun> obtenerGastosComunes() {
        return gastoComunRepository.findAll();
    }

    public Optional<GastoComun> obtenerGastoComunPorId(Integer id) {
        return gastoComunRepository.findById(id);
    }

    public void eliminarGastoComun(Integer id) {
        gastoComunRepository.deleteById(id);
    }

    public List<GastoComun> obtenerGastosPorDepartamento(Integer idDepartamento) {
        return gastoComunRepository.findByDepartamento_IdDepartamento(idDepartamento);
    }

    public GastoComun actualizarEstado(Integer id, String nuevoEstado) {
        GastoComun gasto = gastoComunRepository.findById(id).orElse(null);
        if (gasto != null) {
            gasto.setEstado(nuevoEstado);
            return gastoComunRepository.save(gasto);
        }
        return null;
    }

    public List<GastoComunDTO> obtenerGastosPorDepartamentoDTO(Integer idDepartamento) {
        return gastoComunRepository.findByDepartamento_IdDepartamento(idDepartamento)
                .stream()
                .map(g -> new GastoComunDTO(
                        g.getIdGasto(),
                        g.getMonto(),
                        g.getDescripcion(),
                        g.getMes(),
                        g.getAnio(),
                        g.getEstado()
                ))
                .collect(Collectors.toList());
    }

    public List<GastoComunDTO> obtenerGastosPendientesPorDepartamentoDTO(Integer idDepartamento) {
        return gastoComunRepository.findByDepartamento_IdDepartamento(idDepartamento)
                .stream()
                .filter(g -> "Pendiente".equalsIgnoreCase(g.getEstado()))
                .map(g -> new GastoComunDTO(
                        g.getIdGasto(),
                        g.getMonto(),
                        g.getDescripcion(),
                        g.getMes(),
                        g.getAnio(),
                        g.getEstado()
                ))
                .collect(Collectors.toList());
    }
}