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
        // Obtener la cuenta asociada al movimiento
        Cuenta cuenta = cuentaService.getCuentaById(movimiento.getCuenta().getId());

        // Obtener el saldo actual de la cuenta
        double saldoActual = cuenta.getSaldoInicial(); // Asegúrate de que esto sea el saldo actualizado
        double nuevoSaldo = saldoActual + movimiento.getValor();

        // Validar si el saldo es suficiente para el retiro
        if (nuevoSaldo < 0 && movimiento.getValor() < 0) { // Si es un retiro y el saldo es insuficiente
            throw new InsufficientFundsException("Saldo no disponible");
        }

        // Actualizar el movimiento con la fecha y el saldo
        movimiento.setSaldo(nuevoSaldo);
        movimiento.setFecha(LocalDateTime.now());
        movimiento.setCuenta(cuenta);

        // Actualizar el saldo de la cuenta
        cuenta.setSaldoInicial(nuevoSaldo); // Aquí puedes usar el campo adecuado si no es saldoInicial
        cuentaService.updateCuenta(cuenta.getId(), cuenta); // Actualizar la cuenta en la base de datos

        // Guardar y retornar el movimiento
        return movimientoRepository.save(movimiento);
    }

    private void validarSaldoSuficiente(Movimiento movimiento, double nuevoSaldo) {
        if (movimiento.getValor() < 0 && nuevoSaldo < 0) { // Validar retiro sin fondos suficientes
            throw new InsufficientFundsException("Saldo no disponible");
        }
    }

    // Método modificado para utilizar el repositorio
    public List<Movimiento> getMovimientosByCuentaId(Long cuentaId) {
        return movimientoRepository.findByCuentaId(cuentaId); // Asegúrate de que este método esté en el repositorio
    }

    public Movimiento getMovimientoById(Long id) {
        return movimientoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movimiento no encontrado con id: " + id));
    }

    public Movimiento updateMovimiento(Long id, Movimiento movimientoDetails) {
        Movimiento movimiento = movimientoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movimiento no encontrado con id: " + id));

        movimiento.setFecha(movimientoDetails.getFecha());
        movimiento.setTipoMovimiento(movimientoDetails.getTipoMovimiento());
        movimiento.setValor(movimientoDetails.getValor());
        movimiento.setSaldo(movimientoDetails.getSaldo());
        movimiento.setCuenta(movimientoDetails.getCuenta());

        return movimientoRepository.save(movimiento);
    }

    public void deleteMovimiento(Long id) {
        Movimiento movimiento = movimientoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movimiento no encontrado con id: " + id));
        movimientoRepository.delete(movimiento);
    }

    public List<Movimiento> getMovimientosByClienteIdAndFechaRange(Long id, LocalDateTime startDate, LocalDateTime endDate) {
        return movimientoRepository.findByCuentaClienteIdAndFechaBetween(id, startDate, endDate);
    }

    public List<Movimiento> getAllMovimientos() {
        return movimientoRepository.findAll();
    }
}
