package com.solar.code.controller;

import com.solar.code.model.BilleteraVirtual;
import com.solar.code.model.Multa;
import com.solar.code.service.BilleteraVirtualService;
import com.solar.code.service.MultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/multa")
public class MultaController {

    @Autowired
    private MultaService multaService;

    @Autowired
    private BilleteraVirtualService billeteraVirtualService;

    @PostMapping("/guardar")
    public Multa guardarMulta(@RequestBody Multa multa) {
        return multaService.guardarMulta(multa);
    }

    @GetMapping("/pendientes/{rutUsuario}")
    public List<Multa> obtenerMultasPendientes(@PathVariable String rutUsuario) {
        return multaService.obtenerMultasPendientesPorRutUsuario(rutUsuario);
    }

    @PutMapping("/actualizar-estado")
    public ResponseEntity<?> actualizarEstado(@RequestBody EstadoMultaRequest request) {
        Multa multa = multaService.actualizarEstado(request.getIdMulta(), request.getNuevoEstado());
        if (multa == null) {
            return ResponseEntity.status(404).body("Multa no encontrada");
        }

        BigDecimal nuevoSaldo = null;

        if ("Pagado".equalsIgnoreCase(request.getNuevoEstado())) {
            BilleteraVirtual billetera = billeteraVirtualService.obtenerBilleterasPorRutUsuario(request.getRutUsuario())
                    .stream()
                    .findFirst()
                    .orElse(null);

            if (billetera == null) {
                return ResponseEntity.status(404).body("Billetera no encontrada para el usuario");
            }

            billetera.setSaldo(billetera.getSaldo().subtract(multa.getMonto()));
            billeteraVirtualService.guardarBilletera(billetera);
            nuevoSaldo = billetera.getSaldo();
        }

        return ResponseEntity.ok(
            nuevoSaldo != null
                ? Map.of("saldoBilletera", nuevoSaldo)
                : multa
        );
    }

    // DTO para la petición
    public static class EstadoMultaRequest {
        private Integer idMulta;
        private String nuevoEstado;
        private String rutUsuario;

        public Integer getIdMulta() { return idMulta; }
        public void setIdMulta(Integer idMulta) { this.idMulta = idMulta; }
        public String getNuevoEstado() { return nuevoEstado; }
        public void setNuevoEstado(String nuevoEstado) { this.nuevoEstado = nuevoEstado; }
        public String getRutUsuario() { return rutUsuario; }
        public void setRutUsuario(String rutUsuario) { this.rutUsuario = rutUsuario; }
    }
}