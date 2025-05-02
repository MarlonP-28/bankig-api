package com.example.bankingapi.controller;

import com.example.bankingapi.model.Movimiento;
import com.example.bankingapi.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {

    private final MovimientoService movimientoService;

    @Autowired
    public MovimientoController(MovimientoService movimientoService) {
        this.movimientoService = movimientoService;
    }

    @GetMapping
    public ResponseEntity<List<Movimiento>> getAllMovimientos() {
        return ResponseEntity.ok(movimientoService.getAllMovimientos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movimiento> getMovimientoById(@PathVariable Long id) {
        return ResponseEntity.ok(movimientoService.getMovimientoById(id));
    }

    @PostMapping
    public ResponseEntity<Movimiento> createMovimiento(@Valid @RequestBody Movimiento movimiento) {
        return new ResponseEntity<>(movimientoService.registrarMovimiento(movimiento), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movimiento> updateMovimiento(@PathVariable Long id, @Valid @RequestBody Movimiento movimientoDetails) {
        Movimiento updatedMovimiento = movimientoService.updateMovimiento(id, movimientoDetails);
        return ResponseEntity.ok(updatedMovimiento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovimiento(@PathVariable Long id) {
        movimientoService.deleteMovimiento(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/cuenta/{cuentaId}")
    public ResponseEntity<List<Movimiento>> getMovimientosByCuentaId(@PathVariable Long cuentaId) {
        return ResponseEntity.ok(movimientoService.getMovimientosByCuentaId(cuentaId));
    }
}