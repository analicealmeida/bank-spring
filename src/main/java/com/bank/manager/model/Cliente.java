package com.bank.manager.model;

import com.bank.manager.dto.AgenciaRequestDTO;
import com.bank.manager.dto.ClienteRequestDTO;
import com.bank.manager.enums.Role;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente extends Pessoa implements UserDetails { //Entity = Model, aqui criamos as classes que representam as tabelas do banco.

    private LocalDate dataCadastro;
    private boolean investidor;
    private int score;

    public Cliente(){

    }

    public Cliente(Long id, String nome, String cpf, String telefone, String endereco, String username, String password, LocalDate dataCadastro, boolean investidor, int score){
       super(id, nome, cpf, telefone, endereco, username, password);
        this.dataCadastro = dataCadastro;
        this.investidor = investidor;
        this.score = score;

    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public boolean isInvestidor() {
        return investidor;
    }  //Para atributos boolean, o padrão correto é: isNomeDoCampo() (mais correto), getNomeDoCampo() (funciona, mas não é o ideal)

    public void setInvestidor(boolean investidor) {
        this.investidor = investidor;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void mapperDTO(Cliente cliente){
        this.setNome(cliente.getNome());
        this.setCpf(cliente.getCpf());
    }

    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getUsername();
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

