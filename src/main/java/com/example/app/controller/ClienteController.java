package com.example.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @ResponseStatus(HttpStatus.OK)
    public Page<Cliente> findAll(RSQLParam q, Pageable pageable){
        return clienteService.findAll(q, pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Cliente>> findById(@PathVariable Long id){
        return ResponseEntity.ok(clienteService.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Cliente> insert(@RequestBody Cliente cliente){
        return ResponseEntity.ok(clienteService.insert(cliente));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Cliente> update(@RequestBody Cliente cliente, @PathVariable Long id){
        return ResponseEntity.ok(clienteService.update(cliente, id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        clienteService.delete(id);
    }
}
