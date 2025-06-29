package com.solar.code.service;

import com.solar.code.model.Usuario;
import com.solar.code.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario autenticarUsuario(String rutUsuario, String clave) {
        return usuarioRepository.findByRutUsuarioAndClave(rutUsuario, clave);
    }

    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> obtenerUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> obtenerUsuarioPorRut(String rutUsuario) {
        return usuarioRepository.findById(rutUsuario);
    }

    public void eliminarUsuario(String rutUsuario) {
        usuarioRepository.deleteById(rutUsuario);
    }
}