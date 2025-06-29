package com.solar.code.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @Column(name = "Rut_Usuario", length = 20)
    private String rutUsuario;

    @Column(name = "Nombre", length = 1000)
    private String nombre;

    @Column(name = "Correo", length = 1000)
    private String correo;

    @Column(name = "Clave", length = 1000)
    private String clave;

    public Usuario() {}

    public Usuario(String rutUsuario, String nombre, String correo, String clave) {
        this.rutUsuario = rutUsuario;
        this.nombre = nombre;
        this.correo = correo;
        this.clave = clave;
    }

    public String getRutUsuario() {
        return rutUsuario;
    }

    public void setRutUsuario(String rutUsuario) {
        this.rutUsuario = rutUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}