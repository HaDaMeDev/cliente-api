package com.prueba_tecnica_Bb.cliente_api.service;

import com.prueba_tecnica_Bb.cliente_api.model.Cliente;
import com.prueba_tecnica_Bb.cliente_api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    public Cliente getCliente(String tipoDocumento, String numeroDocumento) {
        return clienteRepository.getClienteByDocumento(tipoDocumento,numeroDocumento);
    }

    public boolean isValidTipoDocumento(String tipoDocumento) {
        return "C".equals(tipoDocumento) || "P".equals(tipoDocumento);
    }

    public boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

}
