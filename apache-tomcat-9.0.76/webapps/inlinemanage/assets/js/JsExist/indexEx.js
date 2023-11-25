let mensajeEx = document.getElementById("mensaje1");
if(mensajeJS==" " || mensajeJS==null){

    console.log(mensajeJS+"es nulo")
}else{
    mensajeEx.textContent=mensajeJS
    mensajeEx.style.opacity = "1"
    
    setTimeout(function() {
      mensajeEx.style.opacity = "0";
    }, 3000);
}