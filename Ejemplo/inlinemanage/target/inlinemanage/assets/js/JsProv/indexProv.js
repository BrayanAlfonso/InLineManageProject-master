let mensajeProv = document.getElementById("mensaje1");
if(mensajeJS==" " || mensajeJS==null){

    console.log(mensajeJS+"es nulo")
}else{
    mensajeProv.textContent=mensajeJS
    mensajeProv.style.opacity = "1"
    
    setTimeout(function() {
      mensajeProv.style.opacity = "0";
    }, 3000);
}