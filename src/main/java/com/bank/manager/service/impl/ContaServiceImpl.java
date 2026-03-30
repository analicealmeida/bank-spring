package com.bank.manager.service.impl;

import com.bank.manager.model.Agencia;
import com.bank.manager.model.Conta;
import com.bank.manager.repository.AgenciaRepository;
import com.bank.manager.repository.ContaRepository;
import com.bank.manager.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContaServiceImpl implements ContaService {

    @Autowired
    private ContaRepository contaRepository;

    @Override
    public void add(Conta conta) { //TODO VALIDAR
        if(conta == null){
            throw new RuntimeException("Conta é nula");
        }
        if(conta.getNumeroConta() == null || conta.getNumeroConta().trim().isEmpty()){
            throw new RuntimeException("Número da conta é obrigatória");
        }
        if(conta.getAgencia() == null){
            throw new RuntimeException("Nome da agência é obrigatória");
        }

        boolean contaExiste = contaRepository.existsByNumeroContaEAgencia(conta.getNumeroConta().trim(),
        conta.getAgencia());

        if(contaExiste){
            throw new RuntimeException("Conta ja existe no banco de dados");
        }

        contaRepository.save(conta);
    }

    @Override
    public List<Conta> findAll() { //TODO VALIDAR
        List<Conta> contas = contaRepository.findAll();

        if(contas.isEmpty()){
            throw new RuntimeException("Contas não cadastradas");
        }
        return contaRepository.findAll();
    }

    @Override
    public void delete(Long id) { //TODO VALIDAR
        if(id == null){
            throw new RuntimeException("Id não pode ser nulo");
        }

        boolean existe = contaRepository.existsById(id);

        if (!existe) {
            throw new RuntimeException("Conta não encontrada");
        }

        contaRepository.deleteById(id);

    }

    @Override
    public void update(Long id, Conta conta) { //TODO VALIDAR ***********************************************
        if(id == null) {
            throw new RuntimeException("Conta não existe");
        }

        boolean contaExiste = contaRepository.existsById(id);

        if(!contaExiste) {
            throw new RuntimeException("Conta não encontrada");
        }

        Conta contaExistente = contaRepository.findById(id).get();

        contaExistente.mapperDTO(conta);

        contaRepository.save(contaExistente);
    }

    @Override
    public Optional<Conta>getById(Long id) { //TODO VALIDAR
        if(id == null){
            throw new RuntimeException("Id não pode ser nulo");
        }

        return contaRepository.findById(id);

    }

    }


