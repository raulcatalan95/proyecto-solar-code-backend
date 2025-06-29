package com.solar.code.repository;

import com.solar.code.model.GastoComun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GastoComunRepository extends JpaRepository<GastoComun, Integer> {
    List<GastoComun> findByDepartamento_IdDepartamento(Integer idDepartamento);
}