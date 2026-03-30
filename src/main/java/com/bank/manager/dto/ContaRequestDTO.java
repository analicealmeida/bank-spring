package com.bank.manager.dto;

import com.bank.manager.model.Agencia;

public record ContaRequestDTO(String numeroConta, Agencia agencia) {

}
