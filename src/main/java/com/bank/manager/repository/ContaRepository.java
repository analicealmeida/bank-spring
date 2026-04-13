package com.bank.manager.repository;

import com.bank.manager.model.Agencia;
import com.bank.manager.model.Cliente;
import com.bank.manager.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {  //camada que conversa com o banco usando JPA + Hibernate.

    boolean existsByNumeroContaAndAgencia(String numeroConta, Agencia agencia);

    @Query(value = "SELECT C.* FROM conta C INNER JOIN cliente CLI on C.cliente_id = CLI.id WHERE CLI.cpf = :cpf", nativeQuery = true)
    List<Conta> findByClienteCpf(String cpf);

    //List<Conta> findByClienteCpf(String cpf);
}
