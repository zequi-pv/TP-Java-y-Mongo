package com.example.demo;

public class Administrador {
    private String Usuario;
    private String contrasena;

    public Administrador(String usuario, String contrasena) {
        this.Usuario = usuario;
        this.contrasena = contrasena;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
