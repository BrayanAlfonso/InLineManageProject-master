//Reglas de validación
const text=/^[A-Za-z á-úÁ-ÚÑñ ]{3,50}$/
const alfanumericos=/^[a-zA-ZñÑá-úÁ-Ú#0-9- ]*[a-zA-ZñÑá-úÁ-Ú#0-9-][0-9]*$/

//Validación de campos para el formulario de login

//Acceder al formulario
let form=document.getElementById("formValiderP")

//Acceder a los feedback
const fb1=document.querySelector("#divNombreProveedor .fbForm")
const fb2=document.querySelector("#divDireccionProveedor .fbForm")

console.log(fb1, fb2)

//Acceder a los inputs
let NameProv=document.getElementById("nombreProveedor")
let AddressProv=document.getElementById("direccionProveedor")

console.log(NameProv,AddressProv)

//Flags para los condicionales
let flag1
let flag2

//Validacion para el campo de name
NameProv.addEventListener("input",(e)=>{
    if (text.test(e.target.value)) {
        // Cuando se valide hará esto
        NameProv.classList.add("success");
        NameProv.classList.remove("error");
        fb1.classList.add("hidden");
        fb1.classList.remove("visible");
        fb1.textContent = '';
        flag1 = true;
    } else {
        // Cuando no sea válido hará esto
        NameProv.classList.add("error");
        NameProv.classList.remove("success");
        fb1.classList.remove("hidden");
        fb1.classList.add("visible");
        fb1.textContent = 'Formato de nombre inválido';
        flag1 = false;
    }
})

//Validacion para el campo de address
AddressProv.addEventListener("input",(e)=>{
    if (alfanumericos.test(e.target.value)) {
        // Cuando se valide hará esto
        AddressProv.classList.add("success");
        AddressProv.classList.remove("error");
        fb2.classList.add("hidden");
        fb2.classList.remove("visible");
        fb2.textContent = '';
        flag2 = true;
    } else {
        // Cuando no sea válido hará esto
        AddressProv.classList.add("error");
        AddressProv.classList.remove("success");
        fb2.classList.remove("hidden");
        fb2.classList.add("visible");
        fb2.textContent = 'Formato de dirección inválida';
        flag2 = false;
    }
})