package com.estudos.arquitetura_hexagonal.application.dto;

public record ClienteResponseDTO(
		Long id,
		String name,
		String email) {
}
