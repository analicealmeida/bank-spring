package com.bank.manager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "funcionario")
public class Funcionario extends Pessoa {

    private String matricula;
    private String cargo;
    private BigDecimal salario;

    public Funcionario(){

    }

    public Funcionario(String matricula, String cargo, BigDecimal salario){
        this.matricula = matricula;
        this.cargo = cargo;
        this.salario = salario;
    }
    //precisa de um construtor com super?

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }
}
