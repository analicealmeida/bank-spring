package com.bank.manager.model;

import com.bank.manager.dto.AgenciaRequestDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity  //notação Entity diz que essa classe representa uma tabela no banco
public class Agencia {    //Entity = Model, aqui criamos as classes que representam as tabelas do banco.
    @Id //identificador, obrigatorio para todas as entity, marca o atributo abaixo como chave primaria
    @GeneratedValue(strategy = GenerationType.AUTO) //significa, o banco vai gerar o id automaticamente.
    private Long id;  //coluna na tabela estará como id BIGINT
    private String estado; //estado VARCHAR
    private String nomeAgencia; //nome_agencia VARCHAR

    //construtor vazio, entidades JPA (classes com @Entity) precisam de um construtor vazio - Boas praticas
    public Agencia(){

    }
    //construtor completo
    public Agencia(Long id, String estado, String nomeAgencia){
        this.id =id;
        this.estado = estado;
        this.nomeAgencia=nomeAgencia;
    }

    //getters, permite acessar valor do atributo. Spring usa getters para: converter objeto em JSON.
    //getters, permite alterar valor
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNomeAgencia() {
        return nomeAgencia;
    }

    public void setNomeAgencia(String nomeAgencia) {
        this.nomeAgencia = nomeAgencia;
    }

    public void mapperDTO(AgenciaRequestDTO agencia) {   //estudar mapper
        this.nomeAgencia = agencia.nomeAgencia();
        this.estado = agencia.estado();

    }
}
