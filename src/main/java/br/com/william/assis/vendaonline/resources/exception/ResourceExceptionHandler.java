package br.com.william.assis.vendaonline.resources.exception;

import br.com.william.assis.vendaonline.service.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
     @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandarError>objecNotFoud(ObjectNotFoundException e, HttpServletRequest request){
           StandarError err = new StandarError(HttpStatus.NOT_FOUND.value(), e.getMessage(),
                   System.currentTimeMillis() );

           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
}
