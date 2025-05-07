package com.example.bankingapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

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

    @Enumerated(EnumType.STRING)
    @NotNull(message = "El Tipo de Movimiento es requerido")
    private TipoMovimiento tipoMovimiento;

    @Min(value = 0, message = "El valor debe ser al menos 0")
    private double valor;

    private double saldo;  // Saldo después del movimiento

    @ManyToOne
    @JoinColumn(name = "cuenta_id")
    private Cuenta cuenta;
}
