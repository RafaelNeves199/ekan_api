package com.kan.planosaude.beneficiariosapi.service.impl;

import com.kan.planosaude.beneficiariosapi.entity.User;
import com.kan.planosaude.beneficiariosapi.repository.UserRepository;
import com.kan.planosaude.beneficiariosapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public void salvar(User user) {
        userRepository.save(user);
    }
}
