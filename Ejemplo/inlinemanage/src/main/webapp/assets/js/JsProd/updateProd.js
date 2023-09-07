const number=/[0-9]{5,15}/
const text=/^[a-zA-ZñÑá-úÁ-Ú]{1,10}$/

const form=document.getElementById("formValidacion");

const f1=  document.querySelector("#divUnidProd .feedback")
const f2=  document.querySelector("#divNameProd .feedback")
const f3=  document.querySelector("#divPrecio .feedback")
const f4 = document.querySelector("#divDescripcion .feedback");
const f5 = document.querySelector("#divNumSerial .feedback");
const f6 = document.querySelector("#divEntrada .feedback");
const f7 = document.querySelector("#divVenta .feedback");
const f8 = document.querySelector("#divCategoria .feedback");

const unidades=document.getElementsByName("UpdateUnidadesDisponibles");
const nombre = document.getElementsByName("UpdateNameProducto");
const precio = document.getElementsByName("UpdatePrecio");
const descripcion=document.getElementsByName("UpdateDescripcion");
const serial=document.getElementsByName("UpdateSerial");
const garantiaE=document.getElementsByName("UpdateGarantiaEntrada");
const garamtiaV=document.getElementsByName("UpdateGarantiaVentas");
const categoria=document.getElementsByName("UpdateCategoria");

form.unidades.addEventListener('input', e=>{
  
    if(number.test(e.target.value)){
        //La regla pasa la validacion
        form.unidades.setAttribute("class","success");
        f1.style.visibility="hidden"
        f1.style.opacity="0"
        flag=true
    }else{
        //Regla no pasa la validacion
        form.unidades.setAttribute("class","error");
        f1.textContent="Solo puede digitar valores numericos"
        f1.style.visibility="visible"
        f1.style.opacity="1"
        flag=false
    }
})

    form.nombre.addEventListener('input', (e) => {
        
        if (text.test(e.target.value)) {
          form.nombre.setAttribute("class","success");
          f2.style.visibility = "hidden";
          f2.style.opacity = "0";
          flag=true
        } else {
          form.nombre.setAttribute("class","error");
          f2.textContent = "Solo puede digitar caracteres de palabra";
          f2.style.visibility = "visible";
          f2.style.opacity = "1";
          flag=false
        }
      });


      form.precio.addEventListener('input', (e) => {
    
        if (number.test(e.target.value)) {
          form.precio.setAttribute("class","success");
          f3.style.visibility = "hidden";
          f3.style.opacity = "0";
          flag=true
        } else {
          forprecio.setAttribute("class","error");
          f3.textContent = "Solo puede digitar caracteres de palabra";
          f3.style.visibility = "visible";
          f3.style.opacity = "1";
          flag=false
        }
      });

      form.descripcion.addEventListener('input', (e) => {
      
        if (text.test(e.target.value)) {
          form.descripcion.setAttribute("class", "success");
          f4.style.visibility = "hidden";
          f4.style.opacity = "0";
          flag = true;
        } else {
          form.descripcion.setAttribute("class", "error");
          f4.textContent = "El correo es incorrecto o no tiene el dominio @misena.edu.co";
          f4.style.visibility = "visible";
          f4.style.opacity = "1";
          flag = false;
        }
      });

      form.serial.addEventListener('input', (e) => {
      
        if (text.test(e.target.value)) {
          form.serial.setAttribute("class", "success");
          f5.style.visibility = "hidden";
          f5.style.opacity = "0";
          flag = true;
        } else {
          form.serial.setAttribute("class", "error");
          f5.textContent = "La contraseña debe tener al menos una letra mayúscula, una letra minúscula, un número, un carácter especial y ser de mínimo 10 caracteres.";
          f5.style.visibility = "visible";
          f5.style.opacity = "1";
          flag = false;
        }
      });

      form.garantiaE.addEventListener('input', (e) => {
      
        if (text.test(e.target.value)) {
          form.garantiaE.setAttribute("class", "success");
          f6.style.visibility = "hidden";
          f6.style.opacity = "0";
          flag = true;
        } else {
          form.garantiaE.setAttribute("class", "error");
          f6.textContent = "La contraseña debe tener al menos una letra mayúscula, una letra minúscula, un número, un carácter especial y ser de mínimo 10 caracteres.";
          f6.style.visibility = "visible";
          f6.style.opacity = "1";
          flag = false;
        }
      });

      form.garantiaV.addEventListener('input', (e) => {
      
        if (text.test(e.target.value)) {
          form.garantiaV.setAttribute("class", "success");
          f7.style.visibility = "hidden";
          f7.style.opacity = "0";
          flag = true;
        } else {
          form.garantiaV.setAttribute("class", "error");
          f7.textContent = "La contraseña debe tener al menos una letra mayúscula, una letra minúscula, un número, un carácter especial y ser de mínimo 10 caracteres.";
          f7.style.visibility = "visible";
          f7.style.opacity = "1";
          flag = false;
        }
      });

      form.categoria.addEventListener('input', (e) => {
      
        if (text.test(e.target.value)) {
          form.categoria.setAttribute("class", "success");
          f8.style.visibility = "hidden";
          f8.style.opacity = "0";
          flag = true;
        } else {
          form.categoria.setAttribute("class", "error");
          f8.textContent = "La contraseña debe tener al menos una letra mayúscula, una letra minúscula, un número, un carácter especial y ser de mínimo 10 caracteres.";
          f8.style.visibility = "visible";
          f8.style.opacity = "1";
          flag = false;
        }
      });

      form.addEventListener("btnForm", (e) => {
        e.preventDefault();
      
        if (form.unidades.value==0||form.unidades.value==null||flag==false) {
          alert("por favor ingresa un numero de documento valido")
          form.unidades.focus()
          form.unidades.setAttribute("class", "error");
        }else if(form.nombre.value==0||form.nombre.value==null||flag==false){
          alert("por favor ingresa un nombre")
          form.nombre.focus()
          form.nombre.setAttribute("class", "error");
        }else if(form.precio.value==0||form.precio.value==null||flag==false){
          alert("por favor ingresa un nombre")
          form.precio.focus()
          form.precio.setAttribute("class", "error");
        }else if(form.descripcion.value==0||form.descripcion.value==null||flag==false){
          alert("por favor ingresa un nombre")
          form.descripcion.focus()
          form.descripcion.setAttribute("class", "error");
        }else if(form.serial.value==0||form.serial.value==null||flag==false){
          alert("por favor ingresa un nombre")
          form.serial.focus()
          form.serial.setAttribute("class", "error");
        }else if(form.garantiaE.value==0||form.garantiaE.value==null||flag==false){
          alert("por favor ingresa un nombre")
          form.garantiaE.focus()
          form.garantiaE.setAttribute("class", "error");
        }else if(form.garamtiaV.value==0||form.garamtiaV.value==null||flag==false){
          alert("por favor ingresa un nombre")
          form.garamtiaV.focus()
          form.garamtiaV.setAttribute("class", "error");
        }else if(form.categoria.value==0||form.categoria.value==null||flag==false){
          alert("por favor ingresa un nombre")
          form.categoria.focus()
          form.categoria.setAttribute("class", "error");
        }else {
          form.submit()
        }
      });