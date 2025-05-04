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
        // Verificar si el cliente ya existe
        if (clienteRepository.findByIdentificacion(cliente.getIdentificacion()).isPresent()) {
            throw new IllegalArgumentException("Cliente con identificación " + cliente.getIdentificacion() + " ya existe");
        }
        // Crear el nuevo cliente
        return clienteRepository.save(cliente);
    }

    public Cliente updateCliente(Long id, Cliente clienteDetails) {
        // Obtener el cliente existente
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con id: " + id));

        // Actualizar solo si los valores cambian
        if (!cliente.getNombre().equals(clienteDetails.getNombre())) {
            cliente.setNombre(clienteDetails.getNombre());
        }
        if (!cliente.getGenero().equals(clienteDetails.getGenero())) {
            cliente.setGenero(clienteDetails.getGenero());
        }
        if (cliente.getEdad() != clienteDetails.getEdad()) {
            cliente.setEdad(clienteDetails.getEdad());
        }
        if (!cliente.getDireccion().equals(clienteDetails.getDireccion())) {
            cliente.setDireccion(clienteDetails.getDireccion());
        }
        if (!cliente.getTelefono().equals(clienteDetails.getTelefono())) {
            cliente.setTelefono(clienteDetails.getTelefono());
        }
        if (!cliente.getContrasena().equals(clienteDetails.getContrasena())) {
            cliente.setContrasena(clienteDetails.getContrasena());
        }
        if (cliente.isEstado() != clienteDetails.isEstado()) {
            cliente.setEstado(clienteDetails.isEstado());
        }

        // Guardar los cambios
        return clienteRepository.save(cliente);
    }

    public void deleteCliente(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con id: " + id));
        clienteRepository.delete(cliente);
    }

    public Cliente getClienteByClienteId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con clienteId: " + id));
    }
}
