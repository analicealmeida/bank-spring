package com.bank.manager.service.impl;

import com.bank.manager.model.Cliente;
import com.bank.manager.repository.ClienteRepository;
import com.bank.manager.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClienteServiceImpl implements ClienteService {  //TODO VALIDAÇAO

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public void add(Cliente cliente) { //TODO VALIDAR
        if(cliente == null){
            throw new RuntimeException("Cliente não pode ser nulo");
        }
        if(cliente.getNome() == null || cliente.getNome().trim().isEmpty()){
            throw new RuntimeException("Nome de cliente é obrigatório");
        }
        if(cliente.getCpf() == null){
            throw new RuntimeException("Cpf não pode ser nulo");
        }

        if(cliente.getCpf().trim().isEmpty()){
            throw new RuntimeException("CPF não pode ser vazio");
        }

        if(cliente.getCpf().trim().length() != 11){
            throw new RuntimeException("CPF precisa ter 11 digitos inteiros");  //TODO ACEITAR APENAS NUMERO
            }

        boolean cpfExiste = clienteRepository.existsByCPF(cliente.getCpf().trim());

        if(cpfExiste){
            throw new RuntimeException("CPF ja existe no banco de dados");
        }

        clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> findAll() {  //TODO VALIDAR

        List<Cliente> lista = clienteRepository.findAll();

        if(lista.isEmpty()){
            throw new RuntimeException("Não há clientes cadastrados");
        }
        return clienteRepository.findAll();
    }

    @Override
    public void delete(Long id) { //TODO VALIDAR

        if(id == null){
            throw new RuntimeException("id não pode ser nulo");
        }

        boolean clienteExiste = clienteRepository.existsById(id);

        if(!clienteExiste){
            throw new RuntimeException("Cliente não encontrado");
        }

        clienteRepository.deleteById(id);
    }

    @Override
    public void update(Long id, Cliente cliente) { //TODO VALIDAR *****************************************
        if(id == null){
            throw new RuntimeException("Id não pode ser nulo");
        }

        boolean clienteExiste = clienteRepository.existsById(id);

        if(!clienteExiste) {
            throw new RuntimeException("Cliente não encontrado");
        }

        Cliente clienteExistente = clienteRepository.findById(id).get();

        clienteExistente.mapperDTO(cliente);

        clienteRepository.save(clienteExistente);

    }

    @Override
    public Optional<Cliente> getById(Long id) { //TODO VALIDAR
       if(id == null){
           throw new RuntimeException("Id não pode ser nulo");
       }

        return clienteRepository.findById(id);

    }
}
