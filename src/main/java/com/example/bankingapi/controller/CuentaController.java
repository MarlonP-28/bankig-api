package com.example.bankingapi.controller;

import com.example.bankingapi.model.Cuenta;
import com.example.bankingapi.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {

    private final CuentaService cuentaService;

    @Autowired
    public CuentaController(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    @GetMapping
    public ResponseEntity<List<Cuenta>> getAllCuentas() {
        return ResponseEntity.ok(cuentaService.getAllCuentas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cuenta> getCuentaById(@PathVariable Long id) {
        return ResponseEntity.ok(cuentaService.getCuentaById(id));
    }

    @PostMapping
    public ResponseEntity<Cuenta> createCuenta(@Valid @RequestBody Cuenta cuenta) {
        return new ResponseEntity<>(cuentaService.createCuenta(cuenta), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cuenta> updateCuenta(@PathVariable Long id, @Valid @RequestBody Cuenta cuentaDetails) {
        Cuenta updatedCuenta = cuentaService.updateCuenta(id, cuentaDetails);
        return ResponseEntity.ok(updatedCuenta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCuenta(@PathVariable Long id) {
        cuentaService.deleteCuenta(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<Cuenta>> getCuentasByClienteId(@PathVariable Long clienteId) {
        return ResponseEntity.ok(cuentaService.getCuentasByClienteId(clienteId));
    }
}