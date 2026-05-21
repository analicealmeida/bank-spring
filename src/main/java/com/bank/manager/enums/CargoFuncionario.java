package com.bank.manager.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum CargoFuncionario {
    ANALISTA,
    GERENTE,
    ADMIN,
    DIRETOR;

    @JsonCreator
    public static CargoFuncionario from(String value) {
        return CargoFuncionario.valueOf(value.toUpperCase());
    }
}
