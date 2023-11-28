// Acceder al elemento de entrada de búsqueda
const ProdInput = document.getElementById("searchInput");

// Acceder a la tabla de usuarios
const ProdTable = document.querySelector(".content2 table");

// Función para filtrar y actualizar la tabla
function filterProd() {
    const searchText = ProdInput.value.trim().toLowerCase();

    // Recorrer las filas de la tabla y mostrar u ocultar según el filtro
    ProdTable.querySelectorAll("tr").forEach(row => {
        if (row.classList.contains("title-table")) {
            // Saltar la fila de título
            return;
        }

        const ProdText = row.textContent.trim().toLowerCase();
        if (ProdText.includes(searchText)) {
            row.style.display = "table-row";
        } else {
            row.style.display = "none";
        }
    });
}

document.getElementById("selectMenu").addEventListener("change",()=>{
    const value=document.getElementById("selectMenu").value
    if (value === "category") {
        window.location.href = "category?enviar=categoria";
    } else if (value === "existence") {
        window.location.href = "existence?enviar=existence";
    }
})


document.getElementById("abrirModalReportes").addEventListener("click", ()=>{
    const modal = document.getElementById("modalReportes")
    modal.style.visibility="visible"
})


document.getElementById("cerrarModal").addEventListener("click", ()=>{
    const modal = document.getElementById("modalReportes")
    modal.style.visibility="hidden"
})

// Escuchar el evento de entrada de texto en el campo de búsqueda
//evento de mensaje
ProdInput.addEventListener("input", filterProd);


let mensajeP = document.getElementById("mensaje1");
if(mensajeJS==" " || mensajeJS==null){

    console.log(mensajeJS+"es nulo")
}else{
    mensajeP.textContent=mensajeJS
    mensajeP.style.opacity = "1"
    
    setTimeout(function() {
      mensajeP.style.opacity = "0";
    }, 3000);
}

