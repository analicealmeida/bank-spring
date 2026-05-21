package com.bank.manager.service;

import com.bank.manager.dto.LoginDTO;
import com.bank.manager.enums.CargoFuncionario;
import com.bank.manager.model.Agencia;
import com.bank.manager.model.Conta;
import com.bank.manager.model.Funcionario;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface FuncionarioService {
    public void add(Funcionario funcionario);
    public List<Funcionario> findAll();
    public void delete(Long id);
    public void update(Long id, Funcionario funcionario);
    public Optional<Funcionario> getById(Long id);
    public String login(LoginDTO loginDTO);
    public UserDetails loadUserByUsername(String username);
    public boolean existePorUsername(String username);
    public String getRole(CargoFuncionario cargo);
    public void changePassword (String password, String cpf);

}
