package com.bank.manager.dto;

public record AgenciaRequestDTO(String nomeAgencia, String estado) { //DTO evita enviar dados desnecessários, para não enviar toda uma tabela

}
