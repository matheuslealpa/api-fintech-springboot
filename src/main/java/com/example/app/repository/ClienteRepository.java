package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.example.app.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>, 
                                           JpaSpecificationExecutor<Cliente> {
    Boolean existsClienteByCpf(String cpf);
    Boolean existsClienteByEmail(String email);
}
