package com.example.bankingapi.dto;

import com.example.bankingapi.model.Movimiento;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class MovimientoDTO {
    private LocalDateTime fecha;
    private String tipoMovimiento;
    private double valor;
    private double saldo;
    private String numeroCuenta;
    private String clienteNombre;

    public MovimientoDTO(Movimiento movimiento) {
        this.fecha = movimiento.getFecha();
        this.tipoMovimiento = movimiento.getTipoMovimiento().name();;
        this.valor = movimiento.getValor();
        this.saldo = movimiento.getSaldo();
        this.numeroCuenta = movimiento.getCuenta().getNumeroCuenta();
        this.clienteNombre = movimiento.getCuenta().getCliente().getNombre();
    }
}