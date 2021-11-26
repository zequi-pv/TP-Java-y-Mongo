package com.example.demo;

import com.mongodb.MongoClient;
import com.mongodb.client.*;
import org.bson.Document;
import org.springframework.stereotype.Service;
import java.util.*;
// Integrantes: Alvarez, Firus, Prieto y Ruiz
@Service
class MongoDB {

    private MongoDatabase baseDeDatos;
    private MongoCollection coleccion;

    public MongoDB() {
        this.conectar("TpJavaMongo","Empleados");
    }

    public void conectar(String baseDeDatos,String coleccion){
        this.conectarABaseDeDatos(baseDeDatos);
        this.conectarAColeccion(coleccion);
    }

    public MongoDatabase getBaseDeDatos() {
        return baseDeDatos;
    }

    public void setBaseDeDatos(MongoDatabase baseDeDatos) {
        this.baseDeDatos = baseDeDatos;
    }

    public MongoCollection getColeccion() {
        return coleccion;
    }

    public void setColeccion(MongoCollection coleccion) {
        this.coleccion = coleccion;
    }

    public void conectarABaseDeDatos(String nombreBaseDeDatos){
        MongoClient mongo = new MongoClient("localhost",27017);
        this.baseDeDatos = mongo.getDatabase(nombreBaseDeDatos);
    }

    public void conectarAColeccion(String nombreDeColeccion){
        if (this.existeLaColeccion(nombreDeColeccion)){
            this.coleccion = baseDeDatos.getCollection(nombreDeColeccion);
        } else {
            baseDeDatos.createCollection(nombreDeColeccion);
            this.coleccion = baseDeDatos.getCollection(nombreDeColeccion);
        }
    }

    public boolean existeLaColeccion(String nombreDeColeccion){

        MongoIterable<String> nombresDeColecciones = baseDeDatos.listCollectionNames();
        boolean existe = false;

        for (String nombre : nombresDeColecciones) {
            if (nombre.equals(nombreDeColeccion)){
                existe = true;
            }
        }
        return existe;
    }

    public HashMap<String,Object> obternerEmpleados(){
        HashMap<String,Object> datos = new HashMap<>();
        ArrayList<Empleado> empleados = new ArrayList<>();

        FindIterable resultado = coleccion.find();
        MongoCursor iterador = resultado.iterator();

        while(iterador.hasNext()){
            Document documento = (Document) iterador.next();
            String nombre = documento.getString("nombre");
            String apellido = documento.getString("apellido");
            int Dni = documento.getInteger("dni");
            int contacto = documento.getInteger("contacto");
            int edad = documento.getInteger("edad");
            String puesto = documento.getString("puesto");
            int sueldo = documento.getInteger("sueldo");
            int diasLaborales = documento.getInteger("Dias laborales");
            int diasVacacionales = documento.getInteger("Dias vacacionales");
            String rendimiento = documento.getString("rendimiento");
            Empleado empleado = new Empleado(nombre,apellido,Dni,contacto
                    ,edad,puesto,sueldo,diasLaborales,diasVacacionales,rendimiento);
            empleados.add(empleado);
        }
        datos.put("Empleado",empleados);
        return datos;
    }

    public HashMap<String,Object> obtenerClientes(){
        HashMap<String,Object> datos = new HashMap<>();
        ArrayList<Cliente> clientes = new ArrayList<>();

        FindIterable resultado = coleccion.find();
        MongoCursor iterador = resultado.iterator();

        while(iterador.hasNext()){
            Document documento = (Document) iterador.next();
            String nombre = documento.getString("nombre");
            String apellido = documento.getString("apellido");
            int dni = documento.getInteger("dni");
            int contacto = documento.getInteger("contacto");
            int vecesVisitadas = documento.getInteger("VecesVisitadas");
            boolean socio = documento.getBoolean("socio");
            Cliente cliente = new Cliente(nombre,apellido,dni,contacto
                    ,vecesVisitadas,socio);
            clientes.add(cliente);
        }
        datos.put("Clientes",clientes);
        return datos;
    }

    public HashMap<String,Object> obtenerSalas(){
        HashMap<String,Object> datos = new HashMap<>();
        ArrayList<Sala> salas = new ArrayList<>();

        FindIterable resultado = coleccion.find();
        MongoCursor iterador = resultado.iterator();

        while(iterador.hasNext()){
            Document documento = (Document) iterador.next();
            int nro = documento.getInteger("Nro");
            int cantAsientos = documento.getInteger("cantAsientos");
            int AsientosOcupados = documento.getInteger("asientosVacios");
            int AsientosLibres = documento.getInteger("asientosLlenos");
            boolean premium = documento.getBoolean("premium");
            boolean imax = documento.getBoolean("imax");
            Sala sala = new Sala(nro,cantAsientos,AsientosOcupados,AsientosLibres
                    ,premium,imax);
            salas.add(sala);
        }
        datos.put("Salas",salas);
        return datos;
    }

    public HashMap<String,Object> obtenerPeliculas2d(){
        HashMap<String,Object> datos = new HashMap<>();
        ArrayList<Pelicula2d> peliculas2d = new ArrayList<>();

        FindIterable resultado = coleccion.find();
        MongoCursor iterador = resultado.iterator();

        while(iterador.hasNext()){
            Document documento = (Document) iterador.next();
            int nro = documento.getInteger("nroPelicula");
            String nombre = documento.getString("nombre");
            String genero = documento.getString("genero");
            String duracion = documento.getString("duracion");
            String clasificacion = documento.getString("clasificacion");
            String portada = documento.getString("portada");
            boolean idiomaOriginal = documento.getBoolean("idiomaOriginal");
            boolean doblada = documento.getBoolean("doblada");
            String sinopsis = documento.getString("sinopsis");
            String director = documento.getString("director");
            String reparto = documento.getString("reparto");
            String fechaEstreno = documento.getString("fechaEstreno");
            String fechaSalida = documento.getString("fechaSalida");
            Pelicula2d pelicula2d = new Pelicula2d(nro,nombre,genero,duracion,clasificacion
                    ,portada,idiomaOriginal,doblada,sinopsis,director,reparto,fechaEstreno,fechaSalida);
            peliculas2d.add(pelicula2d);
        }
        datos.put("Peliculas 2d",peliculas2d);
        return datos;
    }

    public HashMap<String,Object> obtenerPeliculas3d(){
        HashMap<String,Object> datos = new HashMap<>();
        ArrayList<Pelicula3d> peliculas3d = new ArrayList<>();

        FindIterable resultado = coleccion.find();
        MongoCursor iterador = resultado.iterator();

        while(iterador.hasNext()){
            Document documento = (Document) iterador.next();
            int nro = documento.getInteger("nroPelicula");
            String nombre = documento.getString("nombre");
            String genero = documento.getString("genero");
            String duracion = documento.getString("duracion");
            String clasificacion = documento.getString("clasificacion");
            String portada = documento.getString("portada");
            boolean idiomaOriginal = documento.getBoolean("idiomaOriginal");
            boolean doblada = documento.getBoolean("doblada");
            String sinopsis = documento.getString("sinopsis");
            String director = documento.getString("director");
            String reparto = documento.getString("reparto");
            String fechaEstreno = documento.getString("fechaEstreno");
            String fechaSalida = documento.getString("fechaSalida");
            Pelicula3d pelicula3d = new Pelicula3d(nro,nombre,genero,duracion,clasificacion
                    ,portada,idiomaOriginal,doblada,sinopsis,director,reparto,fechaEstreno,fechaSalida);
            peliculas3d.add(pelicula3d);
        }
        datos.put("Peliculas 2d",peliculas3d);
        return datos;
    }

    public Empleado obtenerEmpleado(int dni){
        Empleado empleado = new Empleado();
        String json = "{dni:{$eq:" + dni + "}}";
        Document filtro = Document.parse(json);
        FindIterable resultado = coleccion.find(filtro);
        MongoCursor iterador = resultado.iterator();

        while (iterador.hasNext()){
            Document documento = (Document) iterador.next();
            String nombre = documento.getString("nombre");
            String apellido = documento.getString("apellido");
            dni = documento.getInteger("dni");
            int contacto = documento.getInteger("telContacto");
            int edad = documento.getInteger("edad");
            String puesto = documento.getString("puesto");
            int sueldo = documento.getInteger("sueldo");
            int diasLaborales = documento.getInteger("diasLaborales");
            int diasVacacionales = documento.getInteger("diasVacacionales");
            String rendimiento = documento.getString("rendimiento");
            empleado = new Empleado(nombre,apellido,dni,contacto,edad,puesto,
                    sueldo,diasLaborales,diasVacacionales,rendimiento);
        }
        return empleado;
    }

    public Cliente obtenerCliente(int dni){
        Cliente cliente = new Cliente();
        String json = "{dni:{$eq:" + dni + "}}";
        Document filtro = Document.parse(json);
        FindIterable resultado = coleccion.find(filtro);
        MongoCursor iterador = resultado.iterator();

        while (iterador.hasNext()) {
            Document documento = (Document) iterador.next();
            String nombre = documento.getString("Nombre");
            String apellido = documento.getString("Apellido");
            dni = documento.getInteger("DNI");
            int contacto = documento.getInteger("Contacto");
            int vecesVisitadas = documento.getInteger("VecesVisitadas");
            boolean socio = documento.getBoolean("Socio");
            cliente = new Cliente(nombre,apellido,dni,contacto,
                    vecesVisitadas,socio);
        }
        return cliente;
    }

    public Sala obtenerSala(int nro){
        Sala sala = new Sala();
        String json = "{nro:{$eq" + nro + "}}";
        Document filtro = Document.parse(json);
        FindIterable resultado = coleccion.find(filtro);
        MongoCursor iterador = resultado.iterator();

        while(iterador.hasNext()){
            Document documento = (Document) iterador.next();
            nro = documento.getInteger("nroSala");
            int cantAsientos = documento.getInteger("cantAsientos");
            int AsientosOcupados = documento.getInteger("asientosVacios");
            int AsientosLibres = documento.getInteger("asientosLlenos");
            boolean premium = documento.getBoolean("premium");
            boolean imax = documento.getBoolean("imax");
            sala = new Sala(nro,cantAsientos,AsientosOcupados,AsientosLibres,
                    premium,imax);
        }
        return sala;
    }

    public Pelicula2d obtenerPelicula2D(int nro){
        Pelicula2d pelicula2d = new Pelicula2d();
        String json = "{nro:{$eq" + nro + "}}";
        Document filtro = Document.parse(json);
        FindIterable resultado = coleccion.find(filtro);
        MongoCursor iterador = resultado.iterator();

        while(iterador.hasNext()){
            Document documento = (Document) iterador.next();
            nro = documento.getInteger("nroPelicula");
            String nombre = documento.getString("nombre");
            String genero = documento.getString("genero");
            String duracion = documento.getString("duracion");
            String clasificacion = documento.getString("clasificacion");
            String portada = documento.getString("portada");
            boolean idiomaOriginal = documento.getBoolean("idiomaOriginal");
            boolean doblada = documento.getBoolean("doblada");
            String sinopsis = documento.getString("sinopsis");
            String director = documento.getString("director");
            String reparto = documento.getString("reparto");
            String fechaEstreno = documento.getString("fechaEstreno");
            String fechaSalida = documento.getString("fechaSalida");
            pelicula2d = new Pelicula2d(nro,nombre,genero,duracion,clasificacion
                    ,portada,idiomaOriginal,doblada,sinopsis,director,reparto,fechaEstreno,fechaSalida);
        }
        return pelicula2d;
    }

    public Pelicula3d obtenerPelicula3D(int nro){
        Pelicula3d pelicula3d = new Pelicula3d();
        String json = "{nro:{$eq" + nro + "}}";
        Document filtro = Document.parse(json);
        FindIterable resultado = coleccion.find(filtro);
        MongoCursor iterador = resultado.iterator();

        while(iterador.hasNext()){
            Document documento = (Document) iterador.next();
            nro = documento.getInteger("nroPelicula");
            String nombre = documento.getString("nombre");
            String genero = documento.getString("genero");
            String duracion = documento.getString("duracion");
            String clasificacion = documento.getString("clasificacion");
            String portada = documento.getString("portada");
            boolean idiomaOriginal = documento.getBoolean("idiomaOriginal");
            boolean doblada = documento.getBoolean("doblada");
            String sinopsis = documento.getString("sinopsis");
            String director = documento.getString("director");
            String reparto = documento.getString("reparto");
            String fechaEstreno = documento.getString("fechaEstreno");
            String fechaSalida = documento.getString("fechaSalida");
            pelicula3d = new Pelicula3d(nro,nombre,genero,duracion,clasificacion
                    ,portada,idiomaOriginal,doblada,sinopsis,director,reparto,fechaEstreno,fechaSalida);
        }
        return pelicula3d;
    }

    public void insertarEmpleado(Empleado empleado){
        Document nuevoDocumento = new Document();
        nuevoDocumento.append("nombre",empleado.getNombre());
        nuevoDocumento.append("apellido",empleado.getApellido());
        nuevoDocumento.append("edad",empleado.getEdad());
        nuevoDocumento.append("dni",empleado.getDni());
        nuevoDocumento.append("telContacto",empleado.getContacto());
        nuevoDocumento.append("puesto",empleado.getPuesto());
        nuevoDocumento.append("sueldo",empleado.getSueldo());
        nuevoDocumento.append("diasLaborales",empleado.getDiasLaborales());
        nuevoDocumento.append("diasVacacionales",empleado.getDiasVacacionales());
        nuevoDocumento.append("rendimiento",empleado.getRendimiento());
        coleccion.insertOne(nuevoDocumento);
    }

    public void insertarCliente(Cliente cliente){
        Document nuevoDocumento = new Document();
        nuevoDocumento.append("Nombre",cliente.getNombre());
        nuevoDocumento.append("Apellido",cliente.getApellido());
        nuevoDocumento.append("DNI",cliente.getDni());
        nuevoDocumento.append("Contacto",cliente.getContacto());
        nuevoDocumento.append("VecesVisitadas",cliente.getVecesVisitadas());
        nuevoDocumento.append("Socio",cliente.isSocio());
        coleccion.insertOne(nuevoDocumento);
    }

    public void insertarSala(Sala sala){
        Document nuevoDocumento = new Document();
        nuevoDocumento.append("Nro",sala.getNro());
        nuevoDocumento.append("Cantidad de asientos",sala.getCantAsientos());
        nuevoDocumento.append("Asientos ocupados",sala.getAsientosOcupados());
        nuevoDocumento.append("Asientos libres",sala.getAsientosLibres());
        nuevoDocumento.append("Premium",sala.isPremium());
        nuevoDocumento.append("Imax",sala.isImax());
        coleccion.insertOne(nuevoDocumento);
    }

    public void insertarPelicula2d(Pelicula2d pelicula){
        Document nuevoDocumento = new Document();
        nuevoDocumento.append("Nro",pelicula.getNro());
        nuevoDocumento.append("Nombre",pelicula.getNombre());
        nuevoDocumento.append("Genero",pelicula.getGenero());
        nuevoDocumento.append("Duracion",pelicula.getDuracion());
        nuevoDocumento.append("Clasificacion",pelicula.getClasificacion());
        nuevoDocumento.append("Portada",pelicula.getPortada());
        nuevoDocumento.append("Idioma original",pelicula.isIdiomaOriginal());
        nuevoDocumento.append("Doblada",pelicula.isDoblada());
        nuevoDocumento.append("Sinopsis",pelicula.getSinopsis());
        nuevoDocumento.append("Director",pelicula.getDirector());
        nuevoDocumento.append("Reparto",pelicula.getReparto());
        nuevoDocumento.append("Fecha estreno",pelicula.getFechaEstreno());
        nuevoDocumento.append("Fecha salida",pelicula.getFechaSalida());
        coleccion.insertOne(nuevoDocumento);
    }

    public void insertarPelicula3d(Pelicula3d pelicula){
        Document nuevoDocumento = new Document();
        nuevoDocumento.append("Nro",pelicula.getNro());
        nuevoDocumento.append("Nombre",pelicula.getNombre());
        nuevoDocumento.append("Genero",pelicula.getGenero());
        nuevoDocumento.append("Duracion",pelicula.getDuracion());
        nuevoDocumento.append("Clasificacion",pelicula.getClasificacion());
        nuevoDocumento.append("Portada",pelicula.getPortada());
        nuevoDocumento.append("Idioma original",pelicula.isIdiomaOriginal());
        nuevoDocumento.append("Doblada",pelicula.isDoblada());
        nuevoDocumento.append("Sinopsis",pelicula.getSinopsis());
        nuevoDocumento.append("Director",pelicula.getDirector());
        nuevoDocumento.append("Reparto",pelicula.getReparto());
        nuevoDocumento.append("Fecha estreno",pelicula.getFechaEstreno());
        nuevoDocumento.append("Fecha salida",pelicula.getFechaSalida());
        coleccion.insertOne(nuevoDocumento);
    }

    public void actualizarEmpleado(HashMap<String,Object> datosNuevos){
        String json = "{$set:{";
        for(Map.Entry<String, Object> dato: datosNuevos.entrySet()){
            json = json + dato.getKey() + ":" + dato.getValue() + "," +
                    dato.getKey() + ":" + dato.getValue() + "," +
                    dato.getKey() + ":" + dato.getValue() + "," +
                    dato.getKey() + ":" + dato.getValue() + "," +
                    dato.getKey() + ":" + dato.getValue() + "," +
                    dato.getKey() + ":" + dato.getValue() + "," +
                    dato.getKey() + ":" + dato.getValue() + "," +
                    dato.getKey() + ":" + dato.getValue() + "," +
                    dato.getKey() + ":" + dato.getValue() + "," +
                    dato.getKey() + ":" + dato.getValue();
        }
        json = json + "}}";
    }

    public void actualizarCliente(HashMap<String,Object> datosNuevos){
        String json = "{$set:{";
        for(Map.Entry<String,Object> dato: datosNuevos.entrySet()){
            json = json + dato.getKey() + ":" + dato.getValue() + "," +
                    dato.getKey() + ":" + dato.getValue() + "," +
                    dato.getKey() + ":" + dato.getValue() + "," +
                    dato.getKey() + ":" + dato.getValue() + "," +
                    dato.getKey() + ":" + dato.getValue() + "," +
                    dato.getKey() + ":" + dato.getValue() + "," +
                    dato.getKey() + ":" + dato.getValue() + "," +
                    dato.getKey() + ":" + dato.getValue();
        }
        json = json + "}}";
        System.out.println(json);
    }

    public void actualizarSala(HashMap<String,Object> datosNuevos){
        String json = "{$set:{";
        for(Map.Entry<String,Object> dato: datosNuevos.entrySet()){
            json = json + dato.getKey() + ":" + dato.getValue() + "," +
                    dato.getKey() + ":" + dato.getValue() + "," +
                    dato.getKey() + ":" + dato.getValue() + "," +
                    dato.getKey() + ":" + dato.getValue() + "," +
                    dato.getKey() + ":" + dato.getValue() + "," +
                    dato.getKey() + ":" + dato.getValue();
        }
        json = json + "}}";
    }

    public void actualizarCartelera(HashMap<String,Object> datosNuevos){
        String json = "{$set:{";
        for(Map.Entry<String,Object> dato: datosNuevos.entrySet()) {
            json = json + dato.getKey() + ":" + dato.getValue();
        }
        json = json + "}}";
    }

    public void actualizarPelicula2D(HashMap<String,Object> datosNuevos){
        String json = "{$set:{";
        for(Map.Entry<String,Object> dato: datosNuevos.entrySet()){
            json = json + dato.getKey() + ":" + dato.getValue() + "," +
                    dato.getKey() + ":" + dato.getValue() + "," +
                    dato.getKey() + ":" + dato.getValue() + "," +
                    dato.getKey() + ":" + dato.getValue() + "," +
                    dato.getKey() + ":" + dato.getValue() + "," +
                    dato.getKey() + ":" + dato.getValue() + "," +
                    dato.getKey() + ":" + dato.getValue() + "," +
                    dato.getKey() + ":" + dato.getValue() + "," +
                    dato.getKey() + ":" + dato.getValue() + "," +
                    dato.getKey() + ":" + dato.getValue() + "," +
                    dato.getKey() + ":" + dato.getValue() + "," +
                    dato.getKey() + ":" + dato.getValue() + "," +
                    dato.getKey() + ":" + dato.getValue();
        }
        json = json + "}}";
    }

    public void actualizarPelicula3D(HashMap<String,Object> datosNuevos){
        String json = "{$set:{";
        for(Map.Entry<String,Object> dato: datosNuevos.entrySet()){
            json = json + dato.getKey() + ":" + dato.getValue() + "," +
                    dato.getKey() + ":" + dato.getValue() + "," +
                    dato.getKey() + ":" + dato.getValue() + "," +
                    dato.getKey() + ":" + dato.getValue() + "," +
                    dato.getKey() + ":" + dato.getValue() + "," +
                    dato.getKey() + ":" + dato.getValue() + "," +
                    dato.getKey() + ":" + dato.getValue() + "," +
                    dato.getKey() + ":" + dato.getValue() + "," +
                    dato.getKey() + ":" + dato.getValue() + "," +
                    dato.getKey() + ":" + dato.getValue() + "," +
                    dato.getKey() + ":" + dato.getValue() + "," +
                    dato.getKey() + ":" + dato.getValue() + "," +
                    dato.getKey() + ":" + dato.getValue();
        }
        json = json + "}}";
    }

    public void eliminarEmpleado(int dni){
        String json = "{dni: {$eq:" + dni + "}}";
        Document filtro = Document.parse(json);
        coleccion.deleteOne(filtro);
    }

    public void eliminarCliente(int dni){
        String json = "{dni:{$eq:" + dni + "}}";
        Document filtro = Document.parse(json);
        coleccion.deleteOne(filtro);
    }

    public void eliminarSala(int nro){
        String json = "{nro:{$eq:" + nro + "}}";
        Document filtro = Document.parse(json);
        coleccion.deleteOne(filtro);
    }

    public void eliminarPelicula2D(int nro) {
        String json = "{nro:{$eq:" + nro + "}}";
        Document filtro = Document.parse(json);
        coleccion.deleteOne(filtro);
    }

    public void eliminarPelicula3D(int nro) {
        String json = "{nro:{$eq:" + nro + "}}";
        Document filtro = Document.parse(json);
        coleccion.deleteOne(filtro);
    }

    public static void main(String[] args) {
        MongoDB mongo = new MongoDB();
        HashMap<String,Object> datosNuevos = new HashMap();
        datosNuevos.put("Nombre","Lucas");
        datosNuevos.put("Apellido","Gonzalez");
        datosNuevos.put("Dni",42352768);
        mongo.actualizarCliente(datosNuevos);
    }

    /**
     * documentación de clase Document
     * http://mongodb.github.io/mongo-java-driver/3.6/javadoc/org/bson/Document.html
     */

}