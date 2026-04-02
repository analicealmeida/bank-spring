package com.bank.manager.exception;

public class AgenciaInexistenteException extends RuntimeException {
    public AgenciaInexistenteException(String message) {
        super(message);
    }
}
