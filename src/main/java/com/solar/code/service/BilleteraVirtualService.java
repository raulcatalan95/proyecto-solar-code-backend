package com.solar.code.service;

import com.solar.code.model.BilleteraVirtual;
import com.solar.code.repository.BilleteraVirtualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BilleteraVirtualService {

    @Autowired
    private BilleteraVirtualRepository billeteraVirtualRepository;

    public BilleteraVirtual guardarBilletera(BilleteraVirtual billetera) {
        return billeteraVirtualRepository.save(billetera);
    }

    public List<BilleteraVirtual> obtenerBilleteras() {
        return billeteraVirtualRepository.findAll();
    }

    public Optional<BilleteraVirtual> obtenerBilleteraPorId(Integer id) {
        return billeteraVirtualRepository.findById(id);
    }

    public List<BilleteraVirtual> obtenerBilleterasPorRutUsuario(String rutUsuario) {
        return billeteraVirtualRepository.findByUsuario_RutUsuario(rutUsuario);
    }

    public void eliminarBilletera(Integer id) {
        billeteraVirtualRepository.deleteById(id);
    }
}