package com.bank.manager.model;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "cliente")
public class Cliente extends Pessoa {

    private LocalDate dataCadastro;
    private boolean investidor;
    private int score;

    public Cliente(){

    }

    public Cliente(LocalDate dataCadastro, boolean investidor, int score){
        this.dataCadastro = dataCadastro;
        this.investidor = investidor;
        this.score = score;
    }
    //precisa de um construtor com super?

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public boolean getInvestidor() {
        return investidor;
    }

    public void setInvestidor(boolean investidor) {
        this.investidor = investidor;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
