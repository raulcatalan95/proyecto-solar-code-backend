package com.solar.code.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "BilleteraVirtual")
public class BilleteraVirtual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBilletera;

    @Column(nullable = false)
    private BigDecimal saldo;

    @ManyToOne
    @JoinColumn(name = "Rut_Usuario")
    private Usuario usuario;

    public BilleteraVirtual() {}

    public BilleteraVirtual(BigDecimal saldo, Usuario usuario) {
        this.saldo = saldo;
        this.usuario = usuario;
    }

    public Integer getIdBilletera() {
        return idBilletera;
    }

    public void setIdBilletera(Integer idBilletera) {
        this.idBilletera = idBilletera;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}