package com.solar.code.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Billetera {

    @Id
    private String rut;

    private Integer saldo;

    public Billetera() {}

    public Billetera(String rut, Integer saldo) {
        this.rut = rut;
        this.saldo = saldo;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }
}

