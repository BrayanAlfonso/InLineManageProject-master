
let menuUser=document.querySelector(".menuUser")
menuUser.addEventListener("mouseover",()=>{
    let userOptions=document.querySelector(".userOptions")
    
    userOptions.style.display="block";

    iconUser.addEventListener("mouseout", ()=>{
        setTimeout(()=>{
            userOptions.style.display="none";
        },2000)
            
        
    })
})


//Validación de campos para el formulario de login

//Acceder al formulario
let form=document.getElementById("formLogin")

//Acceder a los feedback
const fb1=document.querySelector("#divName .feedaback")
const fb2=document.querySelector("#divPassword .feedaback")

console.log(fb1, fb2)

//Acceder a los inputs
let nameInput=document.getElementById("inputUserName")
let password=document.getElementById("inputPassword")

console.log(nameInput,password)

//Flags para los condicionales
let flag1
let flag2

//Reglas de validación
const text=/^[A-Za-z á-úÁ-ÚÑñ]{3,5}$/


//Validacion para el campo de name
nameInput.addEventListener("input",(e)=>{
    if (text.test(e.target.value)) {
        // Cuando se valide hará esto
        nameInput.setAttribute("class", "success");
        fb1.classList.add("hidden");
        fb1.classList.remove("visible");
        fb1.textContent = '';
        flag1 = true;
    } else {
        // Cuando no sea válido hará esto
        nameInput.setAttribute("class", "error");
        fb1.classList.remove("hidden");
        fb1.classList.add("visible");
        fb1.textContent = 'Formato de nombre inválido';
        flag1 = false;
    }
})


