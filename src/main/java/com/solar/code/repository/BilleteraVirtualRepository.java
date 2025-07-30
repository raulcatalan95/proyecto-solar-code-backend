package com.solar.code.repository;

import com.solar.code.model.BilleteraVirtual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BilleteraVirtualRepository extends JpaRepository<BilleteraVirtual, Integer> {
    List<BilleteraVirtual> findByUsuario_RutUsuario(String rutUsuario);
}