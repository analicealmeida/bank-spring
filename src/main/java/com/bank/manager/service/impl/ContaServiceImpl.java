package com.bank.manager.service.impl;

import com.bank.manager.dto.ContaRequestDTO;
import com.bank.manager.exception.*;
import com.bank.manager.model.*;
import com.bank.manager.repository.AgenciaRepository;
import com.bank.manager.repository.ContaRepository;
import com.bank.manager.service.AgenciaService;
import com.bank.manager.service.ClienteService;
import com.bank.manager.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ContaServiceImpl implements ContaService { //regras de negocio. Service conversa com repository.

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private AgenciaService agenciaService;

    @Autowired
    private ClienteService clienteService;

    @Override
    public void add(ContaRequestDTO contaDTO) {
        if(contaDTO == null){
            throw new EntidadeNulaException("Conta é nula");
        }
        if(contaDTO.numeroConta() == null || contaDTO.numeroConta().trim().isEmpty()){
            throw new NomeObrigatorioException("Número da conta é obrigatória");
        }

        if(contaDTO.idAgencia() == null){
            throw new EntidadeNulaException("Agência não encontrada");
        }
        Agencia agencia = agenciaService.getById(contaDTO.idAgencia());
        Cliente cliente = clienteService.getById(contaDTO.idCliente());

        if(cliente == null){
            throw new EntidadeNulaException("Cliente não encontrado");
        }

        if(contaDTO.saldo() == null || contaDTO.saldo().equals(new BigDecimal(0))){
            throw new RuntimeException("saldo é obrigatório");
        }


        Conta conta = null;
        if(contaDTO.tipoConta() == null || contaDTO.tipoConta().equalsIgnoreCase("Corrente")) {
            conta = new ContaCorrente(contaDTO.chequeEspecial(), contaDTO.taxaMensal()); //instancia e construtor


        }else{
            if(contaDTO.taxaRendimento() == null || contaDTO.taxaRendimento().equals(new BigDecimal(0))){
                throw new RuntimeException("taxa de rendimento não pode ser 0 ou nula");

            }


            conta = new ContaPoupanca(contaDTO.taxaRendimento());

        }

        conta.setNumeroConta(contaDTO.numeroConta().trim());
        conta.setAgencia(agencia);
        conta.setCliente(cliente);
        conta.setStatusConta(true);
        conta.setSaldo(contaDTO.saldo());

        contaRepository.save(conta);

    }

    @Override
    public List<Conta> findAll() {
        List<Conta> contas = contaRepository.findAll();

        if(contas.isEmpty()){
            throw new ListaEntidadeVaziaException("Contas não cadastradas");
        }
        return contaRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        if(id == null){
            throw new IdInvalidoException("Id não pode ser nulo");
        }

        boolean existe = contaRepository.existsById(id);

        if (!existe) {
            throw new ContaInexistenteException("Conta não encontrada");
        }

        contaRepository.deleteById(id);

    }

    @Override
    public void update(Long id, ContaRequestDTO contaDTO) {
        if(id == null) {
            throw new IdInvalidoException("Conta não existe");
        }

        boolean contaExiste = contaRepository.existsById(id);

        if(!contaExiste) {
            throw new ContaInexistenteException("Conta não encontrada");
        }

        if(contaDTO.numeroConta().isEmpty() || contaDTO.numeroConta() == null ){
            throw new RuntimeException("Numero da conta é obrigatorio");
        }




        Conta contaExistente = contaRepository.findById(id).get();

        //contaExistente.mapperDTO();

        contaRepository.save(contaExistente);
    }

    @Override
    public Optional<Conta>getById(Long id) {
        if(id == null){
            throw new IdInvalidoException("Id não pode ser nulo");
        }

        return contaRepository.findById(id);

    }

    @Override
    public List<Conta> findByClienteCpf(String cpf) {
        return contaRepository.findByClienteCpf(cpf);
    }


}


