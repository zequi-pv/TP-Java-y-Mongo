function ocultar(){
        document.getElementsByClassName("modificarEmpleado")[0].style.display = "none";
        document.getElementsByClassName("eliminarEmpleado")[0].style.display = "none";
        document.getElementsByClassName("añadirEmpleado")[0].style.display = "none";
        document.getElementsByClassName("verEmpleado")[0].style.display = "none";
    
        document.getElementsByClassName("modificarCliente")[0].style.display = "none";
        document.getElementsByClassName("eliminarCliente")[0].style.display = "none";
        document.getElementsByClassName("añadirCliente")[0].style.display = "none";
        document.getElementsByClassName("VerCliente")[0].style.display = "none";
    
        document.getElementsByClassName("modificarSala")[0].style.display = "none";
        document.getElementsByClassName("eliminarSala")[0].style.display = "none";
        document.getElementsByClassName("añadirSala")[0].style.display = "none";
        document.getElementsByClassName("verSala")[0].style.display = "none";
    
        document.getElementsByClassName("modificarCartelera")[0].style.display = "none";
    
        document.getElementsByClassName("modificarPelicula")[0].style.display = "none";
        document.getElementsByClassName("eliminarPelicula")[0].style.display = "none";
        document.getElementsByClassName("añadirPelicula")[0].style.display = "none";
        document.getElementsByClassName("verPelicula")[0].style.display = "none";
    
    
    }

    function modificarUnEmpleado(){

        var nombre = document.getElementById("input1.0").value;
        var apellido = document.getElementById("input1.1").value;
        var edad = document.getElementById("input1.2").value;
        var dni = document.getElementById("input1.3").value;
        var contacto = document.getElementById("input1.4").value;
        var puesto = document.getElementById("input1.5").value;
        edad = parseInt(edad);
        dni=parseInt(dni);
        contacto = parseInt(contacto);
        let objetoConInformacionAActualizar = {};
    $.ajax({
            url: "http://localhost:8080/api/Empleados/" + dni,
            type: 'PATCH',
            contentType: "application/json",
            data: JSON.stringify(objetoConInformacionAActualizar)
    })
    .done(function (data) {
        var datos = "Cambios realizados";
        document.getElementById("1resul").innerHTML = datos;
    })
    .fail(function (jqXHR, textStatus, errorThrown) {
        console.log("error, no se pudo ingresar los nuevos datos");
        console.log(jqXHR);
        console.log(textStatus);
        console.log(errorThrown);
    });
    }

    function eliminarUnEmpleado(){
        var dni = document.getElementById("input2.0").value;
    $.ajax({
            url: "http://localhost:8080/api/Empleados/" + dni,
            type: 'DELETE'
    })
    .done(function (data) {
        var datos = "Empleado eliminado";
        document.getElementById("1.2resul").innerHTML = datos;
    
    })
    .fail(function (jqXHR, textStatus, errorThrown) {
        console.log("error, no se pudo obtener datos");
        console.log(jqXHR);
        console.log(textStatus);
        console.log(errorThrown);
    });
    }

    function añadirUnEmpleado(){
        var nombre1 = document.getElementById("input3.0").value;
        var apellido1 = document.getElementById("input3.1").value;
        var edad1 = document.getElementById("input3.2").value;
        var dni1 = document.getElementById("input3.3").value;
        var contacto1 = document.getElementById("input3.4").value;
        var puesto1 = document.getElementById("input3.5").value;
        edad1 = parseInt(edad1);
        dni1 = parseInt(dni1);
        contacto1 = parseInt(contacto1);
        let objetoConInformacion = {nombre : nombre1 , apellido : apellido1 , edad : edad1 , dni : dni1 , contacto :
        contacto1 , puesto : puesto1 };
    console.log(objetoConInformacion);
    $.ajax({
            url: "http://localhost:8080/api/Empleados/",
            type: 'POST',
            contentType: "application/json",
            data: JSON.stringify(objetoConInformacion)
    })
    .done(function (data) {
        var datos = "Empleado creado";
        document.getElementById("1.3resul").innerHTML = datos;
    })
    .fail(function (jqXHR, textStatus, errorThrown) {
        console.log("error, no se pudo ingresar los nuevos datos");
        console.log(jqXHR);
        console.log(textStatus);
        console.log(errorThrown);
    });
    }


    function verUnEmpleado(){
        var dato2 = document.getElementById("input4.0").value;
            $.ajax({
                    url: "http://localhost:8080/api/Empleados/" + dato2,
                    type: 'GET'
            })
            .done(function (data) {
                let resultado = ""; 
                console.log(data);
                let nombre = data.nombre;
                let apellido = data.apellido;
                let edad = data.edad;
                let dni = data.dni;
                let contacto = data.contacto;
                let puesto = data.puesto;
                resultado = nombre + " " + apellido + " " + edad + " " +
                dni + " " + contacto + " " + puesto;
        
                document.getElementById("1.4resul").innerHTML = resultado;
            })
            .fail(function (jqXHR, textStatus, errorThrown) {
                console.log("error, no se pudo obtener datos");
                console.log(jqXHR);
                console.log(textStatus);
                console.log(errorThrown);
            });
            }

    function modificarUnCliente(){

                var nombre = document.getElementById("input1.0").value;
                var apellido = document.getElementById("input1.1").value;
                var edad = document.getElementById("input1.2").value;
                var dni = document.getElementById("input1.3").value;
                var contacto = document.getElementById("input1.4").value;
                edad = parseInt(edad);
                dni=parseInt(dni);
                let objetoConInformacionAActualizar = {};
            $.ajax({
                    url: "http://localhost:8080/api/Clientes/" + dni,
                    type: 'PATCH',
                    contentType: "application/json",
                    data: JSON.stringify(objetoConInformacionAActualizar)
            })
            .done(function (data) {
                var datos = "Cambios realizados";
                document.getElementById("2resul").innerHTML = datos;
            })
            .fail(function (jqXHR, textStatus, errorThrown) {
                console.log("error, no se pudo ingresar los nuevos datos");
                console.log(jqXHR);
                console.log(textStatus);
                console.log(errorThrown);
            });
    }

    function eliminarUnCliente(){
        var dni = document.getElementById("input6.0").value;
    $.ajax({
            url: "http://localhost:8080/api/Clientes/" + dni,
            type: 'DELETE'
    })
    .done(function (data) {
        var datos = "Empleado eliminado";
        document.getElementById("2.1resul").innerHTML = datos;
    
    })
    .fail(function (jqXHR, textStatus, errorThrown) {
        console.log("error, no se pudo obtener datos");
        console.log(jqXHR);
        console.log(textStatus);
        console.log(errorThrown);
    });
    }

    function añadirUnCliente(){
        var nombre1 = document.getElementById("input7.0").value;
        var apellido1 = document.getElementById("input7.1").value;
        var dni1 = document.getElementById("input7.3").value;
        var contacto1 = document.getElementById("input7.4").value;
        var socio1 = document.getElementById("input7.5").value;
        edad1 = parseInt(edad1);
        dni1 = parseInt(dni1);
        let objetoConInformacion = {nombre : nombre1 , apellido : apellido1 , dni : dni1 , contacto :
        contacto1 , socio : socio1 };
    console.log(objetoConInformacion);
    $.ajax({
            url: "http://localhost:8080/api/Clientes/",
            type: 'POST',
            contentType: "application/json",
            data: JSON.stringify(objetoConInformacion)
    })
    .done(function (data) {
        var datos = "Cliente creado";
        document.getElementById("2.2resul").innerHTML = datos;
    })
    .fail(function (jqXHR, textStatus, errorThrown) {
        console.log("error, no se pudo ingresar los nuevos datos");
        console.log(jqXHR);
        console.log(textStatus);
        console.log(errorThrown);
    });
    }

    function verUnCliente(){
        var dni = document.getElementById("input8.0").value;
            $.ajax({
                    url: "http://localhost:8080/api/Clientes/" + dni,
                    type: 'GET'
            })
            .done(function (data) {
                let resultado = ""; 
                console.log(data);
                let nombre = data.nombre;
                let apellido = data.apellido;
                let dni = data.dni;
                let contacto = data.contacto;
                resultado = nombre + " " + apellido  + " " +
                dni + " " + contacto + " " ;
        
                document.getElementById("2.3resul").innerHTML = resultado;
            })
            .fail(function (jqXHR, textStatus, errorThrown) {
                console.log("error, no se pudo obtener datos");
                console.log(jqXHR);
                console.log(textStatus);
                console.log(errorThrown);
            });
            }

    function modificarUnaSala(){

                var nro = document.getElementById("input9.0").value;
                var cantDeAsientos = document.getElementById("input9.1").value;
                var premium = document.getElementById("input9.3").value;
                var imax = document.getElementById("input9.4").value;
                cantDeAsientos = parseInt(cantDeAsientos);
                let objetoConInformacionAActualizar = {};
            $.ajax({
                    url: "http://localhost:8080/api/Salas/" + nro,
                    type: 'PATCH',
                    contentType: "application/json",
                    data: JSON.stringify(objetoConInformacionAActualizar)
            })
            .done(function (data) {
                var datos = "Cambios realizados";
                document.getElementById("3resul").innerHTML = datos;
            })
            .fail(function (jqXHR, textStatus, errorThrown) {
                console.log("error, no se pudo ingresar los nuevos datos");
                console.log(jqXHR);
                console.log(textStatus);
                console.log(errorThrown);
            });
    }

    function eliminarUnaSala(){
        var nro = document.getElementById("input10.0").value;
    $.ajax({
            url: "http://localhost:8080/api/Salas/" + nro,
            type: 'DELETE'
    })
    .done(function (data) {
        var datos = "Sala eliminada";
        document.getElementById("3.1resul").innerHTML = datos;
    
    })
    .fail(function (jqXHR, textStatus, errorThrown) {
        console.log("error, no se pudo obtener datos");
        console.log(jqXHR);
        console.log(textStatus);
        console.log(errorThrown);
    });
    }

    function añadirUnaSala(){
        var nro1 = document.getElementById("input11.0").value;
        var cantDeAsientos1 = document.getElementById("input11.1").value;
        var premium1 = document.getElementById("input11.2").value;
        var imax1 = document.getElementById("input11.3").value;
        nro1 = parseInt(nro1);
        let objetoConInformacion = {nro : nro1 , cantDeAsientos : cantDeAsientos1 ,
        premium : premium1 , imax : imax1 };
    console.log(objetoConInformacion);
    $.ajax({
            url: "http://localhost:8080/api/Salas/",
            type: 'POST',
            contentType: "application/json",
            data: JSON.stringify(objetoConInformacion)
    })
    .done(function (data) {
        var datos = "Sala creado";
        document.getElementById("3.2resul").innerHTML = datos;
    })
    .fail(function (jqXHR, textStatus, errorThrown) {
        console.log("error, no se pudo ingresar los nuevos datos");
        console.log(jqXHR);
        console.log(textStatus);
        console.log(errorThrown);
    });
    }

    function verUnaSala(){
        var nro = document.getElementById("input12.0").value;
            $.ajax({
                    url: "http://localhost:8080/api/Salas/" + nro,
                    type: 'GET'
            })
            .done(function (data) {
                let resultado = ""; 
                console.log(data);
                let nro = data.nro;
                let cantDeAsientos = data.cantDeAsientos;
                let premium = data.premium;
                let imax = data.imax;
                resultado = nro + " " + cantDeAsientos  + " " +
                premium + " " + imax + " " ;
        
                document.getElementById("3resul").innerHTML = resultado;
            })
            .fail(function (jqXHR, textStatus, errorThrown) {
                console.log("error, no se pudo obtener datos");
                console.log(jqXHR);
                console.log(textStatus);
                console.log(errorThrown);
            });
            }

    
            function modificarLaCartelera(){

                var peliculas = document.getElementById("input13.0").value;
                let objetoConInformacionAActualizar = {};
            $.ajax({
                    url: "http://localhost:8080/api/Cartelera/",
                    type: 'PATCH',
                    contentType: "application/json",
                    data: JSON.stringify(objetoConInformacionAActualizar)
            })
            .done(function (data) {
                var datos = "Cambios realizados";
                document.getElementById("4resul").innerHTML = datos;
            })
            .fail(function (jqXHR, textStatus, errorThrown) {
                console.log("error, no se pudo ingresar los nuevos datos");
                console.log(jqXHR);
                console.log(textStatus);
                console.log(errorThrown);
            });
    }

    function modificarUnaPelicula(){
        var nro = document.getElementById("input14.0").value;
        var nombre = document.getElementById("input14.1").value;
        var genero = document.getElementById("input14.2").value;
        var duracion = document.getElementById("input14.3").value;
        var portada = document.getElementById("input14.4").value;
        var doblada = document.getElementById("input14.5").value;
        var idiomaOriginal = document.getElementById("input14.6").value;
        var clasificacion = document.getElementById("input14.7").value;
        var director = document.getElementById("input14.8").value;
        var reparto = document.getElementById("input14.9").value;
        var fechaEstreno = document.getElementById("input14.10").value;
        var fechaSalida = document.getElementById("input14.11").value;
        let objetoConInformacionAActualizar = {};
    $.ajax({
            url: "http://localhost:8080/api/Peliculas/" + nro,
            type: 'PATCH',
            contentType: "application/json",
            data: JSON.stringify(objetoConInformacionAActualizar)
    })
    .done(function (data) {
        var datos = "Cambios realizados";
        document.getElementById("5resul").innerHTML = datos;
    })
    .fail(function (jqXHR, textStatus, errorThrown) {
        console.log("error, no se pudo ingresar los nuevos datos");
        console.log(jqXHR);
        console.log(textStatus);
        console.log(errorThrown);
    });
    }

    function eliminarUnaPelicula(){
        var nro = document.getElementById("input15.0").value;
    $.ajax({
            url: "http://localhost:8080/api/Peliculas/" + nro,
            type: 'DELETE'
    })
    .done(function (data) {
        var datos = "Pelicula eliminado";
        document.getElementById("5.1resul").innerHTML = datos;
    
    })
    .fail(function (jqXHR, textStatus, errorThrown) {
        console.log("error, no se pudo obtener datos");
        console.log(jqXHR);
        console.log(textStatus);
        console.log(errorThrown);
    });
    }

    function añadirUnaPelicula(){
        var nro1 = document.getElementById("input16.0").value;
        var nombre1 = document.getElementById("input16.1").value;
        var genero1 = document.getElementById("input16.2").value;
        var duracion1 = document.getElementById("input16.3").value;
        var portada1 = document.getElementById("input16.4").value;
        var doblada1 = document.getElementById("input16.5").value;
        var idiomaOriginal1 = document.getElementById("input16.6").value;
        var clasificacion1 = document.getElementById("input16.7").value;
        var director1 = document.getElementById("input16.8").value;
        var reparto1 = document.getElementById("input16.9").value;
        var fechaEstreno1 = document.getElementById("input16.10").value;
        var fechaSalida1 = document.getElementById("input16.11").value;
        nro1 = parseInt(nro1);
        let objetoConInformacion = {nro : nro1 , nombre : nombre1 , genero : genero1 ,
        duracion : duracion1 , portada : portada1 , doblada : doblada1 , idiomaOriginal : idiomaOriginal1 ,
        clasificacion : clasificacion1 , director : director1 , reparto : reparto1 ,
        fechaEstreno : fechaEstreno1 , fechaSalida : fechaSalida1};
    console.log(objetoConInformacion);
    $.ajax({
            url: "http://localhost:8080/api/Pelicula/",
            type: 'POST',
            contentType: "application/json",
            data: JSON.stringify(objetoConInformacion)
    })
    .done(function (data) {
        var datos = "Pelicula creado";
        document.getElementById("5.2resul").innerHTML = datos;
    })
    .fail(function (jqXHR, textStatus, errorThrown) {
        console.log("error, no se pudo ingresar los nuevos datos");
        console.log(jqXHR);
        console.log(textStatus);
        console.log(errorThrown);
    });
    }

    function verUnaPelicula(){
        var nro = document.getElementById("input17.0").value;
            $.ajax({
                    url: "http://localhost:8080/api/Peliculas/" + nro,
                    type: 'GET'
            })
            .done(function (data) {
                let resultado = ""; 
                console.log(data);
                let nro = data.nro;
                let nombre = data.nombre;
                let genero = data.genero;
                let duracion = data.duracion;
                let portada = data.portada;
                let doblada = data.doblada;
                let idiomaOriginal = data.idiomaOriginal;
                let clasificacion = data.clasificacion;
                let director = data.director;
                let reparto = data.reparto;
                let fechaEstreno = data.fechaEstreno;
                let fechaSalida = data.fechaSalida;
                resultado = nro + " " + nombre  + " " + genero + " " +
                duracion + " " + portada + " " + doblada + " " + idiomaOriginal +
                 " " + clasificacion + " " +  director + " " + reparto + " " + 
                 fechaEstreno + " " + fechaSalida;
        
                document.getElementById("5.3resul").innerHTML = resultado;
            })
            .fail(function (jqXHR, textStatus, errorThrown) {
                console.log("error, no se pudo obtener datos");
                console.log(jqXHR);
                console.log(textStatus);
                console.log(errorThrown);
            });
            }

    ocultar();
    function modificarEmpleado(){
        ocultar();
        document.getElementsByClassName("modificarEmpleado")[0].style.display = "block";
    }
    function eliminarEmpleado(){
        ocultar();
        document.getElementsByClassName("eliminarEmpleado")[0].style.display = "block";
    }
    function añadirEmpleado(){
        ocultar();
        document.getElementsByClassName("añadirEmpleado")[0].style.display = "block";
    }
    function verEmpleado(){
        ocultar();
        document.getElementsByClassName("verEmpleado")[0].style.display = "block";
    }
    function modificarCliente(){
        ocultar();
        document.getElementsByClassName("modificarCliente")[0].style.display = "block";
    }
    function eliminarCliente(){
        ocultar();
        document.getElementsByClassName("eliminarCliente")[0].style.display = "block";
    }
    function añadirCliente(){
        ocultar();
        document.getElementsByClassName("añadirCliente")[0].style.display = "block";
    }
    function VerCliente(){
        ocultar();
        document.getElementsByClassName("VerCliente")[0].style.display = "block";
    }
    function modificarSala(){
        ocultar();
        document.getElementsByClassName("modificarSala")[0].style.display = "block";
    }
    function eliminarSala(){
        ocultar();
        document.getElementsByClassName("eliminarSala")[0].style.display = "block";
    
    }function añadirSala(){
        ocultar();
        document.getElementsByClassName("añadirSala")[0].style.display = "block";
    
    }function verSala(){
        ocultar();
        document.getElementsByClassName("verSala")[0].style.display = "block";
    
    }function modificarCartelera(){
        ocultar();
        document.getElementsByClassName("modificarCartelera")[0].style.display = "block";
    
    }function modificarPelicula(){
        ocultar();
        document.getElementsByClassName("modificarPelicula")[0].style.display = "block";
    
    }function eliminarPelicula(){
        ocultar();
        document.getElementsByClassName("eliminarPelicula")[0].style.display = "block";
    
    }function añadirPelicula(){
        ocultar();
        document.getElementsByClassName("añadirPelicula")[0].style.display = "block";
    }
    function verPelicula(){
        ocultar();
        document.getElementsByClassName("verPelicula")[0].style.display = "block";
    }
 
