package com.bank.manager.model;

import com.bank.manager.enums.CargoFuncionario;
import com.bank.manager.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "funcionario")
public class Funcionario extends Pessoa implements UserDetails { //Entity = Model, aqui criamos as classes que representam as tabelas do banco.

    private String matricula;
    @Enumerated(EnumType.STRING)
    private CargoFuncionario cargo;  //NOVO ********************
    private BigDecimal salario;

    public Funcionario() {

    }

    public Funcionario(String matricula, CargoFuncionario cargo, BigDecimal salario) {
        this.matricula = matricula;
        this.cargo = cargo;
        this.salario = salario;
    }


    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public CargoFuncionario getCargo() {
        return cargo;
    }

    public void setCargo(CargoFuncionario cargo) {
        this.cargo = cargo;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public void mapperDTO(Funcionario funcionario) {
        this.setCpf(funcionario.getCpf());
        this.setNome(funcionario.getNome());
        this.setSalario(funcionario.getSalario());
        this.setUsername(funcionario.getUsername());
    }

    @Enumerated(EnumType.STRING)
    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("FUNCIONARIO"),
                new SimpleGrantedAuthority("ROLE_" + this.cargo));

    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
