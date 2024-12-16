package com.prueba_tecnica_Bb.cliente_api.exception;

import com.prueba_tecnica_Bb.cliente_api.factory.RespuestaErrorFactory;
import com.prueba_tecnica_Bb.cliente_api.model.RepuestaError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<RepuestaError> handleAllExceptions(Exception ex, WebRequest request) {
        RepuestaError respuesta = RespuestaErrorFactory.createErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Ocurrió un error interno en el servidor: " + ex.getMessage()
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .header(HttpHeaders.CONTENT_TYPE, "application/json")
                .body(respuesta);
    }
}
