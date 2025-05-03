package com.example.bankingapi.service;

import com.example.bankingapi.model.Cliente;
import com.example.bankingapi.repository.ClienteRepository;
import com.example.bankingapi.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public Cliente getClienteById(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con id: " + id));
    }

    public Cliente createCliente(Cliente cliente) {
        if (clienteRepository.findByIdentificacion(cliente.getIdentificacion()).isPresent()) {
            throw new IllegalArgumentException("Cliente con identificacion " + cliente.getIdentificacion() + " ya existe");
        }
        return clienteRepository.save(cliente);
    }

    public Cliente updateCliente(Long id, Cliente clienteDetails) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con id: " + id));

        cliente.setNombre(clienteDetails.getNombre());
        cliente.setGenero(clienteDetails.getGenero());
        cliente.setEdad(clienteDetails.getEdad());
        cliente.setDireccion(clienteDetails.getDireccion());
        cliente.setTelefono(clienteDetails.getTelefono());
        cliente.setContraseña(clienteDetails.getContraseña());
        cliente.setEstado(clienteDetails.isEstado());

        return clienteRepository.save(cliente);
    }

    public void deleteCliente(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con id: " + id));
        clienteRepository.delete(cliente);
    }

    public Cliente getClienteByClienteId(Long clienteId) {
        return clienteRepository.findByClienteId(clienteId)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con clienteId: " + clienteId));
    }
}