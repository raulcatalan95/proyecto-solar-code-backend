package com.solar.code.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter




@Entity
@Table(name = "multa")
public class Multa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_departamento", nullable = true) // <- permite null temporalmente
    private Departamento departamento;

    private String descripcion;

    private BigDecimal monto;

    private String estado = "Pendiente";

    private LocalDateTime fecha = LocalDateTime.now();

}
