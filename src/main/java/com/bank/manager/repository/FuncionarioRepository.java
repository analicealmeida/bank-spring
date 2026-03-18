package com.bank.manager.repository;

import com.bank.manager.model.Cliente;
import com.bank.manager.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
