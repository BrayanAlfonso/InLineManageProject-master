//Reglas de validación
const number=/^[0-9]{1,15}$/

//Validación de campos para el formulario de login

//Acceder al formulario
let form=document.getElementById("formValiderE")

//Acceder a los feedback
const fb1=document.querySelector("#divCantidadUnidad .fbForm")
const fb2=document.querySelector("#divIPrecioEntrada .fbForm")
const fb3=document.querySelector("#divIdProducto .fbForm")
const fb4=document.querySelector("#divIdEntradaProd .fbForm")

console.log(fb1, fb2, fb3, fb4)

//Acceder a los inputs
let UpdateCantUnidad=document.getElementById("UpdateCantidadUnidad")
let UpdatePrecEntrad=document.getElementById("UpdatePrecioEntrada")
let UpdateIdProduc=document.getElementById("UpdateIdProducto")
let UpdateIdEntraProd=document.getElementById("UpdateIdEntradaProd")

console.log(UpdateCantUnidad,UpdatePrecEntrad,UpdateIdProduc,UpdateIdEntraProd)

//Flags para los condicionales
let flag1
let flag2
let flag3
let flag4

//Validacion para el campo de cantUnidad
UpdateCantUnidad.addEventListener("input",(e)=>{
    if (number.test(e.target.value)) {
        // Cuando se valide hará esto
        UpdateCantUnidad.classList.add("success");
        UpdateCantUnidad.classList.remove("error");
        fb1.classList.add("hidden");
        fb1.classList.remove("visible");
        fb1.textContent = '';
        flag1 = true;
    } else {
        // Cuando no sea válido hará esto
        UpdateCantUnidad.classList.add("error");
        UpdateCantUnidad.classList.remove("success");
        fb1.classList.remove("hidden");
        fb1.classList.add("visible");
        fb1.textContent = 'Cantidad inválida';
        flag1 = false;
    }
})

//Validacion para el campo de precEntrad
UpdatePrecEntrad.addEventListener("input",(e)=>{
    if (number.test(e.target.value)) {
        // Cuando se valide hará esto
        UpdatePrecEntrad.classList.add("success");
        UpdatePrecEntrad.classList.remove("error");
        fb2.classList.add("hidden");
        fb2.classList.remove("visible");
        fb2.textContent = '';
        flag2 = true;
    } else {
        // Cuando no sea válido hará esto
        UpdatePrecEntrad.classList.add("error");
        UpdatePrecEntrad.classList.remove("success");
        fb2.classList.remove("hidden");
        fb2.classList.add("visible");
        fb2.textContent = 'Precio x unidad inválida';
        flag2 = false;
    }
})

//Validacion para el campo de precUnidad
UpdateIdProduc.addEventListener("input",(e)=>{
    if (number.test(e.target.value)) {
        // Cuando se valide hará esto
        UpdateIdProduc.classList.add("success");
        UpdateIdProduc.classList.remove("error");
        fb3.classList.add("hidden");
        fb3.classList.remove("visible");
        fb3.textContent = '';
        flag3 = true;
    } else {
        // Cuando no sea válido hará esto
        UpdateIdProduc.classList.add("error");
        UpdateIdProduc.classList.remove("success");
        fb3.classList.remove("hidden");
        fb3.classList.add("visible");
        fb3.textContent = 'Producto inválido';
        flag3 = false;
    }
})

//Validacion para el campo de idEntraProd
UpdateIdEntraProd.addEventListener("input",(e)=>{
    if (number.test(e.target.value)) {
        // Cuando se valide hará esto
        UpdateIdEntraProd.classList.add("success");
        UpdateIdEntraProd.classList.remove("error");
        fb4.classList.add("hidden");
        fb4.classList.remove("visible");
        fb4.textContent = '';
        flag4 = true;
    } else {
        // Cuando no sea válido hará esto
        UpdateIdEntraProd.classList.add("error");
        UpdateIdEntraProd.classList.remove("success");
        fb4.classList.remove("hidden");
        fb4.classList.add("visible");
        fb4.textContent = 'Entrad. Producto inválido';
        flag4 = false;
    }
})