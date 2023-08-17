
// let menuUser=document.querySelector(".menuUser")
// menuUser.addEventListener("mouseover",()=>{
//     let userOptions=document.querySelector(".userOptions")
    
//     userOptions.style.display="block";

//     iconUser.addEventListener("mouseout", ()=>{
//         setTimeout(()=>{
//             userOptions.style.display="none";
//         },2000)
            
        
//     })
// })

let mensajeLogin = document.getElementById("mensaje");
if(mensajeJS==" "){
    console.log(mensajeJS+"es nulo")
}else{
    mensajeLogin.style.visibility="visible"
    mensajeLogin.style.opacity="1"
    mensajeLogin.style.transition="visibility 0s, opacity 0.5s"
    mensajeLogin.textContent=mensajeJS
}

//Validación de campos para el formulario de login

//Acceder al formulario
let form=document.getElementById("formLogin")

//Acceder a los feedback
const fb1=document.querySelector("#divName .feedback")
const fb2=document.querySelector("#divPassword .feedback")



//Acceder a los inputs
let nameInput=document.getElementById("inputUserName")
let password=document.getElementById("inputPassword")



//Flags para los condicionales
let flag1
let flag2

//Reglas de validación
const text=/^[A-Za-z á-úÁ-ÚÑñ]{5,50}$/
const validacionPassword=/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*().-])[A-Za-z0-9!@#$%^&*().-]{10,}$/


//Validacion para el campo de name
nameInput.addEventListener("input",(e)=>{
    if (text.test(e.target.value)) {
        // Cuando se valide hará esto
        nameInput.classList.add("success");
        nameInput.classList.remove("error")
        fb1.classList.add("hidden");
        fb1.classList.remove("visible");
        fb1.textContent = '';
        flag1 = true;
    } else {
        // Cuando no sea válido hará esto
        nameInput.classList.add("error");
        fb1.classList.remove("hidden");
        fb1.classList.add("visible");
        fb1.textContent = 'Formato de nombre inválido';
        flag1 = false;
    }
})


password.addEventListener("input", (e)=>{
    if(validacionPassword.test(e.target.value)){
        // Cuando se valide hará esto
        password.classList.add("success");
        password.classList.remove("error")
        fb2.classList.add("hidden");
        fb2.classList.remove("visible");
        fb2.textContent = '';
        flag2 = true;
    } else {
        // Cuando no sea válido hará esto
        password.classList.add("error");
        fb2.classList.remove("hidden");
        fb2.classList.add("visible");
        fb2.textContent = 'La contraseña debe tener minimo una letra mayúscula, un número, una letra minúscula, un carácter y debe ser mínimo de 10 caracteres.';
        flag2 = false;
    }
})


form.addEventListener("submit",(e)=>{

    if(nameInput.value==null || nameInput.value=="" || flag1==false){
        alert("Debes ingresar un campo valido")
    }else if(password.value==null || password.value=="" || flag2==false){
        alert("Debes ingresar una contraseña valida")
    }else{
        form.submit()
    }
})




