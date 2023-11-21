let form=document.getElementById("formRegisterUser")


let fbDocumentType=document.querySelector(".divDocumentType .fbForm")
let fbDocumentNumber=document.querySelector(".divNoDocument .fbForm")
let fbName=document.querySelector(".divName .fbForm")
let fbLastName=document.querySelector(".divLastName .fbForm")
let fbEmail=document.querySelector(".divEmail .fbForm")
let fbPassword=document.querySelector(".divPassword .fbForm")
let fbRol=document.querySelector(".divRol .fbForm")



//Inputs
let documentType=document.getElementById("documentType")
let noDocument=document.getElementById("noDocument")
let fName=document.getElementById("name")
let lastName=document.getElementById("lastName")
let email=document.getElementById("email")
let password=document.getElementById("password")

let flag1
let flag2
let flag3
let flag4
let flag5
let flag6
let flag7


const text=/^[A-Za-z á-úÁ-ÚÑñ]{3,50}$/
const validacionPassword=/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*().-])[A-Za-z0-9!@#$%^&*().-]{10,}$/
const number=/^[0-9]{7,30}$/

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

