package br.com.mentoria.ibm.notas_sender.exceptions;
import br.com.mentoria.ibm.notas_sender.service.exceptions.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDate;

@ControllerAdvice
public class ResourceExceptionHandle {
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandarError> objectNotFound(ObjectNotFoundException exc, HttpServletRequest request) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new StandarError(LocalDate.now(), exc.getMessage(), HttpStatus.NOT_FOUND.value(), request.getRequestURI())
        );

    }
}
