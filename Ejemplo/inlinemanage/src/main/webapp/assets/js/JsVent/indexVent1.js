
document.getElementById("mensajeInventario").addEventListener("",()=>{
    
})
let mensajeInvent = document.getElementById("mensajeInventario");
if(mensajeInventario==" " || mensajeInventario==null){

    console.log(mensajeInventario+"es nulo")
}else{
    mensajeInvent.style.opacity="1"
    mensajeInvent.textContent=mensajeInventario

    setTimeout(()=>{
        mensajeInvent.style.opacity="0"
        mensajeInvent.textContent=""
    },3000)
}

let mensajeLogin = document.getElementById("mensaje");
if(mensajeJS==" " || mensajeJS==null){

    console.log(mensajeJS+"es nulo")
}else{
    
    mensajeLogin.style.visibility="visible"
    mensajeLogin.style.opacity="1"
    mensajeLogin.textContent=mensajeJS

    setTimeout(()=>{
        
        mensajeLogin.style.visibility="hidden"
        mensajeLogin.style.opacity="0"
        mensajeLogin.textContent=""
    },3000)
}






document.getElementById("abrirModalReportes").addEventListener("click", ()=>{
    const modal = document.getElementById("modalReportes")
    modal.style.visibility="visible"
})


document.getElementById("cerrarModal").addEventListener("click", ()=>{
    const modal = document.getElementById("modalReportes")
    modal.style.visibility="hidden"
})