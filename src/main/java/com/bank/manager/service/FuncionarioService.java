package com.bank.manager.service;

import com.bank.manager.model.Agencia;
import com.bank.manager.model.Conta;
import com.bank.manager.model.Funcionario;

import java.util.List;
import java.util.Optional;

public interface FuncionarioService {
    public void add(Funcionario funcionario);
    public List<Funcionario> findAll();
    public void delete(Long id);
    public void update(Long id, Funcionario funcionario);
    public Optional<Funcionario> getById(Long id);

}
