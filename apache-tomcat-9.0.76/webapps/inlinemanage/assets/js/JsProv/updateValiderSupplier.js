//Reglas de validación
const text=/^[A-Za-z á-úÁ-ÚÑñ ]{3,50}$/
const alfanumericos=/^[a-zA-ZñÑá-úÁ-Ú#0-9- ]*[a-zA-ZñÑá-úÁ-Ú#0-9-][0-9]*$/

//Validación de campos para el formulario de login

//Acceder al formulario
let form=document.getElementById("formValiderP")

//Acceder a los feedback
const fb1=document.querySelector("#divUpdateNameSupplier .fbForm")
const fb2=document.querySelector("#divUpdateAdressSupplier .fbForm")

console.log(fb1, fb2)

//Acceder a los inputs
let UpdateNameProv=document.getElementById("UpdateNameSupplier")
let UpdateAddressProv=document.getElementById("UpdateAdressSupplier")

console.log(UpdateNameProv,UpdateAddressProv)

//Flags para los condicionales
let flag1
let flag2

//Validacion para el campo de name
UpdateNameProv.addEventListener("input",(e)=>{
    if (text.test(e.target.value)) {
        // Cuando se valide hará esto
        UpdateNameProv.classList.add("success");
        UpdateNameProv.classList.remove("error");
        fb1.classList.add("hidden");
        fb1.classList.remove("visible");
        fb1.textContent = '';
        flag1 = true;
    } else {
        // Cuando no sea válido hará esto
        UpdateNameProv.classList.add("error");
        UpdateNameProv.classList.remove("success");
        fb1.classList.remove("hidden");
        fb1.classList.add("visible");
        fb1.textContent = 'Solo se aceptan letras';
        flag1 = false;
    }
})

//Validacion para el campo de address
UpdateAddressProv.addEventListener("input",(e)=>{
    if (alfanumericos.test(e.target.value)) {
        // Cuando se valide hará esto
        UpdateAddressProv.classList.add("success");
        UpdateAddressProv.classList.remove("error");
        fb2.classList.add("hidden");
        fb2.classList.remove("visible");
        fb2.textContent = '';
        flag2 = true;
    } else {
        // Cuando no sea válido hará esto
        UpdateAddressProv.classList.add("error");
        UpdateAddressProv.classList.remove("success");
        fb2.classList.remove("hidden");
        fb2.classList.add("visible");
        fb2.textContent = 'Formato de dirección inválida';
        flag2 = false;
    }
})