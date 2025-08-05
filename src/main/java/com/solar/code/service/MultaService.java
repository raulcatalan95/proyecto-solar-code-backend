package com.solar.code.service;

import com.solar.code.model.Multa;
import com.solar.code.repository.MultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MultaService {

    @Autowired
    private MultaRepository multaRepository;

    public Multa guardarMulta(Multa multa) {
        return multaRepository.save(multa);
    }

    public List<Multa> obtenerMultasPorRutUsuario(String rutUsuario) {
        return multaRepository.findByUsuario_RutUsuario(rutUsuario);
    }

    public List<Multa> obtenerMultasPendientesPorRutUsuario(String rutUsuario) {
        return multaRepository.findByUsuario_RutUsuarioAndEstadoNot(rutUsuario, "Pagado");
    }

    public Optional<Multa> obtenerMultaPorId(Integer id) {
        return multaRepository.findById(id);
    }

    public Multa actualizarEstado(Integer id, String nuevoEstado) {
        Optional<Multa> multaOpt = multaRepository.findById(id);
        if (multaOpt.isPresent()) {
            Multa multa = multaOpt.get();
            multa.setEstado(nuevoEstado);
            return multaRepository.save(multa);
        }
        return null;
    }
}