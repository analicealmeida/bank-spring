package com.bank.manager.model;

import com.bank.manager.dto.AgenciaRequestDTO;
import com.bank.manager.dto.ContaRequestDTO;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.cglib.core.Local;

import java.math.BigDecimal;
import java.time.LocalDate;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_conta",discriminatorType = DiscriminatorType.STRING)
public abstract class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String numeroConta;
    @ManyToOne
    @JoinColumn(name = "agencia_id",referencedColumnName = "id")
    private Agencia agencia;
    private BigDecimal saldo;
    private LocalDate dataAbertura;
    private boolean statusConta;
    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Conta() {

    }
    public Conta(String numeroConta, Agencia agencia, BigDecimal saldo, LocalDate dataAbertura, boolean statusConta){
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo;
        this.dataAbertura = dataAbertura;
        this.statusConta = statusConta;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public boolean isStatusConta() {
        return statusConta;
    }

    public void setStatusConta(boolean statusConta) {
        this.statusConta = statusConta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public void mapperDTO(ContaRequestDTO conta) {   //estudar mapper
        this.numeroConta = conta.numeroConta();
        this.agencia = conta.agencia();

    }
}