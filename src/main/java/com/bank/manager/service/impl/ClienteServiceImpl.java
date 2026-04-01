package com.bank.manager.service.impl;

import com.bank.manager.exception.ClienteInexistenteException;
import com.bank.manager.exception.CpfExistenteException;
import com.bank.manager.model.Cliente;
import com.bank.manager.repository.ClienteRepository;
import com.bank.manager.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class ClienteServiceImpl implements ClienteService {  //regras de negocio. Service conversa com repository.

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public void add(Cliente cliente) {
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
            throw new RuntimeException("CPF precisa ter 11 digitos inteiros");  //TODO ACEITAR APENAS NUMERO(converter
            }

        boolean cpfExiste = clienteRepository.existsByCpf(cliente.getCpf().trim());


        if(cpfExiste){
            throw new CpfExistenteException("CPF ja existe no banco de dados"); //TODO TRATAR MELHOR O ERRO.
        }

        cliente.setDataCadastro(LocalDate.now());
        clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> findAll() {

        List<Cliente> lista = clienteRepository.findAll();

        if(lista.isEmpty()){
            throw new RuntimeException("Não há clientes cadastrados");
        }
        return clienteRepository.findAll();
    }

    @Override
    public void delete(Long id) {

        if(id == null){
            throw new RuntimeException("id não pode ser nulo");
        }

        Cliente clienteExiste = this.getById(id);

        clienteRepository.deleteById(id);
    }

    @Override
    public void update(Long id, Cliente cliente) {
        if(id == null){
            throw new RuntimeException("Id não pode ser nulo");
        }

        Cliente clienteExistente = this.getById(id);

        clienteExistente.mapperDTO(cliente);

        clienteRepository.save(clienteExistente);

    }

    @Override
    public Cliente getById(Long id) {  //TRATADO****************
       if(id == null){
           throw new RuntimeException("Id não pode ser nulo");
       }

        return clienteRepository.findById(id).orElseThrow(()-> new ClienteInexistenteException());

    }
}
