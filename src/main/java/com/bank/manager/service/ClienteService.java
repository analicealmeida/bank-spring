package com.bank.manager.service;

import com.bank.manager.dto.LoginDTO;
import com.bank.manager.model.Agencia;
import com.bank.manager.model.Cliente;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    public void add(Cliente cliente);
    public List<Cliente> findAll();
    public void delete(Long id);
    public void update(Long id, Cliente cliente);
    public Cliente getById(Long id);
    public String login(LoginDTO loginDTO);
    List<String> getAllNames();
    public Cliente findByCpf(String cpf);
    //public void cadastrarCliente(Cliente cliente);
    public UserDetails loadUserByUsername(String username);
}
