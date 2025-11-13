package com.estudos.arquitetura_hexagonal.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataClienteRepository extends JpaRepository<ClienteEntity, Long> {

}
