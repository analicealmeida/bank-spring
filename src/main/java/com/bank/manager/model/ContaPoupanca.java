package com.bank.manager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "conta_poupanca")
public class ContaPoupanca extends Conta{

    private BigDecimal taxaRendimento;

    public ContaPoupanca(){

    }
    public ContaPoupanca(BigDecimal taxaRendimento){
        this.taxaRendimento = taxaRendimento;
    }

    public BigDecimal getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setTaxaRendimento(BigDecimal taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }
}
