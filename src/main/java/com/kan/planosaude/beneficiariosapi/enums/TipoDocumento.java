package com.kan.planosaude.beneficiariosapi.enums;

public enum TipoDocumento {
    RG("REGISTRO GERAL"),
    CPF("Cadastro de Pessoa Física"),
    CNPJ("Cadastro Nacional de Pessoas Jurídicas");

    private String descricao;

    TipoDocumento(String descricao) {
        this.descricao = descricao;
    }
    public String getDescricao() {
        return descricao;
    }

}
