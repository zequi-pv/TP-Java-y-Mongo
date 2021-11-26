package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

/** url: http://localhost:8080/api/... **/

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Controller {

    @Autowired
    private MongoDB mongo;

    public Controller() {
        this.mongo = new MongoDB();
    }

    //Empleados
    @RequestMapping(value = "/Empleados",method = RequestMethod.GET)
    public ResponseEntity<Object> obtenerEmpleados(){
        mongo.conectar("TpJavaMongo","Empleados");
        HashMap<String,Object> datos = mongo.obternerEmpleados();
        return new ResponseEntity<>(datos,HttpStatus.OK);
    }

    @RequestMapping(value = "/Empleados/{dni}", method = RequestMethod.GET)
    public ResponseEntity<Object> obtenerEmpleado(@PathVariable int dni) {
        Empleado empleado = mongo.obtenerEmpleado(dni);
        return new ResponseEntity<>(empleado, HttpStatus.OK);
    }

    @RequestMapping(value = "/Empleados", method = RequestMethod.POST)
    public ResponseEntity<Object> agregarEmpleado(@RequestBody HashMap empleado) {
        mongo.conectar("TpJavaMongo","Empleados");
        String nombre = (String) empleado.get("nombre");
        String apellido = (String) empleado.get("apellido");
        int dni = (int) empleado.get("dni");
        int contacto = (int) empleado.get("telContacto");
        int edad = (int) empleado.get("edad");
        String puesto = (String) empleado.get("puesto");
        int sueldo = (int) empleado.get("sueldo");
        int diasLaborales = (int) empleado.get("diasLaborales");
        int diasVacacionales = (int) empleado.get("diasVacacionales");
        String rendimiento = (String) empleado.get("rendimiento");
        Empleado nuevoEmpleado = new Empleado(nombre,apellido,dni,contacto,
                edad,puesto,sueldo,diasLaborales,diasVacacionales,rendimiento);
        mongo.insertarEmpleado(nuevoEmpleado);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/Empleados/{dni}",method = RequestMethod.PATCH)
    public ResponseEntity<Object> actualizarEmpleado(@PathVariable int dni, @RequestBody HashMap empleado){
        mongo.conectar("TpJavaMongo","Empleados");
        String nombre = (String) empleado.get("nombre");
        String apellido = (String) empleado.get("apellido");
        int contacto = (int) empleado.get("telContacto");
        int edad = (int) empleado.get("edad");
        String puesto = (String) empleado.get("puesto");
        int sueldo = (int) empleado.get("sueldo");
        int diasLaborales = (int) empleado.get("diasLaborales");
        int diasVacacionales = (int) empleado.get("diasVacacionales");
        String rendimiento = (String) empleado.get("rendimiento");
        Empleado nuevoEmpleado = new Empleado(nombre,apellido,dni,contacto,edad,puesto,sueldo
                ,diasLaborales,diasVacacionales,rendimiento);
        empleado.put("Empleado nuevo", nuevoEmpleado);
        mongo.actualizarEmpleado(empleado);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/Empleados/{dni}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> eliminarEmpleado(@PathVariable int dni){
        mongo.eliminarEmpleado(dni);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Clientes
    @RequestMapping(value = "/Clientes",method = RequestMethod.GET)
    public ResponseEntity<Object> obtenerClientes(){
        mongo.conectar("TpJavaMongo","Clientes");
        HashMap<String,Object> datos =mongo.obtenerClientes();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/Clientes/{dni}", method = RequestMethod.GET)
    public ResponseEntity<Object> obtenerCliente(@PathVariable int dni) {
        Cliente cliente = mongo.obtenerCliente(dni);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @RequestMapping(value = "/Clientes", method = RequestMethod.POST)
    public ResponseEntity<Object> agregarCliente(@RequestBody HashMap cliente) {
        mongo.conectar("TpJavaMongo","Clientes");
        String nombre = (String) cliente.get("Nombre");
        String apellido = (String) cliente.get("Apellido");
        int dni = (int) cliente.get("DNI");
        int contacto = (int) cliente.get("Contacto");
        int vecesVisitadas = (int) cliente.get("VecesVisitadas");
        boolean socio = (boolean) cliente.get("Socio");
        Cliente nuevoCliente = new Cliente(nombre,apellido,dni,contacto,vecesVisitadas,socio);
        mongo.insertarCliente(nuevoCliente);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/Clientes/{dni}",method = RequestMethod.PATCH)
    public ResponseEntity<Object> actualizarCliente(@PathVariable int dni, HashMap cliente){
        String nombre = (String) cliente.get("Nombre");
        String apellido = (String) cliente.get("Apellido");
        int contacto = (int) cliente.get("Contacto");
        int vecesVisitadas = (int) cliente.get("VecesVisitadas");
        boolean socio = (boolean) cliente.get("Socio");
        Cliente nuevoCliente = new Cliente(nombre,apellido,dni,contacto,vecesVisitadas,socio);
        cliente.put("Empleado nuevo", nuevoCliente);
        mongo.actualizarCliente(cliente);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/Clientes/{dni}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> eliminarCliente(@RequestBody int dni){
        mongo.eliminarCliente(dni);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Sala
    @RequestMapping(value = "/Salas",method = RequestMethod.GET)
    public ResponseEntity<Object> obtenerSalas(){
        mongo.conectar("TpJavaMongo","Salas");
        HashMap<String,Object> datos =mongo.obtenerSalas();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/Salas/{nro}", method = RequestMethod.GET)
    public ResponseEntity<Object> obtenerSala(@PathVariable int nro) {
        Sala sala = mongo.obtenerSala(nro);
        return new ResponseEntity<>(sala, HttpStatus.OK);
    }

    @RequestMapping(value = "/Salas", method = RequestMethod.POST)
    public ResponseEntity<Object> agregarSala(@RequestBody HashMap sala) {
        mongo.conectar("TpJavaMongo","Salas");
        int nro = (int) sala.get("nroSala");
        int cantAsientos = (int) sala.get("cantAsientos");
        int AsientosOcupados = (int) sala.get("asientosVacios");
        int AsientosLibres = (int) sala.get("asientosLlenos");
        boolean premium = (boolean) sala.get("premium");
        boolean imax = (boolean) sala.get("imax");
        Sala nuevaSala = new Sala(nro,cantAsientos,AsientosOcupados,AsientosLibres
                ,premium,imax);
        mongo.insertarSala(nuevaSala);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/Salas/{nro}",method = RequestMethod.PATCH)
    public ResponseEntity<Object> actualizarSala(@PathVariable int nro, HashMap sala){
        int cantAsientos = (int) sala.get("cantAsientos");
        int AsientosOcupados = (int) sala.get("asientosVacios");
        int AsientosLibres = (int) sala.get("asientosLlenos");
        boolean premium = (boolean) sala.get("premium");
        boolean imax = (boolean) sala.get("imax");
        Sala nuevaSala = new Sala(nro,cantAsientos,AsientosOcupados,AsientosLibres
                ,premium,imax);
        sala.put("Sala nuevo", nuevaSala);
        mongo.actualizarSala(sala);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/Salas/{nro}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> eliminarSala(@RequestBody int nro){
        mongo.eliminarSala(nro);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Cartelera
    @RequestMapping(value = "/Cartelera/{nro}",method = RequestMethod.PATCH)
    public ResponseEntity<Object> actualizarCartelera(@PathVariable int nro, HashMap cartelera){
        ArrayList<String> peliculas = (ArrayList<String>) cartelera.get("Ultima visita");
        Cartelera nuevaCartelera = new Cartelera(peliculas);
        cartelera.put("Sala nuevo", nuevaCartelera);
        mongo.actualizarCartelera(cartelera);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Pelicula2d
    @RequestMapping(value = "/Peliculas",method = RequestMethod.GET)
    public ResponseEntity<Object> obtenerPeliculas2d(){
        mongo.conectar("TpJavaMongo","Peliculas");
        HashMap<String,Object> datos =mongo.obtenerPeliculas2d();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/Peliculas/{nro}", method = RequestMethod.GET)
    public ResponseEntity<Object> obtenerPelicula2d(@PathVariable int nro) {
        Pelicula2d pelicula2d = mongo.obtenerPelicula2D(nro);
        return new ResponseEntity<>(pelicula2d, HttpStatus.OK);
    }

    @RequestMapping(value = "/Peliculas", method = RequestMethod.POST)
    public ResponseEntity<Object> agregarPelicula2d(@RequestBody HashMap pelicula2d) {
        mongo.conectar("TpJavaMongo","Peliculas");
        int nro = (int) pelicula2d.get("nroPelicula");
        String nombre = (String) pelicula2d.get("nombre");
        String genero = (String) pelicula2d.get("genero");
        String duracion = (String) pelicula2d.get("duracion");
        String clasificacion = (String) pelicula2d.get("clasificacion");
        String portada = (String) pelicula2d.get("portada");
        boolean idiomaOriginal = (boolean) pelicula2d.get("idiomaOriginal");
        boolean doblada = (boolean) pelicula2d.get("doblada");
        String sinopsis = (String) pelicula2d.get("sinopsis");
        String director = (String) pelicula2d.get("director");
        String reparto = (String) pelicula2d.get("reparto");
        String fechaEstreno = (String) pelicula2d.get("fechaEstreno");
        String fechaSalida = (String) pelicula2d.get("fechaSalida");
        Pelicula2d nuevaPelicula2d = new Pelicula2d(nro,nombre,genero,duracion,clasificacion
                ,portada,idiomaOriginal,doblada,sinopsis,director,reparto,fechaEstreno,fechaSalida);
        mongo.insertarPelicula2d(nuevaPelicula2d);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/Peliculas/{nro}",method = RequestMethod.PATCH)
    public ResponseEntity<Object> actualizarPelicula2d(@PathVariable int nro, HashMap pelicula2d){
        String nombre = (String) pelicula2d.get("nombre");
        String genero = (String) pelicula2d.get("genero");
        String duracion = (String) pelicula2d.get("duracion");
        String clasificacion = (String) pelicula2d.get("clasificacion");
        String portada = (String) pelicula2d.get("portada");
        boolean idiomaOriginal = (boolean) pelicula2d.get("idiomaOriginal");
        boolean doblada = (boolean) pelicula2d.get("doblada");
        String sinopsis = (String) pelicula2d.get("sinopsis");
        String director = (String) pelicula2d.get("director");
        String reparto = (String) pelicula2d.get("reparto");
        String fechaEstreno = (String) pelicula2d.get("fechaEstreno");
        String fechaSalida = (String) pelicula2d.get("fechaSalida");
        Pelicula2d nuevaPelicula2d = new Pelicula2d(nro,nombre,genero,duracion,clasificacion
                ,portada,idiomaOriginal,doblada,sinopsis,director,reparto,fechaEstreno,fechaSalida);
        pelicula2d.put("Sala nuevo", nuevaPelicula2d);
        mongo.actualizarSala(pelicula2d);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/Peliculas/{nro}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> eliminarPelicula2d(@RequestBody int nro){
        mongo.eliminarPelicula2D(nro);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Peliculas3d
    @RequestMapping(value = "/Peliculas3d",method = RequestMethod.GET)
    public ResponseEntity<Object> obtenerPeliculas3d(){
        mongo.conectar("TpJavaMongo","Peliculas");
        HashMap<String,Object> datos = mongo.obtenerPeliculas3d();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/Peliculas3d/{nro}", method = RequestMethod.GET)
    public ResponseEntity<Object> obtenerPelicula3d(@PathVariable int nro) {
        Pelicula3d pelicula3d = mongo.obtenerPelicula3D(nro);
        return new ResponseEntity<>(pelicula3d, HttpStatus.OK);
    }

    @RequestMapping(value = "/Peliculas3d", method = RequestMethod.POST)
    public ResponseEntity<Object> agregarPelicula3d(@RequestBody HashMap pelicula3d) {
        mongo.conectar("TpJavaMongo","Peliculas");
        int nro = (int) pelicula3d.get("nroPelicula");
        String nombre = (String) pelicula3d.get("nombre");
        String genero = (String) pelicula3d.get("genero");
        String duracion = (String) pelicula3d.get("duracion");
        String clasificacion = (String) pelicula3d.get("clasificacion");
        String portada = (String) pelicula3d.get("portada");
        boolean idiomaOriginal = (boolean) pelicula3d.get("idiomaOriginal");
        boolean doblada = (boolean) pelicula3d.get("doblada");
        String sinopsis = (String) pelicula3d.get("sinopsis");
        String director = (String) pelicula3d.get("director");
        String reparto = (String) pelicula3d.get("reparto");
        String fechaEstreno = (String) pelicula3d.get("fechaEstreno");
        String fechaSalida = (String) pelicula3d.get("fechaSalida");
        Pelicula3d nuevaPelicula3d = new Pelicula3d(nro,nombre,genero,duracion,clasificacion
                ,portada,idiomaOriginal,doblada,sinopsis,director,reparto,fechaEstreno,fechaSalida);
        mongo.insertarPelicula3d(nuevaPelicula3d);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/Peliculas3d/{nro}",method = RequestMethod.PATCH)
    public ResponseEntity<Object> actualizarPelicula3d(@PathVariable int nro, HashMap pelicula3d){
        String nombre = (String) pelicula3d.get("nombre");
        String genero = (String) pelicula3d.get("genero");
        String duracion = (String) pelicula3d.get("duracion");
        String clasificacion = (String) pelicula3d.get("clasificacion");
        String portada = (String) pelicula3d.get("portada");
        boolean idiomaOriginal = (boolean) pelicula3d.get("idiomaOriginal");
        boolean doblada = (boolean) pelicula3d.get("doblada");
        String sinopsis = (String) pelicula3d.get("sinopsis");
        String director = (String) pelicula3d.get("director");
        String reparto = (String) pelicula3d.get("reparto");
        String fechaEstreno = (String) pelicula3d.get("fechaEstreno");
        String fechaSalida = (String) pelicula3d.get("fechaSalida");
        Pelicula3d nuevaPelicula3d = new Pelicula3d(nro,nombre,genero,duracion,clasificacion
                ,portada,idiomaOriginal,doblada,sinopsis,director,reparto,fechaEstreno,fechaSalida);
        pelicula3d.put("Sala nuevo", nuevaPelicula3d);
        mongo.actualizarSala(pelicula3d);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/Peliculas3d/{nro}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> eliminarPelicula3d(@RequestBody int nro){
        mongo.eliminarPelicula3D(nro);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}