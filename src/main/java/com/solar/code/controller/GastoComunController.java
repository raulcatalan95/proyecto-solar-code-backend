package com.solar.code.controller;

import com.solar.code.dto.GastoComunDTO;
import com.solar.code.model.BilleteraVirtual;
import com.solar.code.model.GastoComun;
import com.solar.code.service.BilleteraVirtualService;
import com.solar.code.service.GastoComunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/gasto-comun")
public class GastoComunController {

    @Autowired
    private GastoComunService gastoComunService;

    @Autowired
    private BilleteraVirtualService billeteraVirtualService;

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
    public ResponseEntity<?> actualizarEstado(@RequestBody EstadoGastoRequest request) {
        GastoComun gasto = gastoComunService.actualizarEstado(request.getIdGasto(), request.getNuevoEstado());
        if (gasto == null) {
            return ResponseEntity.status(404).body("Gasto común no encontrado");
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

            billetera.setSaldo(billetera.getSaldo().subtract(gasto.getMonto()));
            billeteraVirtualService.guardarBilletera(billetera);
            nuevoSaldo = billetera.getSaldo();
        }

        // Respuesta con el nuevo saldo (si corresponde)
        return ResponseEntity.ok(
            nuevoSaldo != null
                ? Map.of(
        "saldoBilletera", nuevoSaldo
    )
                : gasto
        );
    }

    // DTO para la petición
    public static class EstadoGastoRequest {
        private Integer idGasto;
        private String nuevoEstado;
        private String rutUsuario; // Nuevo campo

        public Integer getIdGasto() { return idGasto; }
        public void setIdGasto(Integer idGasto) { this.idGasto = idGasto; }
        public String getNuevoEstado() { return nuevoEstado; }
        public void setNuevoEstado(String nuevoEstado) { this.nuevoEstado = nuevoEstado; }
        public String getRutUsuario() { return rutUsuario; }
        public void setRutUsuario(String rutUsuario) { this.rutUsuario = rutUsuario; }
    }
}