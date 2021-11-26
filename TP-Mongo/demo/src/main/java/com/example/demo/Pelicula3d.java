package com.example.demo;

public class Pelicula3d extends Pelicula{

    public Pelicula3d() {
    }

    public Pelicula3d(int nro, String nombre, String genero, String duracion, String clasificacion, String portada, boolean idiomaOriginal, boolean doblada, String sinopsis, String director, String reparto, String fechaEstreno, String fechaSalida) {
        super(nro, nombre, genero, duracion, clasificacion, portada, idiomaOriginal, doblada, sinopsis, director, reparto, fechaEstreno, fechaSalida);
    }

    @Override
    public void descripcionExperiencia() {
        String experiencia = "";
        experiencia = "Sinopsis: " + this.getSinopsis() + ". Para esta pelicula es necesario que los clientes agarren anteojos 3d y el tamaño de la " +
                "pantalla para este tipo de peliculas va a ser 1.59m de alto y ancho y 3m de distancia";
        System.out.println(experiencia);
    }
}
