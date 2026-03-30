package com.bank.manager.repository;

import com.bank.manager.model.Agencia;
import com.bank.manager.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

    boolean existsByNumeroContaEAgencia(String numeroConta, Agencia agencia);
}
