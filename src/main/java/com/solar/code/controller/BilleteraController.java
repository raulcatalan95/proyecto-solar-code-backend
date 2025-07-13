package com.solar.code.controller;

import com.solar.code.model.Billetera;
import com.solar.code.model.TransaccionBilletera;
import com.solar.code.service.BilleteraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/billetera")
public class BilleteraController {

    @Autowired
    private BilleteraService billeteraService;

    @GetMapping("/{rut}")
    public Billetera getBilletera(@PathVariable String rut) {
        return billeteraService.getBilletera(rut);
    }

    @PostMapping("/recargar")
    public Billetera recargar(@RequestBody Map<String, Object> body) {
        String rut = (String) body.get("rut");
        Integer monto = (Integer) body.get("monto");
        return billeteraService.recargar(rut, monto);
    }

    @PostMapping("/pagar")
    public Billetera pagar(@RequestBody Map<String, Object> body) {
        String rut = (String) body.get("rut");
        Integer monto = (Integer) body.get("monto");
        return billeteraService.pagar(rut, monto);
    }

    @GetMapping("/{rut}/historial")
    public List<TransaccionBilletera> historial(@PathVariable String rut) {
        return billeteraService.historial(rut);
    }
}
