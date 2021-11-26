package com.example.demo;

import java.util.ArrayList;

public abstract class Pelicula {
    private int nro;
    private String nombre;
    private String genero;
    private String duracion;
    private String clasificacion;
    private String portada;
    private boolean idiomaOriginal;
    private boolean doblada;
    private String sinopsis;
    private String director;
    private String reparto;
    private String fechaEstreno;
    private String fechaSalida;

    public Pelicula() {
    }

    public Pelicula(int nro, String nombre, String genero, String duracion, String clasificacion, String portada, boolean idiomaOriginal, boolean doblada, String sinopsis, String director, String reparto, String fechaEstreno, String fechaSalida) {
        this.nro = nro;
        this.nombre = nombre;
        this.genero = genero;
        this.duracion = duracion;
        this.clasificacion = clasificacion;
        this.portada = portada;
        this.idiomaOriginal = idiomaOriginal;
        this.doblada = doblada;
        this.sinopsis = sinopsis;
        this.director = director;
        this.reparto = reparto;
        this.fechaEstreno = fechaEstreno;
        this.fechaSalida = fechaSalida;
    }

    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public boolean isIdiomaOriginal() {
        return idiomaOriginal;
    }

    public void setIdiomaOriginal(boolean idiomaOriginal) {
        this.idiomaOriginal = idiomaOriginal;
    }

    public boolean isDoblada() {
        return doblada;
    }

    public void setDoblada(boolean doblada) {
        this.doblada = doblada;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getReparto() {
        return reparto;
    }

    public void setReparto(String reparto) {
        this.reparto = reparto;
    }

    public String getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(String fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    public abstract void descripcionExperiencia();

}
