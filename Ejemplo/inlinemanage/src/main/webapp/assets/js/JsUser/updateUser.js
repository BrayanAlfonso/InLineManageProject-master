let form=document.getElementById("formRegisterUser")


let fbDocumentType=document.querySelector(".divDocumentType .fbForm")
let fbDocumentNumber=document.querySelector(".divNoDocument .fbForm")
let fbName=document.querySelector(".divName .fbForm")
let fbLastName=document.querySelector(".divLastName .fbForm")
let fbEmail=document.querySelector(".divEmail .fbForm")
let fbCEmail=document.querySelector(".divCEmail .fbForm")
let fbPassword=document.querySelector(".divPassword .fbForm")
let fbCPassword=document.querySelector(".divCPassword .fbForm")
let fbRol=document.querySelector(".divRol .fbForm")



//Inputs
let documentType=document.getElementById("UpdateDocumentType")
let noDocument=document.getElementById("UpdateNoDocument")
let fName=document.getElementById("UpdateName")
let lastName=document.getElementById("UpdateLastName")
let cEmail=document.getElementById("cEmail")
let email=document.getElementById("UpdateEmail")
let password=document.getElementById("UpdatePassword")
let cPassword=document.getElementById("cPassword")

let flag1
let flag2
let flag3
let flag4
let flag5
let flag6
let flag7
let flag8
let flag9


const text=/^[A-Za-z á-úÁ-ÚÑñ]{3,50}$/
const validacionPassword=/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*().-])[A-Za-z0-9!@#$%^&*().-]{10,}$/
const number=/^[0-9]{7,30}$/
const reCorto = /\S+@\S+\.\S+/

//Espacio para la validacion del tipo de documento



//Validacion de numero de documento
noDocument.addEventListener("input",(e)=>{
    if(number.test(e.target.value)){
        // Cuando se valide hará esto
        noDocument.classList.add("success");
        noDocument.classList.remove("error")
        fbDocumentNumber.classList.add("hidden");
        fbDocumentNumber.classList.remove("visible");
        fbDocumentNumber.textContent = '';
        flag1 = true;
    }else{
        // Cuando no sea válido hará esto
        noDocument.classList.add("error");
        fbDocumentNumber.classList.remove("hidden");
        fbDocumentNumber.classList.add("visible");
        fbDocumentNumber.textContent = 'Numero de documento invalido, solo se aceptan numeros y deben ser minimo 7 y maximo 10';
        flag1 = false;
    }
})

fName.addEventListener("input", (e)=>{
    if(text.test(e.target.value)){
        // Cuando se valide hará esto
        fName.classList.add("success");
        fName.classList.remove("error")
        fbName.classList.add("hidden");
        fbName.classList.remove("visible");
        fbName.textContent = '';
        flag2 = true;
    }else{
        // Cuando no sea válido hará esto
        fName.classList.add("error");
        fbName.classList.remove("hidden");
        fbName.classList.add("visible");
        fbName.textContent = 'Nombre invalido, solo se aceptan letras y deben ser minimo 3, maximo 50';
        flag2 = false;
    }
})

lastName.addEventListener("input", (e)=>{
    if(text.test(e.target.value)){
        // Cuando se valide hará esto
        lastName.classList.add("success");
        lastName.classList.remove("error")
        fbLastName.classList.add("hidden");
        fbLastName.classList.remove("visible");
        fbLastName.textContent = '';
        flag3 = true;
    }else{
        // Cuando no sea válido hará esto
        lastName.classList.add("error");
        fbLastName.classList.remove("hidden");
        fbLastName.classList.add("visible");
        fbLastName.textContent = 'Apellido invalido, solo se aceptan letras y deben ser minimo 3, maximo 50';
        flag3 = false;
    }
})


email.addEventListener("input", (e)=>{
    if(reCorto.test(e.target.value)){
        // Cuando se valide hará esto
        email.classList.add("success");
        email.classList.remove("error")
        fbEmail.classList.add("hidden");
        fbEmail.classList.remove("visible");
        fbEmail.textContent = '';
        flag4 = true;
    }else{
        // Cuando no sea válido hará esto
        email.classList.add("error");
        fbEmail.classList.remove("hidden");
        fbEmail.classList.add("visible");
        fbEmail.textContent = 'El email tener un arroba y un dominio';
        flag4 = false;
    }
})


cEmail.addEventListener("input", (e)=>{
    if(email.value==e.target.value){
        // Cuando se valide hará esto
        cEmail.classList.add("success");
        cEmail.classList.remove("error")
        fbCEmail.classList.add("hidden");
        fbCEmail.classList.remove("visible");
        fbCEmail.textContent = '';
        flag5 = true;
    }else{
        // Cuando no sea válido hará esto
        cEmail.classList.add("error");
        fbCEmail.classList.remove("hidden");
        fbCEmail.classList.add("visible");
        fbCEmail.textContent = 'Los email no coinciden';
        flag5 = false;
    }
})

password.addEventListener("input", (e)=>{
    if(validacionPassword.test(e.target.value)){
        // Cuando se valide hará esto
        password.classList.add("success");
        password.classList.remove("error")
        fbPassword.classList.add("hidden");
        fbPassword.classList.remove("visible");
        fbPassword.textContent = '';
        flag6 = true;
    }else{
        // Cuando no sea válido hará esto
        password.classList.add("error");
        fbPassword.classList.remove("hidden");
        fbPassword.classList.add("visible");
        fbPassword.textContent = 'La contraseña debe tener minimo una letra mayúscula, un número, una letra minúscula, un carácter y debe ser mínimo de 10 caracteres.';
        flag6 = false;
    }
})


cPassword.addEventListener("input", (e)=>{
    if(password.value==e.target.value){
        // Cuando se valide hará esto
        cPassword.classList.add("success");
        cPassword.classList.remove("error")
        fbCPassword.classList.add("hidden");
        fbCPassword.classList.remove("visible");
        fbCPassword.textContent = '';
        flag7 = true;
    }else{
        // Cuando no sea válido hará esto
        cPassword.classList.add("error");
        fbCPassword.classList.remove("hidden");
        fbCPassword.classList.add("visible");
        fbCPassword.textContent = 'Las contraseñas no coinciden';
        flag7 = false;
    }
})