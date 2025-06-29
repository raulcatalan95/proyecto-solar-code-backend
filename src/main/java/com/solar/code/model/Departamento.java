package com.solar.code.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Departamento")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Departamento")
    private Integer idDepartamento;

    @Column(name = "Numero", length = 10)
    private String numero;

    @Column(name = "Torre", length = 50)
    private String torre;

    @Column(name = "Piso")
    private Integer piso;

    @ManyToOne
    @JoinColumn(name = "Rut_Usuario")
    private Usuario usuario;

    public Departamento() {}

    public Departamento(String numero, String torre, Integer piso, Usuario usuario) {
        this.numero = numero;
        this.torre = torre;
        this.piso = piso;
        this.usuario = usuario;
    }

    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTorre() {
        return torre;
    }

    public void setTorre(String torre) {
        this.torre = torre;
    }

    public Integer getPiso() {
        return piso;
    }

    public void setPiso(Integer piso) {
        this.piso = piso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}