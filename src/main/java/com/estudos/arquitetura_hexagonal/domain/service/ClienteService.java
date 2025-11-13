package com.estudos.arquitetura_hexagonal.domain.service;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.estudos.arquitetura_hexagonal.domain.model.Cliente;
import com.estudos.arquitetura_hexagonal.domain.repository.ClienteRepository;

@Service
public class ClienteService {
	
	private static final Logger log = LogManager.getLogger(ClienteService.class);
	
	ClienteRepository repository;
	
	public ClienteService(ClienteRepository repository) {
		this.repository= repository;
	}
	
	public Cliente salvarCliente(Cliente cliente) {
		log.info("Salvando cliente: {}", cliente.getName());
		return repository.salvarCliente(cliente);
	}
	
	public List<Cliente> listarClientes() {
		log.info("Listando todos os clientes");
		return repository.listarClientes();
	}
	
	public void deletarCliente(Long id) {
		log.info("Deletando cliente com ID {}", id);
		repository.deletarCliente(id);
	}
	
}
