package com.solar.code.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Multa")
public class Multa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMulta;

    @Column(nullable = false)
    private BigDecimal monto;

    @Column(nullable = false)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "Rut_Usuario")
    private Usuario usuario;

    public Multa() {}

    public Multa(BigDecimal monto, String estado, Usuario usuario) {
        this.monto = monto;
        this.estado = estado;
        this.usuario = usuario;
    }

    public Integer getIdMulta() { return idMulta; }
    public void setIdMulta(Integer idMulta) { this.idMulta = idMulta; }
    public BigDecimal getMonto() { return monto; }
    public void setMonto(BigDecimal monto) { this.monto = monto; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}