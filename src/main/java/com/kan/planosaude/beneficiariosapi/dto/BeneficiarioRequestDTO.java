package com.kan.planosaude.beneficiariosapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class BeneficiarioRequestDTO {

    private String nome;

    @Size(max = 11)
    private String telefone;

    @Past
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate dataNascimento;
    @JsonIgnore
    private LocalDateTime dataInclusao;
    @JsonIgnore
    private LocalDateTime dataAtualizacao;

    private List<DocumentoRequestDTO> documentos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
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

    public List<DocumentoRequestDTO> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<DocumentoRequestDTO> documentos) {
        this.documentos = documentos;
    }

    @Override
    public String toString() {
        return "BeneficiarioRequestDTO{" +
                "nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", dataInclusao=" + dataInclusao +
                ", dataAtualizacao=" + dataAtualizacao +
                ", documentos=" + documentos +
                '}';
    }
}
