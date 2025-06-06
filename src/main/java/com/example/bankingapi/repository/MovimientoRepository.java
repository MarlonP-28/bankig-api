package com.example.bankingapi.repository;

import com.example.bankingapi.model.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {
    List<Movimiento> findByCuentaId(Long id);
    List<Movimiento> findByCuentaClienteIdAndFechaBetween(Long id, LocalDateTime startDate, LocalDateTime endDate);
}
