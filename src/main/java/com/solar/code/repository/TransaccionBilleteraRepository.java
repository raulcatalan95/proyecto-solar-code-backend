package com.solar.code.repository;

import com.solar.code.model.TransaccionBilletera;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransaccionBilleteraRepository extends JpaRepository<TransaccionBilletera, Long> {
    List<TransaccionBilletera> findByRut(String rut);
}
