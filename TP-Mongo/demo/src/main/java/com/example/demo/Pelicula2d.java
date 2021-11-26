package com.example.demo;

public class Pelicula2d extends Pelicula{

    public Pelicula2d() {
    }

    public Pelicula2d(int nro, String nombre, String genero, String duracion, String clasificacion, String portada, boolean idiomaOriginal, boolean doblada, String sinopsis, String director, String reparto, String fechaEstreno, String fechaSalida) {
        super(nro, nombre, genero, duracion, clasificacion, portada, idiomaOriginal, doblada, sinopsis, director, reparto, fechaEstreno, fechaSalida);
    }

    @Override
    public void descripcionExperiencia() {
        String experiencia = "";
        experiencia = "Sinopsis: " + this.getSinopsis() + ". Para esta pelicula no es necesario que los clientes agarren anteojos 3d y el tamaño de la " +
                "pantalla para este tipo de peliculas va a ser 1.13m de alto y ancho y 2m de distancia";
        System.out.println(experiencia);
    }
}
