package com.bank.manager.dto;

public record FuncionarioRequestDTO(String cpf, String nome) { //DTO evita enviar dados desnecessários, para não enviar toda uma tabela


}
