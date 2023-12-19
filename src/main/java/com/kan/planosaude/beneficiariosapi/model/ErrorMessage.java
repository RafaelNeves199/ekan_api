package com.kan.planosaude.beneficiariosapi.model;

public class ErrorMessage {

    private String titulo;
    private String status;
    private String mensagem;

    public ErrorMessage(String titulo, String status, String mensagem) {
        this.titulo = titulo;
        this.status = status;
        this.mensagem = mensagem;
    }

    public ErrorMessage(String titulo, String status) {
        this.titulo = titulo;
        this.status = status;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
