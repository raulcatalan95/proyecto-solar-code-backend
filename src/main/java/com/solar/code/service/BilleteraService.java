package com.solar.code.service;

import com.solar.code.model.Billetera;
import com.solar.code.model.TransaccionBilletera;
import com.solar.code.repository.BilleteraRepository;
import com.solar.code.repository.TransaccionBilleteraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BilleteraService {

    @Autowired
    private BilleteraRepository billeteraRepo;

    @Autowired
    private TransaccionBilleteraRepository transaccionRepo;

    public Billetera getBilletera(String rut) {
        return billeteraRepo.findById(rut).orElseGet(() -> {
            Billetera nueva = new Billetera(rut, 0);
            return billeteraRepo.save(nueva);
        });
    }

    public Billetera recargar(String rut, Integer monto) {
        Billetera billetera = getBilletera(rut);
        billetera.setSaldo(billetera.getSaldo() + monto);
        billeteraRepo.save(billetera);

        TransaccionBilletera tx = new TransaccionBilletera();
        tx.setRut(rut);
        tx.setMonto(monto);
        tx.setTipo("RECARGA");
        tx.setFecha(LocalDateTime.now());
        transaccionRepo.save(tx);

        return billetera;
    }

    public Billetera pagar(String rut, Integer monto) {
        Billetera billetera = getBilletera(rut);
        if (billetera.getSaldo() >= monto) {
            billetera.setSaldo(billetera.getSaldo() - monto);
            billeteraRepo.save(billetera);

            TransaccionBilletera tx = new TransaccionBilletera();
            tx.setRut(rut);
            tx.setMonto(monto);
            tx.setTipo("PAGO");
            tx.setFecha(LocalDateTime.now());
            transaccionRepo.save(tx);

            return billetera;
        }
        throw new IllegalArgumentException("Saldo insuficiente");
    }

    public List<TransaccionBilletera> historial(String rut) {
        return transaccionRepo.findByRut(rut);
    }
}
