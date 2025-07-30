package com.solar.code.dto;

import java.math.BigDecimal;
import java.util.List;

public class UsuarioAuthResponseDTO {
    private String rutUsuario;
    private String nombre;
    private String correo;
    private List<DepartamentoDTO> departamentos;
    private BigDecimal saldoBilletera; // Nuevo campo

    public UsuarioAuthResponseDTO() {}

    public UsuarioAuthResponseDTO(String rutUsuario, String nombre, String correo, List<DepartamentoDTO> departamentos, BigDecimal saldoBilletera) {
        this.rutUsuario = rutUsuario;
        this.nombre = nombre;
        this.correo = correo;
        this.departamentos = departamentos;
        this.saldoBilletera = saldoBilletera;
    }

    public UsuarioAuthResponseDTO(String rutUsuario2, String nombre2, String correo2,
            List<DepartamentoDTO> departamentos2) {
        //TODO Auto-generated constructor stub
    }

    public String getRutUsuario() { return rutUsuario; }
    public void setRutUsuario(String rutUsuario) { this.rutUsuario = rutUsuario; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    public List<DepartamentoDTO> getDepartamentos() { return departamentos; }
    public void setDepartamentos(List<DepartamentoDTO> departamentos) { this.departamentos = departamentos; }
    public BigDecimal getSaldoBilletera() { return saldoBilletera; }
    public void setSaldoBilletera(BigDecimal saldoBilletera) { this.saldoBilletera = saldoBilletera; }
}