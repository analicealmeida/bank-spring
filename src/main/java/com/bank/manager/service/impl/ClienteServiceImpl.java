package com.bank.manager.service.impl;

import com.bank.manager.dto.LoginDTO;
import com.bank.manager.enums.Role;
import com.bank.manager.exception.*;
import com.bank.manager.model.Cliente;
import com.bank.manager.repository.ClienteRepository;
import com.bank.manager.security.JwtUtil;
import com.bank.manager.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.bank.manager.security.JwtUtil;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static com.bank.manager.enums.Role.CLIENTE;


@Service
public class ClienteServiceImpl implements ClienteService, UserDetailsService {  //regras de negocio. Service conversa com repository.

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private final JwtUtil jwtUtil;
    @Autowired
    private final PasswordEncoder passwordEncoder;



    public ClienteServiceImpl(JwtUtil jwtUtil, PasswordEncoder passwordEncoder, ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void add(Cliente cliente) {
        if(cliente == null){
            throw new EntidadeNulaException("Cliente não pode ser nulo");
        }
        if(cliente.getNome() == null || cliente.getNome().trim().isEmpty()){
            throw new NomeObrigatorioException("Nome de cliente é obrigatório");
        }
        if(cliente.getCpf() == null){
            throw new CpfInvalidoException("Cpf não pode ser nulo");
        }

        if(cliente.getCpf().trim().isEmpty()){
            throw new CpfInvalidoException("CPF não pode ser vazio");
        }

        if(cliente.getCpf().trim().length() != 11){
            throw new CpfInvalidoException("CPF precisa ter 11 digitos inteiros");
        }
        try{
            Long.parseLong(cliente.getCpf());
        }catch (NumberFormatException e){
            throw new CpfInvalidoException("Cpf válido apenas com numeros.");
        }

        boolean cpfExiste = clienteRepository.existsByCpf(cliente.getCpf().trim());


        if(cpfExiste){
            throw new CpfExistenteException("CPF ja existe no banco de dados");
        }

        cliente.setDataCadastro(LocalDate.now());

        cliente.setPassword(passwordEncoder.encode(cliente.getPassword()));
        cliente.setRole(CLIENTE); //tirei role.

        clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> findAll() {

        List<Cliente> lista = clienteRepository.findAll();

        if(lista.isEmpty()){
            throw new ListaEntidadeVaziaException("Não há clientes cadastrados");
        }
        return clienteRepository.findAll();
    }

    @Override
    public void delete(Long id) {

        if(id == null){
            throw new IdInvalidoException("id não pode ser nulo");
        }

        Cliente clienteExiste = this.getById(id);

        clienteRepository.deleteById(id);
    }

    @Override
    public void update(Long id, Cliente cliente) {
        if(id == null){
            throw new IdInvalidoException("Id não pode ser nulo");
        }
        Cliente clienteExistente = this.getById(id);

        clienteExistente.mapperDTO(cliente);

        clienteRepository.save(clienteExistente);

    }


    @Override
    public Cliente getById(Long id) {
        if (id == null) {
            throw new IdInvalidoException("Id não pode ser nulo");

        }
        Cliente c = getUser();

        return clienteRepository.findById(id).orElseThrow(() -> new ClienteInexistenteException());
    }

    @Override
    public Cliente getUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return (Cliente) ((UserDetails) principal);
        } else {
            return null;
        }
    }


    @Override
    public String login(LoginDTO loginDTO) { //NOVO
        Cliente cliente = clienteRepository
                .findByUsername(loginDTO.username())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        System.out.println("senha banco: " + cliente.getPassword());
        System.out.println("senha digitada: " + loginDTO.password());

        if (!passwordEncoder.matches(loginDTO.password(), cliente.getPassword())) {
            throw new RuntimeException("Senha inválida");
        }

        //return cliente;
        return jwtUtil.generateToken(cliente.getUsername());
    }

    @Override
    public List<String> getAllNames() {
        return clienteRepository.getAllNames();
    }

    @Override
    public Cliente findByCpf(String cpf) {
        return clienteRepository.findByCpf(cpf).orElseThrow(() -> new CpfInvalidoException("Não existe cliente com este CPF!"));
    }

    /*@Override
    public void cadastrarCliente(Cliente cliente) {
        //cliente.setRole(Role.ROLE_CLIENTE);
        //clienteRepository.save(cliente);
        cliente.setPassword(passwordEncoder.encode(cliente.getPassword()));
        cliente.setRole(Role.ROLE_CLIENTE);

        clienteRepository.save(cliente);
    }*/


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("LOGIN CHAMADO: " + username);
        return clienteRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
    }

    @Override
    public boolean existePorUsername(String username) {
        return clienteRepository.existsByUsername(username);
    }
}
