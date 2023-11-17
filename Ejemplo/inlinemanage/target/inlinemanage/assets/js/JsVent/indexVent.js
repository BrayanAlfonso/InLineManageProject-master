document.getElementById("generateReportVent").addEventListener("click", () => {
    fetch('/inlinemanage/generarReporteVentas', {
        method: 'GET',
    })
    .then(response => {
        if (response.ok) {
            return response.text(); // Si se recibe una respuesta exitosa
        } else {
            throw new Error('Error al generar el informe');
        }
    })
    .then(data => {
        // Abre el informe en una nueva ventana o muestra la respuesta en tu página.
        window.open('/inlinemanage/generarReporteVentas');
    })
    .catch(error => {
        console.error('Error al generar el informe: ' + error);
    });
});