package com.bank.manager.repository;

import com.bank.manager.model.Agencia;
import com.bank.manager.model.Cliente;
import com.bank.manager.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> { //camada que conversa com o banco usando JPA + Hibernate.

    boolean existsByCpf(String cpf);

    //Optional<Object> findByUsername(String username);
    Optional<Funcionario> findByUsername(String username);

    boolean existsByUsername(String username);

    Optional<Funcionario>findByCpf(String cpf);
}
