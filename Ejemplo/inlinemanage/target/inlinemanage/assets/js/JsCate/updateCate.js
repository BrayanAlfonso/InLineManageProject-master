const text=/^[A-Za-z á-úÁ-ÚÑñ]{5,50}$/

const form=document.getElementById("formValidacion");
let flag

const f1= document.querySelector(".divCategoria .fbForm")
let nombreCate = document.getElementById("UpdateNameCategory");

//Validacion de nombre
nombreCate.addEventListener("input", (a)=>{
  
    if(text.test(a.target.value)){
        //La regla pasa la validacion   
        nombreCate.classList.add("success");
        nombreCate.classList.remove("error");
        f1.classList.add("hidden");
        f1.classList.remove("visible");
        flag=true
    }else{
        //Regla no pasa la validacion 
        nombreCate.classList.add("error");
        f1.classList.remove("hidden");
        f1.classList.add("visible");
        f1.textContent = 'Solo puede digitar valores de texto';
        flag=false
    }
})

form.addEventListener("submit", (e) =>{
  // e.preventDefault()
    if (nombreCate.value==null || nombreCate.value=="" || flag==false) {
      alert("por favor ingresa un numero de unidades")
      nombreCate.focus()
      nombreCate.classList.add("error");
    }else {
      form.submit()
    }
});