package com.example.demo;

import java.util.ArrayList;

public class Cliente extends Persona{
    private int vecesVisitadas;
    private boolean socio;

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, int dni, int contacto, int vecesVisitadas, boolean socio) {
        super(nombre, apellido, dni, contacto);
        this.vecesVisitadas = vecesVisitadas;
        this.socio = socio;
    }

    public int getVecesVisitadas() {
        return vecesVisitadas;
    }

    public void setVecesVisitadas(int vecesVisitadas) {
        this.vecesVisitadas = vecesVisitadas;
    }

    public boolean isSocio() {
        return socio;
    }

    public void setSocio(boolean socio) {
        this.socio = socio;
    }

}
