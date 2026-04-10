package com.bank.manager.dto;

import com.bank.manager.model.Agencia;

import java.math.BigDecimal;

public record ContaRequestDTO(String numeroConta, Long idAgencia, Long idCliente, String tipoConta, BigDecimal saldo, BigDecimal taxaRendimento, BigDecimal chequeEspecial, BigDecimal taxaMensal) { //DTO evita enviar dados desnecessários, para não enviar toda uma tabela



}
