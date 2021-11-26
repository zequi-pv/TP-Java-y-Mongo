function lol(){

$.ajax({
        url: "http://localhost:8080/api/empleados/",
        type: 'GET'
})
.done(function (data) {
    let resultado = ""; 
    console.log(data);
    let listaEmpleados = data.ListaDeEmpleados;
    var datos = JSON.stringify(data);
    for(let i = 0; i<listaEmpleados.length; i++){
        let empleado = listaEmpleados[i];
        let nombre = empleado.nombre;
        let apellido = empleado.apellido;
        let dni = empleado.dni;
        let contacto = empleado.contacto;
        let edad = empleado.edad;
        let puesto = empleado.puesto;
        let sueldo = empleado.sueldo;
        let diasLaborales = empleado.diasLaborales;
        let diasVacacionales = empleado.diasVacacionales;
        let rendimiento = empleado.rendimiento;
        resultado = resultado + " | "+ nombre + " " + apellido + " " + dni + " " + contacto + " " + edad + " " + puesto + " "
        + sueldo + " " + diasLaborales + " " + diasVacacionales + " " + rendimiento + " | " ;
    }
    document.getElementById("1resul").innerHTML = resultado;
})
.fail(function (jqXHR, textStatus, errorThrown) {
    console.log("error, no se pudo obtener datos");
    console.log(jqXHR);
    console.log(textStatus);
    console.log(errorThrown);
});
}
function lol2(){
var dato2 = document.getElementById("inputlol2").value;
    $.ajax({
            url: "http://localhost:8080/api/empleados/"+ dato2,
            type: 'GET'
    })
    .done(function (data) {
        let resultado = ""; 
        console.log(data);
        let nombre = data.Empleado.nombre;
        let apellido = data.Empleado.apellido;
        let dni = data.Empleado.dni;
        let contacto = data.Empleado.contacto;
        let edad = data.Empleado.edad;
        let puesto = data.Empleado.puesto;
        let sueldo = data.Empleado.sueldo;
        let diasLaborales = data.Empleado.diasLaborales;
        let diasVacacionales = data.Empleado.diasVacacionales;
        let rendimiento = data.Empleado.rendimiento;
        resultado = nombre + " " + apellido + " " + dni + " " + contacto + " " + edad + " " + puesto + " " + sueldo + " " + diasLaborales +
        " " + diasVacacionales + " " + rendimiento;

        document.getElementById("2resul").innerHTML = resultado;
    })
    .fail(function (jqXHR, textStatus, errorThrown) {
        console.log("error, no se pudo obtener datos");
        console.log(jqXHR);
        console.log(textStatus);
        console.log(errorThrown);
    });
    }
    
function lol3(){
    var nombre3 = document.getElementById("inputlol3.1").value;
    var id3 = document.getElementById("inputlol3.2").value;
    var edad3 = document.getElementById("inputlol3.3").value;
    id3= parseInt(id3);
    edad3=parseInt(edad3);
    let objetoConInformacion = {id : id3, nombre : nombre3 , edad : edad3 };
console.log(objetoConInformacion);
$.ajax({
        url: "http://localhost:8080/api/alumnos/",
        type: 'POST',
        contentType: "application/json",
        data: JSON.stringify(objetoConInformacion)
})
.done(function (data) {
    var datos = "Alumno creado";
    document.getElementById("3resul").innerHTML = datos;
})
.fail(function (jqXHR, textStatus, errorThrown) {
    console.log("error, no se pudo ingresar los nuevos datos");
    console.log(jqXHR);
    console.log(textStatus);
    console.log(errorThrown);
});

}



function lol4(){

    var id4 = document.getElementById("inputlol4.1").value;
    var nombre4 = document.getElementById("inputlol4.2").value;
    var edad4 = document.getElementById("inputlol4.3").value;
    id4= parseInt(id4);
    edad4=parseInt(edad4);
    let objetoConInformacionAActualizar = {};
    if (edad4 == null){
        objetoConInformacionAActualizar = { nombre : nombre4 };
    }
    else if(nombre4 == null){
        objetoConInformacionAActualizar = { edad : edad4 };
    }
    else{
        objetoConInformacionAActualizar = { nombre : nombre4 ,edad : edad4 };
    }
$.ajax({
        url: "http://localhost:8080/api/alumnos/"+id4,
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



function lol5(){
    var id5 = document.getElementById("inputlol5").value;
$.ajax({
        url: "http://localhost:8080/api/alumnos/"+id5,
        type: 'DELETE'
})
.done(function (data) {
    var datos = "Alumno eliminado";
    document.getElementById("5resul").innerHTML = datos;

})
.fail(function (jqXHR, textStatus, errorThrown) {
    console.log("error, no se pudo obtener datos");
    console.log(jqXHR);
    console.log(textStatus);
    console.log(errorThrown);
});
}

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
