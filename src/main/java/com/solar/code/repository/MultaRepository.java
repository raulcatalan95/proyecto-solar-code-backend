package com.solar.code.repository;

import com.solar.code.model.Multa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MultaRepository extends JpaRepository<Multa, Long> {
   List<Multa> findByDepartamentoIdDepartamento(Integer idDepartamento);

}
