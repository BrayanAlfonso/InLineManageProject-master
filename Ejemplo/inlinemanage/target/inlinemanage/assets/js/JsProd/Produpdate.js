const number=/[0-9]{1,30}/
const text=/^[a-zA-ZñÑá-úÁ-Ú ]{1,10}$/
const alfanumericos=/^[a-zA-ZñÑá-úÁ-Ú ]*[a-zA-ZñÑá-úÁ-Ú][0-9]*$/

const form=document.getElementById("formValidacion");
let flag1
let flag2
let flag3
let flag4
let flag5
let flag6
let flag7
let flag8 

const f1= document.querySelector(".divUnidProd .fbForm")
const f2= document.querySelector(".divNameProd .fbForm")
const f3= document.querySelector(".divPrecio .fbForm")
const f4 = document.querySelector(".divDescripcion .fbForm");
const f5 = document.querySelector(".divNumSerial .fbForm");
const f6 = document.querySelector(".divEntrada .fbForm");
const f7 = document.querySelector(".divVenta .fbForm");
const f8 = document.querySelector(".divCategoria .fbForm");

let unidadesU=document.getElementById("UpdateUnidadesDisponibles");
let nombreU = document.getElementById("UpdateNameProducto");
let precioU = document.getElementById("UpdatePrecio");
let descripcionU =document.getElementById("UpdateDescripcion");
let serialU =document.getElementById("UpdateSerial");
let garantiaEU=document.getElementById("UpdateGarantiaEntrada");
let garantiaVU=document.getElementById("UpdateGarantiaVentas");
let categoriaU=document.getElementById("UpdateCategoria");

unidadesU.addEventListener('input', (a)=>{
  
  if(number.test(a.target.value)){
      //La regla pasa la validacion
      unidadesU.classList.add("success");
      unidadesU.classList.remove("error");
      f1.classList.add("hidden");
      f1.classList.remove("visible");
      f1.textContent="";
      flag1=true
  }else{
      //Regla no pasa la validacion
      unidadesU.classList.add("error");
      f1.textContent = "Solo puede digitar valores numericos y debe ser al menos uno";
      f1.classList.remove("hidden");
      f1.classList.add("visible");
      flag1=false
  }
})

nombreU.addEventListener('input', (a)=>{
  
  if(text.test(a.target.value)){
      //La regla pasa la validacion   
      nombreU.classList.add("success");
      nombreU.classList.remove("error");
      f2.classList.add("hidden");
      f2.classList.remove("visible");
      flag2=true
  }else{
      //Regla no pasa la validacion 
      nombreU.classList.add("error");
      f2.textContent = "Nombre incorrecto, solo se aeptan letras";
      f2.classList.remove("hidden");
      f2.classList.add("visible");   
      flag2=false
  }
})

//Validacion de precio de producto
precioU.addEventListener('input', (a)=>{
  
  if(number.test(a.target.value)){
      //La regla pasa la validacion   
      precioU.classList.add("success");
      precioU.classList.remove("error");
      f3.classList.add("hidden");
      f3.classList.remove("visible");
      flag3=true
  }else{
      //Regla no pasa la validacion 
      precioU.classList.add("error");
      f3.textContent = "Solo puede digitar valores numerios y debe ser minimo 1";
      f3.classList.remove("hidden");
      f3.classList.add("visible");
      flag3=false
  }
})

//Validacion de descripcion
descripcionU.addEventListener("input", (a)=>{
  
  if(alfanumericos.test(a.target.value)){
      //La regla pasa la validacion   
      descripcionU.classList.add("success");
      descripcionU.classList.remove("error");
      f4.classList.add("hidden");
      f4.classList.remove("visible");
      flag4=true
  }else{
      //Regla no pasa la validacion 
      descripcionU.classList.add("error");
      f4.textContent = "Descripion incorrecta, solo se aceptan caracteres alfanumerios";
      f4.classList.remove("hidden");
      f4.classList.add("visible");
      flag4=false
  }
})

//Validacion de serial
serialU.addEventListener("input", (a)=>{
  
  if(number.test(a.target.value)){
      //La regla pasa la validacion   
      serialU.classList.add("success");
      serialU.classList.remove("error");
      f5.classList.add("hidden");
      f5.classList.remove("visible");
      flag5=true
  }else{
      //Regla no pasa la validacion 
      serialU.classList.add("error");
      f5.textContent = "Solo puede digitar valores numerios y debe ser minimo 1";
      f5.classList.remove("hidden");
      f5.classList.add("visible");
      flag5=false
  }
})

//Validacion de garantia de entrada
garantiaEU.addEventListener("input", (a)=>{
  
  if(number.test(a.target.value)){
      //La regla pasa la validacion   
      garantiaEU.classList.add("success");
      garantiaEU.classList.remove("error");
      f6.classList.add("hidden");
      f6.classList.remove("visible");
      flag6=true
  }else{
      //Regla no pasa la validacion 
      garantiaEU.classList.add("error");
      f6.textContent = "Solo puede digitar valores numerios y debe ser minimo 1";
      f6.classList.remove("hidden");
      f6.classList.add("visible");
      flag6=false
  }})

  ////Validacion de garantia de venta
garantiaVU.addEventListener("input", (a)=>{
  
    if(number.test(a.target.value)){
        //La regla pasa la validacion   
        garantiaVU.classList.add("success");
        garantiaVU.classList.remove("error");
        f7.classList.add("hidden");
        f7.classList.remove("visible");
        flag7=true
    }else{
        //Regla no pasa la validacion 
        garantiaVU.classList.add("error");
        f7.textContent = "Solo puede digitar valores numerios y debe ser minimo 1";
        f7.classList.remove("hidden");
        f7.classList.add("visible");
        flag7=false
    }})

//Validacion de categoria
categoriaU.addEventListener("input", (a)=>{
  
      if(number.test(a.target.value)){
          //La regla pasa la validacion   
          categoriaU.classList.add("success");
          categoriaU.classList.remove("error");
          f8.classList.add("hidden");
          f8.classList.remove("visible");
          flag8=true
      }else{
          //Regla no pasa la validacion 
          categoriaU.classList.add("error");
          f8.textContent = "Solo puede digitar valores numerios y debe ser minimo 1";
          f8.classList.remove("hidden");
          f8.classList.add("visible");
          flag8=false
}})

//Validacion de boton
form.addEventListener("submit", (e) =>{
  // e.preventDefault()
        if (unidadesU.value==null || unidadesU.value=="" || flag1==false) {
          alert("por favor ingresa un numero de unidades")
          unidadesU.focus()
          unidadesU.classList.add("error");
        }else if (nombreU.value==null || nombreU.value=="" || flag2==false) {
          alert("por favor ingresa un nombre de producto")
          nombreU.focus()
          nombreU.classList.add("error");
        }else if (precioU.value==null || precioU.value=="" || flag3==false) {
          alert("por favor ingresa un precio de producto");
          precioU.focus()
          precioU.classList.add("error");
        }else if (descripcionU.value==null || descripcionU.value=="" || flag4==false) {
          alert("por favor ingresa una descripcion");
          descripcionU.focus()
          descripcionU.classList.add("error");
        }else if (serialU.value==null || serialU.value=="" || flag5==false) {
          alert("por favor ingresa el serial");
          serialU.focus()
          serialU.classList.add("error");
        }else if (garantiaEU.value==null || garantiaEU.value=="" || flag6==false) {
          alert("por favor ingresa un numero de meses de garantia");
          garantiaEU.focus()
          garantiaEU.classList.add("error");
        }else if (garantiaVU.value==null || garantiaVU.value=="" || flag7==false) {
          alert("por favor ingresa un numero de meses de garantia");
          garantiaVU.focus()
          garantiaVU.classList.add("error");
        }else if (categoriaU.value==null || categoriaU.value=="" || flag8==false) {
          alert("por favor ingresa un numero de categoria");
          categoriaU.focus()
          categoriaU.classList.add("error");
        }else {
          form.submit()
        }
});