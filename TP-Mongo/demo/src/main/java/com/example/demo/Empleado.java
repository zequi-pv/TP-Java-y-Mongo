package com.example.demo;

public class Empleado extends Persona{
    private int edad;
    private String puesto;
    private int sueldo;
    private int diasLaborales;
    private int diasVacacionales;
    private String rendimiento;

    public Empleado(){
    }

    public Empleado(String nombre, String apellido, int dni, int contacto, int edad, String puesto, int sueldo, int diasLaborales, int diasVacacionales, String rendimiento) {
        super(nombre, apellido, dni, contacto);
        this.edad = edad;
        this.puesto = puesto;
        this.sueldo = sueldo;
        this.diasLaborales = diasLaborales;
        this.diasVacacionales = diasVacacionales;
        this.rendimiento = rendimiento;
    }



    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public int getDiasLaborales() {
        return diasLaborales;
    }

    public void setDiasLaborales(int diasLaborales) {
        this.diasLaborales = diasLaborales;
    }

    public int getDiasVacacionales() {
        return diasVacacionales;
    }

    public void setDiasVacacionales(int diasVacacionales) {
        this.diasVacacionales = diasVacacionales;
    }

    public String getRendimiento() {
        return rendimiento;
    }

    public void setRendimiento(String rendimiento) {
        this.rendimiento = rendimiento;
    }
}
