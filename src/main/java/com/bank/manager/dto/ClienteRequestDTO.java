package com.bank.manager.dto;

import com.bank.manager.model.Cliente;

public record ClienteRequestDTO(String cpf, String nome) {  //DTO evita enviar dados desnecessários, para não enviar toda uma tabela


}