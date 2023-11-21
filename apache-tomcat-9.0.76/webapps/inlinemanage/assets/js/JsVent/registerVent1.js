
// Acceder al formulario
let form=document.getElementById("formValidVent")

// Crear banderas de validación
let flag1
let flag2
let flag3
let flag4
let flag5

// Acceder a campos del form

let f3=document.querySelector(".Producto .fbForm")
let f4=document.querySelector(".precioProducto .fbForm")
let f5=document.querySelector(".Cantidad .fbForm")

// Acceder a Selects
let idProducto=document.getElementById("idProducto")

// Acceder a los Inputs
let precioProd=document.getElementById("precioProducto")
let Cant=document.getElementById("Cantidad")




// const scanner = new Html5QrcodeScanner('reader', {
//     qrbox: {
//         width: 250,
//         height: 250,
//     },
//     fps: 20,
// });

// function success(result) {
//     document.getElementById('result').innerHTML = `
//         <h2>Success!</h2>
//         <p><a href="${result}">${result}</a></p>
//     `;
//     scanner.clear();
//     document.getElementById('reader').remove();
//     // Puedes utilizar 'result' como el código de barras escaneado
//     // Aquí podrías realizar alguna lógica para manejar el resultado.
// }

// function error(err) {
//     console.error(err);
// }