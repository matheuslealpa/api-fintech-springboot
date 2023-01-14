package com.example.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.domain.Cliente;
import com.example.app.service.ClienteService;
import com.example.core.persistence.datafilter.RSQLParam;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/clientes")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping
    public Page<Cliente> findAll(RSQLParam q, Pageable pageable){
        return clienteService.findAll(q, pageable);
    }

    @GetMapping("/id")
    public ResponseEntity<Optional<Cliente>> findById(@PathVariable Long id){
        return ResponseEntity.ok(clienteService.findById(id));
    }
    
}
