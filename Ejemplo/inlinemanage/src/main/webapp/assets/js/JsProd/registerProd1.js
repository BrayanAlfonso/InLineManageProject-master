const number=/^[0-9]{1,15}$/
const text=/^[a-zA-ZñÑ á-úÁ-Ú ]{1,10}$/
const alfanumericos=/^[a-zA-ZñÑá-úÁ-Ú ]*[a-zA-ZñÑá-úÁ-Ú][0-9]*$/

const form=document.getElementById("formValidacion");
let flag
let flag1
let flag2
let flag3
let flag4
let flag5
let flag6
let flag7


const f1=  document.querySelector(".unidadesDisponibles .fbForm")
console.log(f1)
const f2=  document.querySelector(".nameProduct .fbForm")
const f3=  document.querySelector(".precio .fbForm")
const f4 = document.querySelector(".descripcion .fbForm");
const f5 = document.querySelector(".serial .fbForm");
const f6 = document.querySelector(".garantiaEntrada .fbForm");
const f7 = document.querySelector(".garantiaVentas .fbForm");
const f8 = document.querySelector(".categoria .fbForm");

let unidades=document.getElementById("unidadesDisponibles");
let nombre = document.getElementById("nameProduct");
let precio = document.getElementById("precio");
let descripcion=document.getElementById("descripcion");
let serial=document.getElementById("serial");
let garantiaE=document.getElementById("garantiaEntrada");
let garantiaV=document.getElementById("garantiaVentas");
let categoria=document.getElementById("categoria");

unidades.addEventListener('input', e=>{
  
  if(number.test(e.target.value)){
      //La regla pasa la validacion
      unidades.classList.add("success");
      unidades.classList.remove("error")
      f1.classList.add("hidden");
      f1.classList.remove("visible");
      f1.textContent="";
      flag=true
  }else{
      //Regla no pasa la validacion
      unidades.classList.add("error");
      f1.textContent="Solo puede digitar valores numericos y debe ser al menos uno"
      f1.classList.remove("hidden");
      f1.classList.add("visible");
      flag=false
  }
})


    nombre.addEventListener('input', (e) => {
        
        if (text.test(e.target.value)) {
          nombre.classList.add("success");
          nombre.classList.remove("error")
          f2.classList.add("hidden");
          f2.classList.remove("visible");
          flag1=true
        } else {
          nombre.classList.add("error");
          f2.textContent = "Nombre incorrecto, solo se aeptan letras";
          f2.classList.remove("hidden");
          f2.classList.add("visible");
          flag1=false
        }
      });

precio.addEventListener('input', (e) => {
    
        if (number.test(e.target.value)) {
          precio.classList.add("success");
          precio.classList.remove("error")
          f3.classList.add("hidden");
          f3.classList.remove("visible");
          flag2=true
        } else {
          precio.classList.add("error");
          f3.textContent = "Solo puede digitar valores numerios y debe ser minimo 1";
          f3.classList.remove("hidden");
          f3.classList.add("visible");
          flag2=false
        }
      });

      descripcion.addEventListener('input', (e) => {
      
        if (alfanumericos.test(e.target.value)) {
          descripcion.classList.add("success");
          descripcion.classList.remove("error")
          f4.classList.add("hidden");
          f4.classList.remove("visible");
          flag3 = true;
        } else {
          descripcion.classList.add("error");
          f4.textContent = "Descripion incorrecta, solo se aceptan caracteres alfanumerios";
          f4.classList.remove("hidden");
          f4.classList.add("visible");
          flag3 = false;
        }
      });

      serial.addEventListener('input', (e) => {
      
        if (number.test(e.target.value)) {
          serial.classList.add("success");
          serial.classList.remove("error")
          f5.classList.add("hidden");
          f5.classList.remove("visible");
          flag4 = true;
        } else {
          serial.classList.add("error");
          f5.textContent = "Solo puede digitar valores numerios y debe ser minimo 1";
          f5.classList.remove("hidden");
          f5.classList.add("visible");
          flag4 = false;
        }
      });

      garantiaE.addEventListener('input', (e) => {
      
        if (number.test(e.target.value)) {
          garantiaE.classList.add("success");
          garantiaE.classList.remove("error")
          f6.classList.add("hidden");
          f6.classList.remove("visible");
          flag5 = true;
        } else {
          garantiaE.classList.add("error");
          f6.textContent = "Solo puede digitar valores numerios y debe ser minimo 1";
          f6.classList.remove("hidden");
          f6.classList.add("visible");
          flag5 = false;
        }
      });

      garantiaV.addEventListener('input', (e) => {
      
        if (number.test(e.target.value)) {
          garantiaV.classList.add("success");
          garantiaV.classList.remove("error")
          f7.classList.add("hidden");
          f7.classList.remove("visible");
          flag6 = true;
        } else {
          garantiaV.classList.add("error");
          f7.textContent = "Solo puede digitar valores numerios y debe ser minimo 1";
          f7.classList.remove("hidden");
          f7.classList.add("visible");
          flag6 = false;
        }
      });

      categoria.addEventListener('input', (e) => {
      
        if (number.test(e.target.value)) {
          categoria.classList.add("success");
          categoria.classList.remove("error")
          f8.classList.add("hidden");
          f8.classList.remove("visible");
          flag7 = true;
        } else {
          categoria.classList.add("error");
          f8.textContent = "Solo puede digitar valores numerios y debe ser minimo 1";
          f8.classList.remove("hidden");
          f8.classList.add("visible");
          flag7 = false;
        }
      });


      
      form.addEventListener("submit", (e) => {

      // e.preventDefault()
        if (unidades.value==0||unidades.value==null||flag==false) {
          alert("por favor ingresa un numero de unidades valido")
          unidades.focus()
          unidades.classList.add("error");
        }else if(nombre.value==0||nombre.value==null||flag1==false){
          alert("por favor ingresa un nombre valido")
          nombre.focus()
          nombre.classList.add("error");
        }else if(precio.value==0||precio.value==null||flag2==false){
          alert("por favor ingresa un preio valido")
          precio.focus()
          precio.classList.add("error");
        }else if(descripcion.value==0||descripcion.value==null||flag3==false){
          alert("por favor ingresa una desripion valida")
          descripcion.focus()
          descripcion.classList.add("error");
        }else if(serial.value==0||serial.value==null||flag4==false){
          alert("por favor ingresa un serial valido")
          serial.focus()
          serial.classList.add("error");
        }else if(garantiaE.value==0||garantiaE.value==null||flag5==false){
          alert("por favor ingresa una garantia de entrada valida")
          garantiaE.focus()
          garantiaE.classList.add("error");
        }else if(garantiaV.value==0||garantiaV.value==null||flag6==false){
          alert("por favor ingresa una garantia de venta valida")
          garantiaV.focus()
          garantiaV.classList.add("error");
        }else if(categoria.value==0||categoria.value==null||flag7==false){
          alert("por favor ingresa una categoria valida")
          categoria.focus()
          categoria.classList.add("error");
        }else {
          form.submit()
        }
      });