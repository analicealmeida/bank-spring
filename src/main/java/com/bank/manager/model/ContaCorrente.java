package com.bank.manager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "conta_corrente")
public class ContaCorrente extends Conta{

    private BigDecimal chequeEspecial;
    private BigDecimal taxaMensal;

    public ContaCorrente(){

    }
    public ContaCorrente(BigDecimal chequeEspecial, BigDecimal taxaMensal){
        this.chequeEspecial = chequeEspecial;
        this.taxaMensal = taxaMensal;
    }

    public BigDecimal getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(BigDecimal chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    public BigDecimal getTaxaMensal() {
        return taxaMensal;
    }

    public void setTaxaMensal(BigDecimal taxaMensal) {
        this.taxaMensal = taxaMensal;
    }
}
