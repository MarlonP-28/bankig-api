package com.example.bankingapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Min;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Se requiere Numero Cuenta")
    @Column(unique = true)
    private String numeroCuenta;

    @NotBlank(message = "Se requiere Tipo Cuenta")
    private String tipoCuenta;

    @Min(value = 0, message = "El Saldo Inicial debe ser al menos 0")
    private double saldoInicial;

    private boolean estado;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

}