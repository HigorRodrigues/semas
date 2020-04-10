package com.semas.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pasta {

    @Id
    private String letra;

    private int contador;

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
    
}