package desafio.alfrest.api.controller.exceptions;

import desafio.alfrest.api.services.exceptions.EntityNotFoundException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ControllerExceptionHandler {

    // Dispara quando uma entidade não é encontrada no DB:
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(EntityNotFoundException e, HttpServletRequest request) {
        StandardError erro = new StandardError();

        erro.setTimestamp(Instant.now());
        erro.setStatus(HttpStatus.NOT_FOUND.value());
        erro.setPath(request.getRequestURI());
        erro.setMessage("Recurso não encontrado.");
        erro.setErrors(List.of(e.getMessage()));

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    // Dispara quando um campo de formulário não é preenhido é inválido.
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> argumentNotValid(MethodArgumentNotValidException e, HttpServletRequest request) {
        StandardError erro = new StandardError();

        erro.setTimestamp(Instant.now());
        erro.setPath(request.getRequestURI());
        erro.setStatus(HttpStatus.NOT_FOUND.value());
//        erro.setMessage(e.getMessage());
        erro.setMessage("Algun(s) campos devem ser prenchido(s).");
        erro.setErrors(
                e.getBindingResult()
                        .getFieldErrors()
                        .stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.toList())
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

}
