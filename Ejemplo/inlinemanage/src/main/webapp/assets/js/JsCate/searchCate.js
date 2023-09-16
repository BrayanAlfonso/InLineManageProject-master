// Acceder al elemento de entrada de búsqueda
const CateInput = document.getElementById("searchInput");

// Acceder a la tabla de usuarios
const CateTable = document.querySelector(".content2 table");

// Función para filtrar y actualizar la tabla
function filterCate() {
    const searchText = CateInput.value.trim().toLowerCase();

    // Recorrer las filas de la tabla y mostrar u ocultar según el filtro
    CateTable.querySelectorAll("tr").forEach(row => {
        if (row.classList.contains("title-table")) {
            // Saltar la fila de título
            return;
        }

        const CateText = row.textContent.trim().toLowerCase();
        if (CateText.includes(searchText)) {
            row.style.display = "table-row";
        } else {
            row.style.display = "none";
        }
    });
}

// Escuchar el evento de entrada de texto en el campo de búsqueda
CateInput.addEventListener("input", filterCate);