package com.prueba_tecnica_Bb.cliente_api.repository;

import com.prueba_tecnica_Bb.cliente_api.factory.ClienteFactory;
import com.prueba_tecnica_Bb.cliente_api.model.Cliente;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteRepository {
    public Cliente getClienteByDocumento(String tipoDocumento, String numeroDocumento) {
        if (tipoDocumento.equalsIgnoreCase("C") && numeroDocumento.equals("23445322")) {
            return ClienteFactory.crearClienteDefecto();
        }
        return null;
    }
}
