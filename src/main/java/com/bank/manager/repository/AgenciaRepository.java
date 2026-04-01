package com.bank.manager.repository;

import com.bank.manager.model.Agencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgenciaRepository extends JpaRepository<Agencia, Long> { //camada que conversa com o banco usando JPA + Hibernate.

    boolean existsByNomeAgenciaAndEstado(String nomeAgencia, String estado);
}
