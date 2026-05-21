package com.bank.manager.security;

import com.bank.manager.service.impl.ClienteServiceImpl;
import com.bank.manager.service.impl.FuncionarioServiceImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService { //novo************* //encontra o usuário

    private final ClienteServiceImpl clienteService;
    private final FuncionarioServiceImpl funcionarioService;

    public CustomUserDetailsService(ClienteServiceImpl clienteService,
                                    FuncionarioServiceImpl funcionarioService) {
        this.clienteService = clienteService;
        this.funcionarioService = funcionarioService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {

        if (clienteService.existePorUsername(username)) {
            return clienteService.loadUserByUsername(username);
        }

        if (funcionarioService.existePorUsername(username)) {
            return funcionarioService.loadUserByUsername(username);
        }

        throw new UsernameNotFoundException("Usuário não encontrado");
    }
}