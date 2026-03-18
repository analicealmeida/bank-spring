package com.bank.manager.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "investimento")
public class Investimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal valorAplicado;
    private LocalDate dataAplicacao;
    private BigDecimal rentabilidade;
    //tipo do investimento

    public Investimento(){

    }
    public Investimento(Long id, BigDecimal valorAplicado, LocalDate dataAplicacao, BigDecimal rentabilidade){
        this.id = id;
        this.valorAplicado = valorAplicado;
        this.dataAplicacao = dataAplicacao;
        this.rentabilidade = rentabilidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValorAplicado() {
        return valorAplicado;
    }

    public void setValorAplicado(BigDecimal valorAplicado) {
        this.valorAplicado = valorAplicado;
    }

    public LocalDate getDataAplicacao() {
        return dataAplicacao;
    }

    public void setDataAplicacao(LocalDate dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }

    public BigDecimal getRentabilidade() {
        return rentabilidade;
    }

    public void setRentabilidade(BigDecimal rentabilidade) {
        this.rentabilidade = rentabilidade;
    }
}
