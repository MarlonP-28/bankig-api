package com.example.bankingapi.service;

import com.example.bankingapi.model.Cuenta;
import com.example.bankingapi.repository.CuentaRepository;
import com.example.bankingapi.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuentaService {

    private final CuentaRepository cuentaRepository;

    @Autowired
    public CuentaService(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    public List<Cuenta> getAllCuentas() {
        return cuentaRepository.findAll();
    }

    public Cuenta getCuentaById(Long id) {
        return cuentaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cuenta no encontrada con id: " + id));
    }

    public Cuenta createCuenta(Cuenta cuenta) {
        if (cuentaRepository.findByNumeroCuenta(cuenta.getNumeroCuenta()).isPresent()) {
            throw new IllegalArgumentException("Cuenta con numeroCuenta " + cuenta.getNumeroCuenta() + " ya existe");
        }
        return cuentaRepository.save(cuenta);
    }

    public Cuenta updateCuenta(Long id, Cuenta cuentaDetails) {
        Cuenta cuenta = cuentaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cuenta no encontrada con id: " + id));

        cuenta.setTipoCuenta(cuentaDetails.getTipoCuenta());
        cuenta.setSaldoInicial(cuentaDetails.getSaldoInicial());
        cuenta.setEstado(cuentaDetails.isEstado());
        cuenta.setCliente(cuentaDetails.getCliente());

        return cuentaRepository.save(cuenta);
    }

    public void deleteCuenta(Long id) {
        Cuenta cuenta = cuentaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cuenta no encontrada con id: " + id));
        cuentaRepository.delete(cuenta);
    }

    public List<Cuenta> getCuentasByClienteId(Long clienteId) {
        return cuentaRepository.findByClienteClienteId(clienteId);
    }
}