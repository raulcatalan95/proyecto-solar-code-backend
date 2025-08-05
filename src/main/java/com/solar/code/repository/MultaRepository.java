
package com.solar.code.repository;

import com.solar.code.model.Multa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MultaRepository extends JpaRepository<Multa, Integer> {
    List<Multa> findByUsuario_RutUsuarioAndEstadoNot(String rutUsuario, String estado);
    List<Multa> findByUsuario_RutUsuario(String rutUsuario);
}