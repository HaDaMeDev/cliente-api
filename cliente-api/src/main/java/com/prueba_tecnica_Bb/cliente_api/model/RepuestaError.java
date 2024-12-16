package com.prueba_tecnica_Bb.cliente_api.model;

public class RepuestaError extends Respuesta {
    public RepuestaError(int codigoEstado, String mensaje) {
        super(codigoEstado, mensaje, null);
    }
}
