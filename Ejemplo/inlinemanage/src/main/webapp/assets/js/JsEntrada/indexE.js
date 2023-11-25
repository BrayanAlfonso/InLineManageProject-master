let mensajeE = document.getElementById("mensaje1");
if(mensajeJS==" " || mensajeJS==null){

    console.log(mensajeJS+"es nulo")
}else{
    mensajeE.textContent=mensajeJS
    mensajeE.style.opacity = "1"
    
    setTimeout(function() {
      mensajeE.style.opacity = "0";
    }, 3000);
}