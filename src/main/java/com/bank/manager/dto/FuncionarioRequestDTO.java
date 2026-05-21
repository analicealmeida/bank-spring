package com.bank.manager.dto;

import java.math.BigDecimal;

public record FuncionarioRequestDTO(String cpf, String nome, String username,
                                    String passwordCliente, String Cargo, String Matricula, BigDecimal Salario) { //DTO evita enviar dados desnecessários, para não enviar toda uma tabela


}
