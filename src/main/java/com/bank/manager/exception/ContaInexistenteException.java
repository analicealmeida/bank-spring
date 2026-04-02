package com.bank.manager.exception;

public class ContaInexistenteException extends RuntimeException {
    public ContaInexistenteException(String message) {
        super(message);
    }
}
