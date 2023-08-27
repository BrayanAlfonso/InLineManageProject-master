// Acceder al elemento de entrada de búsqueda
const searchInput = document.getElementById("searchInput");

// Acceder a la tabla de usuarios
const userTable = document.querySelector(".content2 table");

// Función para filtrar y actualizar la tabla
function filterUsers() {
    const searchText = searchInput.value.trim().toLowerCase();

    // Recorrer las filas de la tabla y mostrar u ocultar según el filtro
    userTable.querySelectorAll("tr").forEach(row => {
        if (row.classList.contains("title-table")) {
            // Saltar la fila de título
            return;
        }

        const userText = row.textContent.trim().toLowerCase();
        if (userText.includes(searchText)) {
            row.style.display = "table-row";
        } else {
            row.style.display = "none";
        }
    });
}

// Escuchar el evento de entrada de texto en el campo de búsqueda
searchInput.addEventListener("input", filterUsers);



