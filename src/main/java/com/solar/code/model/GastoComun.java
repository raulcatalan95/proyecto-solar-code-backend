package com.solar.code.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Gasto_Comun")
public class GastoComun {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Gasto")
    private Integer idGasto;

    @Column(name = "Monto")
    private BigDecimal monto;

    @Column(name = "Descripcion", length = 1000)
    private String descripcion;

    @Column(name = "Mes", length = 50)
    private String mes;

    @Column(name = "Anio")
    private Integer anio;

    @Column(name = "Estado", length = 50)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "Id_Departamento")
    private Departamento departamento;

    public GastoComun() {}

    public GastoComun(BigDecimal monto, String descripcion, String mes, Integer anio, String estado, Departamento departamento) {
        this.monto = monto;
        this.descripcion = descripcion;
        this.mes = mes;
        this.anio = anio;
        this.estado = estado;
        this.departamento = departamento;
    }

    public Integer getIdGasto() {
        return idGasto;
    }

    public void setIdGasto(Integer idGasto) {
        this.idGasto = idGasto;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}