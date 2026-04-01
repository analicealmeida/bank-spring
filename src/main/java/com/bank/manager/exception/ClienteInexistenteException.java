package com.bank.manager.exception;

import org.springframework.http.ResponseEntity;

public class ClienteInexistenteException extends RuntimeException{

    public ClienteInexistenteException(){
        super("cliente não existe.");
    }
}
