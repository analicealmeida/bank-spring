package com.bank.manager.model;

import com.bank.manager.dto.AgenciaRequestDTO;
import com.bank.manager.dto.ClienteRequestDTO;
import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "cliente")
public class Cliente extends Pessoa { //Entity = Model, aqui criamos as classes que representam as tabelas do banco.

    private LocalDate dataCadastro;
    private boolean investidor;
    private int score;
    private String passwordCliente;
    private String username;//NOVO

    public Cliente(){

    }

    public Cliente(LocalDate dataCadastro, boolean investidor, int score, String passwordCliente, String username){
        this.dataCadastro = dataCadastro;
        this.investidor = investidor;
        this.score = score;
        this.passwordCliente = passwordCliente;
        this.username = username;
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

    public String getPasswordCliente() {
        return passwordCliente;
    }

    public void setPasswordCliente(String passwordCliente) {
        this.passwordCliente = passwordCliente;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void mapperDTO(Cliente cliente){
        this.setNome(cliente.getNome());
        this.setCpf(cliente.getCpf());
    }

    }

