package com.semas.enums;

public enum TipoBeneficio {
    
    DOISMIL("R$ 2.000,00"),
    CINCOMIL("R$ 5.000,00");

    private String tipo;

    TipoBeneficio(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

}