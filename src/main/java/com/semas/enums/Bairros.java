package com.semas.enums;

public enum Bairros {

    BOAVISTA("Boa Vista"),
    CENTRO("Centro"),
    CIMENTO("Cimento Paraíso"),
    MORROGRANDE("Morro Grande"),
    PARQUEINDUSTRIAL("Parque Industrial"),
    SAOPEDRO("São Pedro Paraíso"),
    SALDANHA("Saldanha da Gama");

    private String bairro;

    Bairros(String bairro) {
        this.bairro = bairro;
    }

    public String getBairro() {
        return bairro;
    }
    
}