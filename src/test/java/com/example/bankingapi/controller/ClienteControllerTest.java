package com.example.bankingapi.controller;

import com.example.bankingapi.model.Cliente;
import com.example.bankingapi.service.ClienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebMvcTest(ClienteController.class)
public class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClienteService clienteService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getAllClientes_returnsOk() throws Exception {
        // Given
        List<Cliente> clientes = new ArrayList<>();
        Cliente cliente1 = new Cliente();
        cliente1.setClienteId(1L);
        cliente1.setNombre("Test Cliente 1");
        clientes.add(cliente1);

        when(clienteService.getAllClientes()).thenReturn(clientes);

        // When & Then
        mockMvc.perform(MockMvcRequestBuilders.get("/clientes")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].nombre").value("Test Cliente 1"));
    }

    @Test
    public void createCliente_returnsCreated() throws Exception {
        // Given
        Cliente clienteToCreate = new Cliente();
        clienteToCreate.setNombre("New Cliente");
        clienteToCreate.setContraseña("password");
        clienteToCreate.setGenero("Masculino");
        clienteToCreate.setEdad(25);
        clienteToCreate.setIdentificacion("1112223334");
        clienteToCreate.setDireccion("New Address");
        clienteToCreate.setTelefono("111-222-3333");

        Cliente createdCliente = new Cliente();
        createdCliente.setClienteId(2L);
        createdCliente.setNombre("New Cliente");

        when(clienteService.createCliente(any(Cliente.class))).thenReturn(createdCliente);

        // When & Then
        mockMvc.perform(MockMvcRequestBuilders.post("/clientes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(clienteToCreate)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.nombre").value("New Cliente"));
    }

    // Add more controller tests for update, delete, getById, etc.
}