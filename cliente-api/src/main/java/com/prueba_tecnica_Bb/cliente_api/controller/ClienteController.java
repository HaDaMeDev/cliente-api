package com.prueba_tecnica_Bb.cliente_api.controller;

import com.prueba_tecnica_Bb.cliente_api.factory.RespuestaErrorFactory;
import com.prueba_tecnica_Bb.cliente_api.model.Cliente;
import com.prueba_tecnica_Bb.cliente_api.model.RepuestaError;
import com.prueba_tecnica_Bb.cliente_api.model.Respuesta;
import com.prueba_tecnica_Bb.cliente_api.model.RespuestaCorrecta;
import com.prueba_tecnica_Bb.cliente_api.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;


    @GetMapping("/getCliente/{tipoDocumento}/{numeroDocumento}")

    public ResponseEntity<Respuesta> getClienteByDocumento(@PathVariable   String tipoDocumento, @PathVariable   String numeroDocumento){

        // Validación del tipo de documento
        if (!clienteService.isValidTipoDocumento(tipoDocumento)) {
            return construccionRespuestaError(HttpStatus.BAD_REQUEST, "Tipo de documento inválido. Solo se permite 'C' (Cédula) o 'P' (Pasaporte)");
        }

        // Búsqueda del cliente
        Cliente cliente = clienteService.getCliente(tipoDocumento, numeroDocumento);
        if (cliente != null) {
            return construccionRespuestaCorrecta(HttpStatus.OK, "Cliente encontrado", cliente);
        }

        // Cliente no encontrado
        return construccionRespuestaError(HttpStatus.NOT_FOUND, "Cliente no encontrado con el tipo Documento "+tipoDocumento+" y el numero documento "+numeroDocumento);

    }

    // Método para construir respuestas de éxito
    private ResponseEntity<Respuesta> construccionRespuestaCorrecta(HttpStatus status, String message, Object data) {
        RespuestaCorrecta respuesta = new RespuestaCorrecta(status.value(), message, data);
        return ResponseEntity.status(status)
                .header(HttpHeaders.CONTENT_TYPE, "application/json")
                .body(respuesta);
    }

    // Método para construir respuestas de error
    private ResponseEntity<Respuesta> construccionRespuestaError(HttpStatus status, String message) {
        RepuestaError response = RespuestaErrorFactory.createErrorResponse(status, message);
        return ResponseEntity.status(status)
                .header(HttpHeaders.CONTENT_TYPE, "application/json")
                .body(response);
    }


}
