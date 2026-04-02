package com.bank.manager.exception;

public class FuncionarioInexistenteException extends RuntimeException {
    public FuncionarioInexistenteException(String message) {
        super(message);
    }
}
