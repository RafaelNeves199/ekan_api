package com.kan.planosaude.beneficiariosapi.dto;

import com.kan.planosaude.beneficiariosapi.enums.TipoDocumento;
import jakarta.validation.constraints.NotEmpty;

public class DocumentoRequestDTO {

    @NotEmpty(message = "Campo tipoDocumento é obrigatório")
    private TipoDocumento tipoDocumento;

    @NotEmpty(message = "Campo descricao é obrigatório")

    private String descricao;

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "DocumentoRequestDTO{" +
                "tipoDocumento=" + tipoDocumento +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
