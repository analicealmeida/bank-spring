package com.bank.manager.service.impl;

import com.bank.manager.exception.*;
import com.bank.manager.model.Agencia;
import com.bank.manager.model.Conta;
import com.bank.manager.model.Funcionario;
import com.bank.manager.repository.ContaRepository;
import com.bank.manager.repository.FuncionarioRepository;
import com.bank.manager.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioServiceImpl implements FuncionarioService { //regras de negocio. Service conversa com repository.

    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Override
    public void add(Funcionario funcionario) {

        if(funcionario == null){
            throw new EntidadeNulaException("Funcionário não pode ser nulo");
        }
        if(funcionario.getNome() == null || funcionario.getNome().trim().isEmpty()){
            throw new NomeObrigatorioException("Nome de funcionario é obrigatório");
        }
        if(funcionario.getCpf() == null){
            throw new CpfInvalidoException("Cpf não pode ser nulo");
        }

        if(funcionario.getCpf().trim().isEmpty()){
            throw new CpfInvalidoException("CPF não pode ser vazio");
        }

        if(funcionario.getCpf().trim().length() != 11){
            throw new CpfInvalidoException("CPF precisa ter 11 digitos inteiros");  //TODO ACEITAR APENAS NUMERO
        }

        boolean cpfExiste = funcionarioRepository.existsByCpf(funcionario.getCpf().trim());

        if(cpfExiste){
            throw new CpfExistenteException("CPF ja existe no banco de dados");
        }

        funcionarioRepository.save(funcionario);

    }

    @Override
    public List<Funcionario> findAll() {
        List<Funcionario> funcionarios = funcionarioRepository.findAll();

        if(funcionarios.isEmpty()){
            throw new ListaEntidadeVaziaException("Funcionários não cadastrados");
        }
        return funcionarios;
    }

    @Override
    public void delete(Long id) {
        if(id == null){
            throw new IdInvalidoException("O id não pode ser nulo");
        }

        boolean funcionarioExiste = funcionarioRepository.existsById(id);

        if(!funcionarioExiste){
            throw new FuncionarioInexistenteException("Funcionário não encontrado");
        }

        funcionarioRepository.deleteById(id);
    }

    @Override
    public void update(Long id, Funcionario funcionario) {
        if(id == null) {
            throw new EntidadeNulaException("Funcionário não existe");
        }

        boolean Existe = funcionarioRepository.existsById(id);

        if(!Existe) {
            throw new FuncionarioInexistenteException("Funcionario não encontrado");
        }

        Funcionario funcionarioExistente = funcionarioRepository.findById(id).get();

        funcionarioExistente.mapperDTO(funcionario);

        funcionarioRepository.save(funcionarioExistente);
    }

    @Override
    public Optional<Funcionario> getById(Long id) {
        if(id == null){
            throw new IdInvalidoException("Id não pode ser nulo");
        }

        return funcionarioRepository.findById(id);
    }
}



