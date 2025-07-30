package com.solar.code.controller;

import com.solar.code.model.BilleteraVirtual;
import com.solar.code.service.BilleteraVirtualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/billetera-virtual")
public class BilleteraVirtualController {

    @Autowired
    private BilleteraVirtualService billeteraVirtualService;

    @PostMapping("/guardar")
    public BilleteraVirtual guardarBilletera(@RequestBody BilleteraVirtual billetera) {
        return billeteraVirtualService.guardarBilletera(billetera);
    }
    

    @GetMapping("/obtener")
    public List<BilleteraVirtual> obtenerBilleteras() {
        return billeteraVirtualService.obtenerBilleteras();
    }

    @GetMapping("/obtener/{id}")
    public Optional<BilleteraVirtual> obtenerBilleteraPorId(@PathVariable Integer id) {
        return billeteraVirtualService.obtenerBilleteraPorId(id);
    }

    @GetMapping("/por-usuario/{rutUsuario}")
    public List<BilleteraVirtual> obtenerBilleterasPorRutUsuario(@PathVariable String rutUsuario) {
        return billeteraVirtualService.obtenerBilleterasPorRutUsuario(rutUsuario);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarBilletera(@PathVariable Integer id) {
        billeteraVirtualService.eliminarBilletera(id);
    }
}