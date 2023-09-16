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

// Escuchar el evento de entrada de texto en el campo de búsqueda
ProdInput.addEventListener("input", filterProd);