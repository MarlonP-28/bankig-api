package com.example.bankingapi.repository;

import com.example.bankingapi.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
    List<Cuenta> findByClienteId(Long id);
    Optional<Cuenta> findByNumeroCuenta(String numeroCuenta);
}