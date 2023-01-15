package com.example.app.service;

import com.example.app.domain.Cliente;
import com.example.app.repository.ClienteRepository;
import com.example.app.service.exception.ValueAlreadyExistsException;
import com.example.core.persistence.datafilter.RSQLParam;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClienteService {
        
    private final ClienteRepository clienteRepository;

    public Page<Cliente> findAll(RSQLParam q, Pageable pageable){
        return clienteRepository.findAll(q.getSpecification(), pageable);
    }

    public Optional<Cliente> findById(Long id){
        clienteRepository.findById(id).orElseThrow( () -> 
            new EntityNotFoundException("Entidade id="+id+" não encontrada")
        );
        return clienteRepository.findById(id);
    }

    public Cliente insert(Cliente cliente){
        Boolean existsClienteByCpf = clienteRepository.existsClienteByCpf(cliente.getCpf());
        Boolean existsClienteByEmail = clienteRepository.existsClienteByEmail(cliente.getEmail());
        if (existsClienteByCpf || existsClienteByEmail)
            throw new ValueAlreadyExistsException("O valor já existe no banco de dados");
        return clienteRepository.save(cliente);
    }

    public Cliente update(Cliente cliente, Long id){
        if(!clienteRepository.existsById(id)) throw new 
            EntityNotFoundException("Entidade id="+id+" não encontrada");
        return clienteRepository.save(cliente);
    }

    public void delete(Long id){
        if(!clienteRepository.existsById(id)) throw new 
            EntityNotFoundException("Entidade id="+id+" não encontrada");
        clienteRepository.deleteById(id);
    }


}
