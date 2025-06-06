package com.example.bankingapi.repository;

import com.example.bankingapi.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findById(Long id);  // Ejemplo de una consulta personalizada
    Optional<Cliente> findByIdentificacion(String identificacion);
}