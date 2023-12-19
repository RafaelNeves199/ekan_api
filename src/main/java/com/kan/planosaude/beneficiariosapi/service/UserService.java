package com.kan.planosaude.beneficiariosapi.service;

import com.kan.planosaude.beneficiariosapi.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
    UserDetails findByLogin(String login);

    void salvar(User user);
}
