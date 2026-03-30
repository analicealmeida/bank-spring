package com.bank.manager.model;

import com.bank.manager.dto.AgenciaRequestDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Agencia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String estado;
    private String nomeAgencia;

    public Agencia(){

    }
    public Agencia(Long id, String estado, String nomeAgencia){
        this.id =id;
        this.estado = estado;
        this.nomeAgencia=nomeAgencia;
    }

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
