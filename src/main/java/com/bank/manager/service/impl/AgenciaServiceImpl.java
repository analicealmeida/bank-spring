package com.bank.manager.service.impl;

import com.bank.manager.dto.AgenciaRequestDTO;
import com.bank.manager.model.Agencia;
import com.bank.manager.repository.AgenciaRepository;
import com.bank.manager.service.AgenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgenciaServiceImpl implements AgenciaService { //regras de negocio. Service conversa com repository.

    @Autowired
    private AgenciaRepository agenciaRepository;

    @Override
    public void add(Agencia agencia) {
        //validando se o objeto(agencia) e os dados dentro desse objetos(nome/estado) estão preenchidos
        if (agencia == null) {
            throw new RuntimeException("Agência não pode ser nula");
        }
        //se o nome agencia estiver nulo, ou com espaços desnecessários e vazio lance uma exceçao
            if (agencia.getNomeAgencia() == null || agencia.getNomeAgencia().trim().isEmpty()) {
                throw new RuntimeException("Nome da agência é obrigatório");
            }
                //se o estado estiver nulo(null) ou com espaços desnecessários(trim) e vazio(empty) lance exceçao
                if (agencia.getEstado() == null || agencia.getEstado().trim().isEmpty()) {
                    throw new RuntimeException("Estado é obrigatório");
                }

                    //validando se ja existe agencia no banco de dados. para nao haver duplicidade.
                    //booleano receberá o metodo para a verificação das tabelas Nomeagencia e estado da camada repository
                    //vai comparar retirando os espaços, se true lance exceção
                    boolean jaExiste = agenciaRepository
                            .existsByNomeAgenciaAndEstado(
                                    agencia.getNomeAgencia().trim(), //TODO ACEITAR UPPER CASE E LOW CASE
                                    agencia.getEstado().trim()
                            );
                    if (jaExiste) {
                        throw new RuntimeException("Já existe uma agência com esse nome nesse estado");
                    }
                    agenciaRepository.save(agencia);
                }

    @Override
    public List<Agencia> findAll() {
        //buscar lista, verificar se esta vazia [ ], lancar exceção se estiver
        List<Agencia> lista = agenciaRepository.findAll();

        if (lista.isEmpty()) {
            throw new RuntimeException("Nenhuma agência cadastrada");
        }
        return agenciaRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        if(id == null){  //validando id
            throw new RuntimeException("Id não pode ser nulo");
        }
        //verificando se a agencia existe para ser deletada
        boolean existe = agenciaRepository.existsById(id);

        if (!existe) {
            throw new RuntimeException("Agência não encontrada");
        }

        agenciaRepository.deleteById(id);
    }

    @Override
    public void update(Long id, AgenciaRequestDTO agencia) {
        if(id == null) { //verificando se agência não é nula
            throw new RuntimeException("Agencia não existe");
        }
        //verificando se agencia existe antes de atualizar
        boolean agenciaExiste = agenciaRepository.existsById(id);

        if(!agenciaExiste) {
            throw new RuntimeException("Agencia não encontrada");
        }

        Agencia agenciaExistente = agenciaRepository.findById(id).get(); //busque no banco o id solicitado

        agenciaExistente.mapperDTO(agencia); //Coloca o nome novo dentro da agência antiga

        agenciaRepository.save(agenciaExistente); //salve nno banco

    }

    @Override
    public Optional<Agencia> getById(Long id) {
        if(id == null){ //verificando de id é valido
            throw new RuntimeException("Id não encontrado");
        }
        //verificando de id existe no banco de dados antes de retornar
        boolean idExistente = agenciaRepository.existsById(id);   //POR SER OPTIONAL FICA REDUNDANTE

        if(!idExistente){
            throw new RuntimeException("Id não encontrado");
        }

        return agenciaRepository.findById(id);
    }}

