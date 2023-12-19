package com.kan.planosaude.beneficiariosapi.dto;

import com.kan.planosaude.beneficiariosapi.enums.UserRole;
import jakarta.validation.constraints.NotEmpty;

public class UserLoginDTO {

    @NotEmpty
    private String login;
    @NotEmpty
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
