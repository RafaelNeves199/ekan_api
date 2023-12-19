package com.kan.planosaude.beneficiariosapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class BeneficiarioInclusaoRequestDTO {
    @NotEmpty(message = "Campo nome é obrigatório")
    private String nome;
    @NotEmpty(message = "Campo telefone é obrigatório")
    @Size(max = 11)
    private String telefone;
    @NotNull(message = "Campo dataNascimento é obrigatório")
    @Past
    @JsonFormat(pattern="dd/MM/yyyy")
    @Schema(type = "string", pattern = "dd/MM/yyyy", example = "17/02/1980")
    private LocalDate dataNascimento;

    @NotEmpty(message = "Beneficiario precisa ter documento")
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
                ", documentos=" + documentos +
                '}';
    }
}
