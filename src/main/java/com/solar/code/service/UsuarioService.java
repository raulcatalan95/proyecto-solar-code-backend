package com.solar.code.service;

import com.solar.code.dto.DepartamentoDTO;
import com.solar.code.dto.UsuarioAuthResponseDTO;
import com.solar.code.model.Usuario;
import com.solar.code.repository.UsuarioRepository;
import com.solar.code.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public Optional<UsuarioAuthResponseDTO> autenticarUsuario(String rutUsuario, String clave) {
        Usuario usuario = usuarioRepository.findByRutUsuarioAndClave(rutUsuario, clave);
        if (usuario == null) {
            return Optional.empty();
        }
        // Obtener departamentos asociados y mapear a DTO
        var departamentos = departamentoRepository.findByUsuario_RutUsuario(rutUsuario)
                .stream()
                .map(dep -> new DepartamentoDTO(
                        dep.getIdDepartamento(),
                        dep.getNumero(),
                        dep.getTorre(),
                        dep.getPiso()
                ))
                .collect(Collectors.toList());

        UsuarioAuthResponseDTO dto = new UsuarioAuthResponseDTO(
                usuario.getRutUsuario(),
                usuario.getNombre(),
                usuario.getCorreo(),
                departamentos
        );
        return Optional.of(dto);
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