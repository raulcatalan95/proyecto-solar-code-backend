package com.solar.code.controller;

import com.solar.code.dto.UsuarioAuthResponseDTO;
import com.solar.code.model.Usuario;
import com.solar.code.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/autenticar")
    public ResponseEntity<?> autenticarUsuario(@RequestBody Usuario usuario) {
        var result = usuarioService.autenticarUsuario(usuario.getRutUsuario(), usuario.getClave());
        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());
        } else {
            return ResponseEntity.status(401).body("Credenciales inválidas");
        }
    }

    @PostMapping("/guardar")
    public Usuario guardarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.guardarUsuario(usuario);
    }

    @GetMapping("/obtener")
    public List<Usuario> obtenerUsuarios() {
        return usuarioService.obtenerUsuarios();
    }

    @GetMapping("/obtener/{rutUsuario}")
    public Optional<Usuario> obtenerUsuarioPorRut(@PathVariable String rutUsuario) {
        return usuarioService.obtenerUsuarioPorRut(rutUsuario);
    }

    @DeleteMapping("/eliminar/{rutUsuario}")
    public void eliminarUsuario(@PathVariable String rutUsuario) {
        usuarioService.eliminarUsuario(rutUsuario);

    }
}