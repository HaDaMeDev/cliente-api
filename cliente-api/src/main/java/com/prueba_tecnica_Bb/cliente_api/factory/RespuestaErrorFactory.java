package com.prueba_tecnica_Bb.cliente_api.factory;

import com.prueba_tecnica_Bb.cliente_api.model.RepuestaError;
import org.springframework.http.HttpStatus;

public class RespuestaErrorFactory {
    public static RepuestaError createErrorResponse(HttpStatus status, String message) {
        return new RepuestaError(status.value(), message);
    }
}
