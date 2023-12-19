package com.kan.planosaude.beneficiariosapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kan.planosaude.beneficiariosapi.enums.TipoDocumento;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;
import java.util.Objects;

public class DocumentoResponseDTO {

    @JsonIgnore
    private Long id;

    private TipoDocumento tipoDocumento;

    private String descricao;

    private LocalDateTime dataInclusao;

    private LocalDateTime dataAtualizacao;

    private Long beneficiario_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public LocalDateTime getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(LocalDateTime dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public Long getBeneficiario_id() {
        return beneficiario_id;
    }

    public void setBeneficiario_id(Long beneficiario_id) {
        this.beneficiario_id = beneficiario_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentoResponseDTO that = (DocumentoResponseDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "DocumentoResponseDTO{" +
                "tipoDocumento=" + tipoDocumento +
                ", descricao='" + descricao + '\'' +
                ", dataInclusao=" + dataInclusao +
                ", dataAtualizacao=" + dataAtualizacao +
                ", beneficiario_id=" + beneficiario_id +
                '}';
    }
}
