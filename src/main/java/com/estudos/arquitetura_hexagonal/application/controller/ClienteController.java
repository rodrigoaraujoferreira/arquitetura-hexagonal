package com.estudos.arquitetura_hexagonal.application.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudos.arquitetura_hexagonal.application.dto.ClienteCreateDTO;
import com.estudos.arquitetura_hexagonal.application.dto.ClienteResponseDTO;
import com.estudos.arquitetura_hexagonal.domain.model.Cliente;
import com.estudos.arquitetura_hexagonal.domain.service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

	
	private ClienteService service;
	
	public ClienteController(ClienteService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<ClienteResponseDTO> listar() {
		return service.listarClientes().stream()
				.map(c -> new ClienteResponseDTO(c.getId(), c.getName(), c.getEmail()))
				.toList();
	}
	
	@PostMapping
	public ResponseEntity<ClienteResponseDTO> criar(@RequestBody ClienteCreateDTO dto) {
		Cliente cliente = new Cliente();
		cliente.setName(dto.name());
		cliente.setEmail(dto.email());
		Cliente c = service.salvarCliente(cliente);
		ClienteResponseDTO responseDTO = new ClienteResponseDTO(c.getId(), c.getName(), c.getEmail());
		return ResponseEntity.ok(responseDTO);
	}
	
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletarCliente(id); 
        return ResponseEntity.noContent().build();
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
