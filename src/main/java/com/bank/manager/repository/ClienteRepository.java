package com.bank.manager.repository;

import com.bank.manager.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> { //camada que conversa com o banco usando JPA + Hibernate.

    boolean existsByCpf(String cpf);

    boolean existsById(Long id);

    Optional<Cliente> findByUsername(String username);
    @Query(value = "SELECT nome FROM cliente",nativeQuery = true)
    List<String> getAllNames();

    Optional<Cliente> findByCpf(String cpf);


    boolean existsByUsername(String username);
}
