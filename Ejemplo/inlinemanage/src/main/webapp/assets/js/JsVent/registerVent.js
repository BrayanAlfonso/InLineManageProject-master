
// Acceder al formulario
let form=document.getElementById("formValidVent")

// Crear banderas de validación
let flag1
let flag2
let flag3
let flag4
let flag5

// Acceder a campos del form
let f1=document.querySelector(".dateVent .fbForm")
let f2=document.querySelector(".idUsuario .fbForm")
let f3=document.querySelector(".Producto .fbForm")
let f4=document.querySelector(".precioProducto .fbForm")
let f5=document.querySelector(".Cantidad .fbForm")

// Acceder a Selects
let idProducto=document.getElementById("idProducto")

// Acceder a los Inputs

let datVent=document.getElementById("dateVent")
let idUsu=document.getElementById("idUsuario")
let precioProd=document.getElementById("precioProducto")
let Cant=document.getElementById("Cantidad")

// FECHA ACTUAL

    // Obtener el campo de fecha
    let dateVent = document.getElementById("dateVent");

    // Obtener la fecha actual en el formato YYYY-MM-DD
    let today = new Date().toISOString().split('T')[0];

    // Establecer la fecha actual en el campo de fecha
    dateVent.value = today;