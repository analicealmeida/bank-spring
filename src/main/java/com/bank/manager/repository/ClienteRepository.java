package com.bank.manager.repository;

import com.bank.manager.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> { //camada que conversa com o banco usando JPA + Hibernate.

    boolean existsByCpf(String cpf);

    boolean existsById(Long id);

}
