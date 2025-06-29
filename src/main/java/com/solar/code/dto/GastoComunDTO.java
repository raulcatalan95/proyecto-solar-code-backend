package com.solar.code.dto;

import java.math.BigDecimal;

public class GastoComunDTO {
    private Integer idGasto;
    private BigDecimal monto;
    private String descripcion;
    private String mes;
    private Integer anio;
    private String estado;

    public GastoComunDTO() {}

    public GastoComunDTO(Integer idGasto, BigDecimal monto, String descripcion, String mes, Integer anio, String estado) {
        this.idGasto = idGasto;
        this.monto = monto;
        this.descripcion = descripcion;
        this.mes = mes;
        this.anio = anio;
        this.estado = estado;
    }

    // Getters y setters
    public Integer getIdGasto() { return idGasto; }
    public void setIdGasto(Integer idGasto) { this.idGasto = idGasto; }
    public BigDecimal getMonto() { return monto; }
    public void setMonto(BigDecimal monto) { this.monto = monto; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public String getMes() { return mes; }
    public void setMes(String mes) { this.mes = mes; }
    public Integer getAnio() { return anio; }
    public void setAnio(Integer anio) { this.anio = anio; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}