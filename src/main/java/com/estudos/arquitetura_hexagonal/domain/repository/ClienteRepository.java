package com.estudos.arquitetura_hexagonal.domain.repository;

import java.util.List;

import com.estudos.arquitetura_hexagonal.domain.model.Cliente;

public interface ClienteRepository {
	Cliente salvarCliente(Cliente cliente);
	List<Cliente> listarClientes();
	void deletarCliente(Long id);
}
