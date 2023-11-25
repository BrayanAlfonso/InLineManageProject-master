//Reglas de validación
const number=/^[0-9]{1,15}$/

//Validación de campos para el formulario de login

//Acceder al formulario
let form=document.getElementById("formValiderE")

//Acceder a los feedback
const fb1=document.querySelector("#divCantidadUnidad .fbForm")
const fb2=document.querySelector("#divPrecioEntrada .fbForm")
const fb3=document.querySelector("#divIdProducto .fbForm")
const fb4=document.querySelector("#divIdEntradaProd .fbForm")

console.log(fb1, fb2, fb3, fb4)

//Acceder a los inputs
let cantUnidad=document.getElementById("cantidadUnidad")
let precEntrad=document.getElementById("precioEntrada")
let idProduc=document.getElementById("idProducto")
let idEntraProd=document.getElementById("idEntradaProd")

console.log(cantUnidad,precEntrad,idProduc,idEntraProd)

//Flags para los condicionales
let flag1
let flag2
let flag3
let flag4

//Validacion para el campo de cantUnidad
cantUnidad.addEventListener("input",(e)=>{
    if (number.test(e.target.value)) {
        // Cuando se valide hará esto
        cantUnidad.classList.add("success");
        cantUnidad.classList.remove("error");
        fb1.classList.add("hidden");
        fb1.classList.remove("visible");
        fb1.textContent = '';
        flag1 = true;
    } else {
        // Cuando no sea válido hará esto
        cantUnidad.classList.add("error");
        cantUnidad.classList.remove("success");
        fb1.classList.remove("hidden");
        fb1.classList.add("visible");
        fb1.textContent = "Cantidad invalida"
        flag1 = false;
    }
})

//Validacion para el campo de precEntrad
precEntrad.addEventListener("input",(e)=>{
    if (number.test(e.target.value)) {
        // Cuando se valide hará esto
        precEntrad.classList.add("success");
        precEntrad.classList.remove("error");
        fb2.classList.add("hidden");
        fb2.classList.remove("visible");
        fb2.textContent = '';
        flag2 = true;
    } else {
        // Cuando no sea válido hará esto
        precEntrad.classList.add("error");
        precEntrad.classList.remove("success");
        fb2.classList.remove("hidden");
        fb2.classList.add("visible");
        fb2.textContent = 'Precio x unidad inválida';
        flag2 = false;
    }
})

//Validacion para el campo de precUnidad
idProduc.addEventListener("input",(e)=>{
    if (number.test(e.target.value)) {
        // Cuando se valide hará esto
        idProduc.classList.add("success");
        idProduc.classList.remove("error");
        fb3.classList.add("hidden");
        fb3.classList.remove("visible");
        fb3.textContent = '';
        flag3 = true;
    } else {
        // Cuando no sea válido hará esto
        idProduc.classList.add("error");
        idProduc.classList.remove("success");
        fb3.classList.remove("hidden");
        fb3.classList.add("visible");
        fb3.textContent = 'Producto inválido';
        flag3 = false;
    }
})

//Validacion para el campo de idEntraProd
idEntraProd.addEventListener("input",(e)=>{
    if (number.test(e.target.value)) {
        // Cuando se valide hará esto
        idEntraProd.classList.add("success");
        idEntraProd.classList.remove("error");
        fb4.classList.add("hidden");
        fb4.classList.remove("visible");
        fb4.textContent = '';
        flag4 = true;
    } else {
        // Cuando no sea válido hará esto
        idEntraProd.classList.add("error");
        idEntraProd.classList.remove("success");
        fb4.classList.remove("hidden");
        fb4.classList.add("visible");
        fb4.textContent = 'Entrad. Producto inválido';
        flag4 = false;
    }
})

form.addEventListener("submit", (e) => {

    // e.preventDefault()
      if (cantUnidad.value==0||cantUnidad.value==null||flag==false) {
        alert("por favor ingresa un numero de cantUnidad valido")
        cantUnidad.focus()
        cantUnidad.classList.add("error");
      }else if(precEntrad.value==0||precEntrad.value==null||flag1==false){
        alert("por favor ingresa un precEntrad valido")
        precEntrad.focus()
        precEntrad.classList.add("error");
      }else if(idProduc.value==0||idProduc.value==null||flag2==false){
        alert("por favor ingresa un idProduc valido")
        idProduc.focus()
        idProduc.classList.add("error");
      }else if(idEntraProd.value==0||idEntraProd.value==null||flag3==false){
        alert("por favor ingresa una idEntraProd valida")
        idEntraProd.focus()
        idEntraProd.classList.add("error");
      }else {
        form.submit()
        
      }
    });