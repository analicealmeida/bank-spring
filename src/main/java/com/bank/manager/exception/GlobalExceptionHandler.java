package com.bank.manager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
//TODO ESTUDAR EXCEPTION HANDLE
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String,Object>> handleRuntimeException(RuntimeException e) {
        Map<String, Object> body = new HashMap<>();
        body.put("error", e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
    }

    @ExceptionHandler(CpfExistenteException.class)
    public ResponseEntity<Map<String,Object>> handleCpfExistenteException(CpfExistenteException e) {
        Map<String, Object> body = new HashMap<>();
        body.put("error", e.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(body);
    }

    @ExceptionHandler(ClienteInexistenteException.class)
    public ResponseEntity<Map<String,Object>> handleClienteInexistenteException(ClienteInexistenteException e) {
        Map<String, Object> body = new HashMap<>();
        body.put("error", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

    @ExceptionHandler(CpfInvalidoException.class)
    public ResponseEntity<Map<String,Object>> handleCpfInvalidoException(CpfInvalidoException e) {
        Map<String, Object> body = new HashMap<>();
        body.put("error", e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    //NomeObrigatorioException
    @ExceptionHandler(NomeObrigatorioException.class)
    public ResponseEntity<Map<String,Object>> handleNomeObrigatorioException(NomeObrigatorioException e) {
        Map<String, Object> body = new HashMap<>();
        body.put("error", e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    //ClienteNuloException
    @ExceptionHandler(EntidadeNulaException.class)
    public ResponseEntity<Map<String,Object>> handleClienteNuloException(EntidadeNulaException e) {
        Map<String, Object> body = new HashMap<>();
        body.put("error", e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
}
    //ListaClientesVaziaException
    @ExceptionHandler(ListaEntidadeVaziaException.class)
    public ResponseEntity<Map<String,Object>> handleListaClientesVaziaException(ListaEntidadeVaziaException e) {
        Map<String, Object> body = new HashMap<>();
        body.put("error", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

    //IdInvalidoException

    @ExceptionHandler(IdInvalidoException.class)
    public ResponseEntity<Map<String,Object>> handleIdInvalidoException(IdInvalidoException e) {
        Map<String, Object> body = new HashMap<>();
        body.put("error", e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    //FuncionarioInexistenteException
    @ExceptionHandler(FuncionarioInexistenteException.class)
    public ResponseEntity<Map<String,Object>> handleFuncionarioInexistenteException(FuncionarioInexistenteException e) {
        Map<String, Object> body = new HashMap<>();
        body.put("error", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

    //ObjetoExistenteException
    @ExceptionHandler(ObjetoExistenteException.class)
    public ResponseEntity<Map<String,Object>> handleObjetoExistenteException(ObjetoExistenteException e) {
        Map<String, Object> body = new HashMap<>();
        body.put("error", e.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(body);
    }
    //AgenciaInexistenteException
    @ExceptionHandler(AgenciaInexistenteException.class)
    public ResponseEntity<Map<String,Object>> handleAgenciaInexistenteException(AgenciaInexistenteException e) {
        Map<String, Object> body = new HashMap<>();
        body.put("error", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }
     //ContaInexistenteException
     @ExceptionHandler(ContaInexistenteException.class)
     public ResponseEntity<Map<String,Object>> handleContaInexistenteException(ContaInexistenteException e) {
         Map<String, Object> body = new HashMap<>();
         body.put("error", e.getMessage());
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
     }

     //illegal
     @ExceptionHandler(IllegalArgumentException.class)
     public ResponseEntity<Map<String,Object>> handleIllegalArgumentException(IllegalArgumentException e) {
         Map<String, Object> body = new HashMap<>();
         body.put("error", e.getMessage());
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
}
}






