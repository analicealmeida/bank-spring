package com.bank.manager.model;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@Entity indica que a classe será persistida no banco, e @Inheritance(strategy = JOINED)
// define que a hierarquia de herança será mapeada em tabelas separadas relacionadas por chave primária.
public abstract class Pessoa {
    //Classe abstrata funciona como um aviso para o programador: não use essa classe diretamente, use as filhas
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;
    @Column(unique = true)
    private String cpf;
    private String telefone;
    private String endereco;

    public Pessoa(){

    }
    public Pessoa(Long id, String nome, String cpf, String telefone, String endereco){
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
