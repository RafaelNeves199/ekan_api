package com.kan.planosaude.beneficiariosapi.configurarion;

import com.kan.planosaude.beneficiariosapi.exception.DocumentoValidationException;
import com.kan.planosaude.beneficiariosapi.exception.ResourceNotFoundException;
import com.kan.planosaude.beneficiariosapi.exception.UserAuthenticationException;
import com.kan.planosaude.beneficiariosapi.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ApplicarionControllerAdvice {

    @ExceptionHandler(InternalAuthenticationServiceException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> handleInternalAuthenticationServiceException(Exception ex) {
        ErrorMessage errorMessage = new ErrorMessage("Erro ao fazer Login", HttpStatus.BAD_REQUEST.name(), ex.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResponseStatusException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> handleResponseStatusException(ResponseStatusException ex) {
        ErrorMessage errorMessage = new ErrorMessage("Not Found", HttpStatus.BAD_REQUEST.name(), ex.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ErrorMessage errorMessage = new ErrorMessage("Not Found", HttpStatus.NOT_FOUND.name(), ex.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map( e -> e.getDefaultMessage())
                .collect(Collectors.toList());
        ErrorMessage errorMessage = new ErrorMessage(errors.toString(), HttpStatus.BAD_REQUEST.name(), ex.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DocumentoValidationException.class)
    public ResponseEntity<?> handleDocumentoValidationException(DocumentoValidationException ex) {
        ErrorMessage errorMessage = new ErrorMessage("Documento inválido", HttpStatus.BAD_REQUEST.name(), ex.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserAuthenticationException.class)
    public ResponseEntity<?> handleUserAuthenticationException(UserAuthenticationException ex) {
        ErrorMessage errorMessage = new ErrorMessage("UserAuthenticationException", HttpStatus.BAD_REQUEST.name(), ex.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
}
