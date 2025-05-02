package com.example.bankingapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDateTime fecha;

    @NotBlank(message = "Tipo Movimiento is required")
    private String tipoMovimiento;

    @Min(value = 0, message = "Valor must be at least 0")
    private double valor;

    private double saldo;  // Saldo after the movement

    @ManyToOne
    @JoinColumn(name = "cuenta_id")
    private Cuenta cuenta;

}