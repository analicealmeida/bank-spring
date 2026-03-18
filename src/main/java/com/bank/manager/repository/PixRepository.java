package com.bank.manager.repository;

import com.bank.manager.model.Cliente;
import com.bank.manager.model.Pix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PixRepository extends JpaRepository<Pix, Long> {
}
