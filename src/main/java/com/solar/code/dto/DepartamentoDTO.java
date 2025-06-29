package com.solar.code.dto;

public class DepartamentoDTO {
    private Integer idDepartamento;
    private String numero;
    private String torre;
    private Integer piso;

    public DepartamentoDTO() {}

    public DepartamentoDTO(Integer idDepartamento, String numero, String torre, Integer piso) {
        this.idDepartamento = idDepartamento;
        this.numero = numero;
        this.torre = torre;
        this.piso = piso;
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
}