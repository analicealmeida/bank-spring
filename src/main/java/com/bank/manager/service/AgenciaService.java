package com.bank.manager.service;

import com.bank.manager.dto.AgenciaRequestDTO;
import com.bank.manager.model.Agencia;

import java.util.List;
import java.util.Optional;

public interface AgenciaService {
    public void add(Agencia agencia);
    public List<Agencia> findAll();
    public void delete(Long id);
    public void update(Long id, AgenciaRequestDTO agencia);
    public Agencia getById(Long id);
}
