package com.kan.planosaude.beneficiariosapi.controller;

import com.kan.planosaude.beneficiariosapi.dto.UserLoginDTO;
import com.kan.planosaude.beneficiariosapi.dto.UserRegisterDTO;
import com.kan.planosaude.beneficiariosapi.dto.UserResponseDTO;
import com.kan.planosaude.beneficiariosapi.entity.User;
import com.kan.planosaude.beneficiariosapi.exception.UserAuthenticationException;
import com.kan.planosaude.beneficiariosapi.service.TokenService;
import com.kan.planosaude.beneficiariosapi.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;


@Tag(name = "Authentication endpoint")
@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public UserResponseDTO login(@RequestBody @Valid UserLoginDTO userLoginDTO){
        var usernamePassword = new UsernamePasswordAuthenticationToken(userLoginDTO.getLogin(), userLoginDTO.getPassword());
        var auth = authenticationManager.authenticate(usernamePassword);

        var token = tokenService.gerarToken((User) auth.getPrincipal());
        UserResponseDTO responseDTO = new UserResponseDTO(userLoginDTO.getLogin(), token);

        return responseDTO;
    }

    @PostMapping("/registrar")
    @ResponseStatus(HttpStatus.CREATED)
    @SecurityRequirement(name = "Bearer Authentication")
    public void registrar(@RequestBody @Valid UserRegisterDTO userRegisterDTO){
        if(userService.findByLogin(userRegisterDTO.getLogin()) != null) {
            throw new UserAuthenticationException("Não é possivel registrar usuário já existe");
        }

        String encriptedPassword = new BCryptPasswordEncoder().encode(userRegisterDTO.getPassword());
        User user = new User(userRegisterDTO.getLogin(), encriptedPassword, userRegisterDTO.getRole());
        userService.salvar(user);
    }


}
