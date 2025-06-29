package com.solar.code.repository;

import com.solar.code.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    Usuario findByRutUsuarioAndClave(String rutUsuario, String clave);
}