package com.algamoneyapi.exceptions;

public class MensagemCapturadaErro {
    private String mensagemUsuario;
    private String mensagemDesenvolvedor;

    public MensagemCapturadaErro(String mensagemUsuario, String mensagemDesenvolvedor) {
        this.mensagemUsuario = mensagemUsuario;
        this.mensagemDesenvolvedor = mensagemDesenvolvedor;
    }

    public String getMensagemUsuario() {
        return mensagemUsuario;
    }

    public String getMensagemDesenvolvedor() {
        return mensagemDesenvolvedor;
    }
}
