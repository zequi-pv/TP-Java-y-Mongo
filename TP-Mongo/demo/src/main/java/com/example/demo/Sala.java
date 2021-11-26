package com.example.demo;

public class Sala {
    private int nro;
    private int cantAsientos;
    private int AsientosOcupados;
    private int AsientosLibres;
    private boolean premium;
    private boolean imax;

    public Sala(){
    }

    public Sala(int nro, int cantAsientos, int asientosOcupados, int asientosLibres, boolean premium, boolean imax) {
        this.nro = nro;
        this.cantAsientos = cantAsientos;
        this.AsientosOcupados = asientosOcupados;
        this.AsientosLibres = asientosLibres;
        this.premium = premium;
        this.imax = imax;
    }

    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

    public int getCantAsientos() {
        return cantAsientos;
    }

    public void setCantAsientos(int cantAsientos) {
        this.cantAsientos = cantAsientos;
    }

    public int getAsientosOcupados() {
        return AsientosOcupados;
    }

    public void setAsientosOcupados(int asientosOcupados) {
        AsientosOcupados = asientosOcupados;
    }

    public int getAsientosLibres() {
        return AsientosLibres;
    }

    public void setAsientosLibres(int asientosLibres) {
        AsientosLibres = asientosLibres;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public boolean isImax() {
        return imax;
    }

    public void setImax(boolean imax) {
        this.imax = imax;
    }
}
