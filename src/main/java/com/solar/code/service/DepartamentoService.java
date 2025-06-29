package com.solar.code.service;

import com.solar.code.dto.DepartamentoDTO;
import com.solar.code.model.Departamento;
import com.solar.code.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public List<Departamento> obtenerDepartamentosPorRutUsuario(String rutUsuario) {
        return departamentoRepository.findByUsuario_RutUsuario(rutUsuario);
    }

    public Departamento guardarDepartamento(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    public List<Departamento> obtenerDepartamentos() {
        return departamentoRepository.findAll();
    }

    public Optional<Departamento> obtenerDepartamentoPorId(Integer id) {
        return departamentoRepository.findById(id);
    }

    public void eliminarDepartamento(Integer id) {
        departamentoRepository.deleteById(id);
    }

    public List<DepartamentoDTO> obtenerDepartamentosPorRutUsuarioDTO(String rutUsuario) {
        return departamentoRepository.findByUsuario_RutUsuario(rutUsuario)
                .stream()
                .map(dep -> new DepartamentoDTO(
                        dep.getIdDepartamento(),
                        dep.getNumero(),
                        dep.getTorre(),
                        dep.getPiso()
                ))
                .collect(Collectors.toList());
    }
}