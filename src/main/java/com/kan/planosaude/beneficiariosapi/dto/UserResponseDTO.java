package com.kan.planosaude.beneficiariosapi.dto;

public class UserResponseDTO {
    private String login;
    private String token;

    public UserResponseDTO() {
    }

    public UserResponseDTO(String login, String token) {
        this.login = login;
        this.token = token;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "TokenResponseDTO{" +
                "login='" + login + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
