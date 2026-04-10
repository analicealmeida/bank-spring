package com.bank.manager.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@DiscriminatorValue("conta_poupanca")
public class ContaPoupanca extends Conta{ //Entity = Model, aqui criamos as classes que representam as tabelas do banco.

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
