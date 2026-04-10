package com.bank.manager.service;

import com.bank.manager.dto.ContaRequestDTO;
import com.bank.manager.model.Agencia;
import com.bank.manager.model.Conta;

import java.util.List;
import java.util.Optional;

public interface ContaService {
    public void add(ContaRequestDTO contaDTO);
    public List<Conta> findAll();
    public void delete(Long id);
    public void update(Long id, ContaRequestDTO conta);
    public Optional<Conta> getById(Long id);
}
