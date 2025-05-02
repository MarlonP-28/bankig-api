package com.example.bankingapi.repository;

import com.example.bankingapi.model.Cliente;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ClienteRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    public void whenFindByClienteId_thenReturnCliente() {
        // Given
        Cliente cliente = new Cliente();
        cliente.setNombre("Test Cliente");
        cliente.setClienteId(123L);
        cliente.setContraseña("password");
        cliente.setGenero("Masculino");
        cliente.setEdad(30);
        cliente.setIdentificacion("1234567890");
        cliente.setDireccion("Test Address");
        cliente.setTelefono("123-456-7890");
        entityManager.persistAndFlush(cliente);

        // When
        Cliente foundCliente = clienteRepository.findByClienteId(cliente.getClienteId()).orElse(null);

        // Then
        assertThat(foundCliente).isNotNull();
        assertThat(foundCliente.getNombre()).isEqualTo(cliente.getNombre());
    }

    @Test
    public void whenFindByIdentificacion_thenReturnCliente() {
        // Given
        Cliente cliente = new Cliente();
        cliente.setNombre("Test Cliente");
        cliente.setClienteId(123L);
        cliente.setContraseña("password");
        cliente.setGenero("Masculino");
        cliente.setEdad(30);
        cliente.setIdentificacion("1234567890");
        cliente.setDireccion("Test Address");
        cliente.setTelefono("123-456-7890");
        entityManager.persistAndFlush(cliente);

        // When
        Cliente foundCliente = clienteRepository.findByIdentificacion("1234567890").orElse(null);

        // Then
        assertThat(foundCliente).isNotNull();
        assertThat(foundCliente.getClienteId()).isEqualTo(cliente.getClienteId());
    }
}