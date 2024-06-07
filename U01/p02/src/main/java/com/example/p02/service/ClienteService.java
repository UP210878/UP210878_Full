package com.example.p02.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.p02.model.Cliente;
import com.example.p02.repository.ClienteRepository;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> getCliente(Long id) {
        return clienteRepository.findById(id);    }
    
    public List<Cliente> getOrdenado() {
        List<Cliente> listaClientes = clienteRepository.findAll();
        listaClientes.sort((cliente1, cliente2) -> cliente1.getNombre().compareTo(cliente2.getNombre()));
        return listaClientes;
    }

    public List<Cliente> getMayusculas() {
        List<Cliente> listaClientes = clienteRepository.findAll();
        listaClientes.forEach(cliente -> cliente.setNombre(cliente.getNombre().toUpperCase()));
        listaClientes.forEach(cliente -> cliente.setApellido(cliente.getApellido().toUpperCase()));
        return listaClientes;
    }
}
