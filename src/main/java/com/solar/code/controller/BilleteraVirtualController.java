package com.solar.code.controller;

import com.solar.code.model.BilleteraVirtual;
import com.solar.code.service.BilleteraVirtualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/cargar-saldo")
    public ResponseEntity<?> cargarSaldo(@RequestBody CargarSaldoRequest request) {
        BilleteraVirtual billetera = billeteraVirtualService.obtenerBilleterasPorRutUsuario(request.getRutUsuario())
                .stream()
                .findFirst()
                .orElse(null);

        if (billetera == null) {
            return ResponseEntity.status(404).body("Billetera no encontrada para el usuario");
        }

        billetera.setSaldo(billetera.getSaldo().add(request.getMonto()));
        billeteraVirtualService.guardarBilletera(billetera);

        return ResponseEntity.ok(billetera.getSaldo());
    }

    // DTO interno para la petición
    public static class CargarSaldoRequest {
        private String rutUsuario;
        private java.math.BigDecimal monto;

        public String getRutUsuario() { return rutUsuario; }
        public void setRutUsuario(String rutUsuario) { this.rutUsuario = rutUsuario; }
        public java.math.BigDecimal getMonto() { return monto; }
        public void setMonto(java.math.BigDecimal monto) { this.monto = monto; }
    }
}