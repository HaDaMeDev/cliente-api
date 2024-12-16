package com.prueba_tecnica_Bb.cliente_api.model;

public class Respuesta {
    private  int codigoEstado;
    private String mensaje;
    private Object data;



    public Respuesta(int codigoEstado, String mensaje, Object data) {
        this.codigoEstado = codigoEstado;
        this.mensaje = mensaje;
        this.data = data;
    }

    public int getCodigoEstado() {
        return codigoEstado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public Object getData() {
        return data;
    }

    public void setCodigoEstado(int codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    public void setData(Cliente data) {
        this.data = data;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
