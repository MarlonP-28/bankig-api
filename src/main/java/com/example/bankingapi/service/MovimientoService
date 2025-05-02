package com.example.bankingapi.service;

import com.example.bankingapi.model.Movimiento;
import com.example.bankingapi.model.Cuenta;
import com.example.bankingapi.repository.MovimientoRepository;
import com.example.bankingapi.exception.InsufficientFundsException;
import com.example.bankingapi.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MovimientoService {

    private final MovimientoRepository movimientoRepository;
    private final CuentaService cuentaService;

    @Autowired
    public MovimientoService(MovimientoRepository movimientoRepository, CuentaService cuentaService) {
        this.movimientoRepository = movimientoRepository;
        this.cuentaService = cuentaService;
    }

    @Transactional
    public Movimiento registrarMovimiento(Movimiento movimiento) {
        Cuenta cuenta = cuentaService.getCuentaById(movimiento.getCuenta().getId());

        double saldoActual = cuenta.getSaldoInicial(); // Fetch the current balance
        double nuevoSaldo = saldoActual + movimiento.getValor();

        if (nuevoSaldo < 0 && movimiento.getValor() < 0) { // Check for withdrawal
            throw new InsufficientFundsException("Saldo no disponible");
        }

        movimiento.setSaldo(nuevoSaldo);
        movimiento.setFecha(LocalDateTime.now());
        movimiento.setCuenta(cuenta);

        cuenta.setSaldoInicial(nuevoSaldo); // Update account balance
        cuentaService.updateCuenta(cuenta.getId(), cuenta); // Persist updated account

        return movimientoRepository.save(movimiento);
    }

    public List<Movimiento> getMovimientosByCuentaId(Long cuentaId) {
        return movimientoRepository.findByCuentaId(cuentaId);
    }

    public Movimiento getMovimientoById(Long id) {
        return movimientoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movimiento not found with id: " + id));
    }

    public Movimiento updateMovimiento(Long id, Movimiento movimientoDetails) {
        Movimiento movimiento = movimientoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movimiento not found with id: " + id));

        movimiento.setFecha(movimientoDetails.getFecha());
        movimiento.setTipoMovimiento(movimientoDetails.getTipoMovimiento());
        movimiento.setValor(movimientoDetails.getValor());
        movimiento.setSaldo(movimientoDetails.getSaldo());
        movimiento.setCuenta(movimientoDetails.getCuenta());

        return movimientoRepository.save(movimiento);
    }

    public void deleteMovimiento(Long id) {
        Movimiento movimiento = movimientoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movimiento not found with id: " + id));
        movimientoRepository.delete(movimiento);
    }

    public List<Movimiento> getMovimientosByClienteIdAndFechaRange(Long clienteId, LocalDateTime startDate, LocalDateTime endDate) {
        return movimientoRepository.findByCuentaClienteClienteIdAndFechaBetween(clienteId, startDate, endDate);
    }
}