package com.example.bankingapi.controller;

import com.example.bankingapi.model.Movimiento;
import com.example.bankingapi.service.MovimientoService;
import com.example.bankingapi.dto.MovimientoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reportes")
public class ReporteController {

    private final MovimientoService movimientoService;

    @Autowired
    public ReporteController(MovimientoService movimientoService) {
        this.movimientoService = movimientoService;
    }

    @GetMapping
    public ResponseEntity<List<MovimientoDTO>> getEstadoDeCuenta(
            @RequestParam("clienteId") Long clienteId,
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {

        List<Movimiento> movimientos = movimientoService.getMovimientosByClienteIdAndFechaRange(clienteId, startDate, endDate);

        List<MovimientoDTO> movimientosDTO = movimientos.stream()
                .map(MovimientoDTO::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(movimientosDTO);
    }
}