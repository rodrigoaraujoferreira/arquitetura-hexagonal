package com.estudos.arquitetura_hexagonal.infra.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.estudos.arquitetura_hexagonal.domain.model.Cliente;
import com.estudos.arquitetura_hexagonal.domain.repository.ClienteRepository;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository{
	
	private final SpringDataClienteRepository jpa;
	
	public ClienteRepositoryImpl(SpringDataClienteRepository jpa) {
		this.jpa = jpa;
	}

	@Override
	public Cliente salvarCliente(Cliente cliente) {
		ClienteEntity entity = new ClienteEntity();
		entity.setNome(cliente.getName());
		entity.setEmail(cliente.getEmail());
		entity = jpa.save(entity);
		
		return new Cliente(entity.getId(), entity.getNome(), entity.getEmail());
	}

    @Override
    public List<Cliente> listarClientes() {
        return jpa.findAll().stream()
                  .map(e -> new Cliente(e.getId(), e.getNome(), e.getEmail()))
                  .collect(Collectors.toList());
    }

    @Override
    public void deletarCliente(Long id) {
        jpa.deleteById(id);
    }

}
