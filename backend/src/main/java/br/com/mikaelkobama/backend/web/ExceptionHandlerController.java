package br.com.mikaelkobama.backend.web;

import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

  @ExceptionHandler(JobInstanceAlreadyCompleteException.class)
  private ResponseEntity<Object> handleFileAlredyImported(
      JobInstanceAlreadyCompleteException exception) {
    return ResponseEntity.status(HttpStatus.CONFLICT)
        .body("O Arquivo informado já foi importado no sistema!");
  }

}
