package com.bank.manager.repository;

import com.bank.manager.model.Cliente;
import com.bank.manager.model.ContaPoupanca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaPoupancaRepository extends JpaRepository<ContaPoupanca, Long> {
}
