package com.prueba_tecnica_Bb.cliente_api.factory;

import com.prueba_tecnica_Bb.cliente_api.model.Cliente;

public class ClienteFactory {
    public static Cliente crearClienteDefecto() {
        return new Cliente("Juan", "Carlos", "Pérez", "Gómez", "123456789", "Calle 123 #45-67", "Bogotá");
    }
}
