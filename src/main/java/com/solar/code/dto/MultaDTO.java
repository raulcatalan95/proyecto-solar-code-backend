package com.solar.code.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MultaDTO {

    private Long id;
    private String descripcion;
    private BigDecimal monto;
    private String estado;
    private LocalDateTime fecha;

    public MultaDTO() {}

    public MultaDTO(Long id, String descripcion, BigDecimal monto, String estado, LocalDateTime fecha) {
        this.id = id;
        this.descripcion = descripcion;
        this.monto = monto;
        this.estado = estado;
        this.fecha = fecha;
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public BigDecimal getMonto() { return monto; }
    public void setMonto(BigDecimal monto) { this.monto = monto; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
}
