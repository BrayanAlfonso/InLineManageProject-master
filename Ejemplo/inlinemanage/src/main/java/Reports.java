

import java.io.IOException;
import java.sql.Date;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfPageEventHelper;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;



import model.DetalleVentDao;
import model.DetalleVentVo;
import model.ProductoDao;
import model.ProductoVo;
import model.ReporteVentaDao;
import model.ReporteVentaVo;

public class Reports extends HttpServlet {


    // private void listDeve(HttpServletRequest req, HttpServletResponse resp) {
    //     try {
    //         List<DetalleVentVo> detalleVentVo = DeveVentDao.listar();
    //         req.setAttribute("Deve", detalleVentVo);
    //         System.out.println("Datos listados correctamente despues de la venta eliminada");
    //     } catch (Exception e) {
    //         System.out.println("Hay problemas al listar los datos en el metodo listVentdelete" + e.getMessage().toString());
    //     }
    // }

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    System.out.println("Entro al doget en reports");
    String enviar = req.getParameter("enviar");
    System.out.println(enviar);
    switch (enviar) {
        
        case "DeVent":
            try {
                // Configura la respuesta HTTP para PDF
                res.setContentType("application/pdf");
                res.setHeader("Content-Disposition", "inline; filename=informe.pdf");

                // Crea un nuevo documento PDF
                Document document = new Document();
                PdfWriter writer = PdfWriter.getInstance(document, res.getOutputStream());

                // Agregar un pie de página con la fecha
                writer.setPageEvent(new PdfPageEventHelper() {
                    public void onEndPage(PdfWriter writer, Document document) {
                        try {
                            PdfPTable footer = new PdfPTable(1);
                            footer.setWidthPercentage(100);
                            PdfPCell cell = new PdfPCell(new Phrase("Fecha de generación: " + LocalDateTime.now()));
                            cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                            cell.setBorder(0);
                            footer.addCell(cell);
                            document.add(footer);
                        } catch (DocumentException e) {
                            e.printStackTrace();
                        }
                    }
                });
                
                document.open();

                Paragraph imageAndTitle = new Paragraph();
                // Agregar imagen y título de la empresa
                Image image = Image.getInstance(getServletContext().getRealPath("/assets/img/LogoInterline.PNG"));

                // Reemplaza "ruta_de_la_imagen.jpg" con la ruta de tu imagen
                image.scaleAbsolute(100, 100); // Ajusta el tamaño de la imagen según tus necesidades
                image.setAlignment(PdfPCell.ALIGN_LEFT);
                

                Paragraph title = new Paragraph("Nombre de la Empresa", new Font(Font.TIMES_ROMAN, 18, Font.BOLD));

                title.setAlignment(PdfPCell.ALIGN_LEFT);

                imageAndTitle.add(image);
                imageAndTitle.add(title);
                document.add(imageAndTitle);

                // Espacio entre la imagen y la tabla
                document.add(new Paragraph(" "));

                document.add(new Paragraph("Infome detalles de venta."));
                document.add(new Paragraph(" "));

                List<ReporteVentaVo> reporte = null;
                try {
                    reporte = new ReporteVentaDao().listarPorInner();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (reporte != null && !reporte.isEmpty()) {
                    PdfPTable table = new PdfPTable(7);
                    table.getDefaultCell().setPadding(8);

                    table.addCell(new Phrase("Id detalle de venta"));
                    table.addCell(new Phrase("Id producto"));
                    table.addCell(new Phrase("Id venta"));
                    table.addCell(new Phrase("Precio"));
                    table.addCell(new Phrase("Cantidad"));
                    table.addCell(new Phrase("Fecha"));
                    table.addCell(new Phrase("idUsuario"));

                    for (ReporteVentaVo report : reporte) {
                        String idDetalleVentaSTR= String.valueOf(report.getIdDetalleVenta());
                        String idProductoSTR= String.valueOf(report.getIdProducto());
                        String idVentaSTR= String.valueOf(report.getIdVenta());
                        String precioSTR = String.valueOf(report.getPrecioProducto());
                        String cantidadSTR = String.valueOf(report.getCantidad());
                        String fechaSTR = String.valueOf(report.getFechaVenta());
                        String idUsuarioSTR = String.valueOf(report.getIdUsuario());

                        table.addCell(idDetalleVentaSTR);
                        table.addCell(idProductoSTR);
                        table.addCell(idVentaSTR);
                        table.addCell(precioSTR);
                        table.addCell(cantidadSTR);    
                        table.addCell(fechaSTR);
                        table.addCell(idUsuarioSTR);   
                    }

                    document.add(table);
                } else {
                    PdfPTable tableError = new PdfPTable(1);
                    tableError.addCell(new Phrase("No se encontraron detalles de venta"));
                    document.add(tableError);
                }

                document.close();
            } catch (DocumentException | IOException e) {
                e.printStackTrace();
            }

            
        break;

        case "DeVentFilter":
            try {
                // Configura la respuesta HTTP para PDF
                res.setContentType("application/pdf");
                res.setHeader("Content-Disposition", "inline; filename=informe.pdf");

                // Crea un nuevo documento PDF
                Document document = new Document();
                PdfWriter.getInstance(document, res.getOutputStream());

                document.open();
                document.add(new Paragraph("Infome detalles de venta."));
                document.add(new Paragraph(" "));

                List<ReporteVentaVo> reporte = null;
                    try {
                        String fechaSTR = req.getParameter("dateFilter");
                        System.out.println(fechaSTR);
                        Date fecha = Date.valueOf(fechaSTR);
                        System.out.println(fecha);
                        reporte = new ReporteVentaDao().listarPorInnerFiltrado(fecha);
                    } catch (Exception e) {
                    e.printStackTrace();
                    }
                
                if (reporte != null && !reporte.isEmpty()) {
                    PdfPTable table = new PdfPTable(7);
                    table.getDefaultCell().setPadding(8);
                    

                    table.addCell(new Phrase("Id detalle de venta"));
                    table.addCell(new Phrase("Id producto"));
                    table.addCell(new Phrase("Id venta"));
                    table.addCell(new Phrase("Precio"));
                    table.addCell(new Phrase("Cantidad"));
                    table.addCell(new Phrase("Fecha"));
                    table.addCell(new Phrase("idUsuario"));
                

                    for(ReporteVentaVo report: reporte){
                        String idDetalleVentaSTR= String.valueOf(report.getIdDetalleVenta());
                        String idProductoSTR= String.valueOf(report.getIdProducto());
                        String idVentaSTR= String.valueOf(report.getIdVenta());
                        String precioSTR = String.valueOf(report.getPrecioProducto());
                        String cantidadSTR = String.valueOf(report.getCantidad());
                        String fechaSTR = String.valueOf(report.getFechaVenta());
                        String idUsuarioSTR = String.valueOf(report.getIdUsuario());

                        table.addCell(idDetalleVentaSTR);
                        table.addCell(idProductoSTR);
                        table.addCell(idVentaSTR);
                        table.addCell(precioSTR);
                        table.addCell(cantidadSTR);    
                        table.addCell(fechaSTR);
                        table.addCell(idUsuarioSTR);   
                    }

                document.add(table);
                }else{
                    PdfPTable tableError = new PdfPTable(1);
                    tableError.addCell(new Phrase("No se encontraron detalles de venta"));
                    document.add(tableError);
                }
                document.close();
            } catch (DocumentException e) {
                e.printStackTrace();
            }
            
        break;
        
        case "product":

        try {
                // Configura la respuesta HTTP para PDF
                res.setContentType("application/pdf");
                res.setHeader("Content-Disposition", "inline; filename=informe.pdf");

                // Crea un nuevo documento PDF
                Document document = new Document(PageSize.A4.rotate());
                PdfWriter.getInstance(document, res.getOutputStream());

                document.open();
                document.add(new Paragraph("Infome productos."));
                document.add(new Paragraph(" "));

                List<ProductoVo> prods = null;
                    try {
                        prods = new ProductoDao().listar();
                    } catch (Exception e) {
                    e.printStackTrace();
                    }
                
                if (prods != null && !prods.isEmpty()) {
                    PdfPTable table = new PdfPTable(9);
                    table.getDefaultCell().setPadding(8);
                    

                    table.addCell(new Phrase("Id producto"));
                    table.addCell(new Phrase("unidades disponibles"));
                    table.addCell(new Phrase("Nombre del producto"));
                    table.addCell(new Phrase("Precio venta"));
                    table.addCell(new Phrase("Descripción"));
                    table.addCell(new Phrase("Serial"));
                    table.addCell(new Phrase("Garantia de entrada (meses)"));
                    table.addCell(new Phrase("Garantia de salida (meses)"));
                    table.addCell(new Phrase("Id categoria"));
                

                    for(ProductoVo prod: prods){
                        String idProductoSTR= String.valueOf(prod.getIdProducto());
                        String unidadesDisponiblesSTR= String.valueOf(prod.getUnidadesDisponibles());
                        String precioVentaSTR= String.valueOf(prod.getPrecioVenta());
                        String serialSTR= String.valueOf(prod.getSerial());
                        String garantiaEntradaSTR = String.valueOf(prod.getGarantiaEntradaMeses());
                        String garantiaSalidaSTR = String.valueOf(prod.getGarantiaVentaMeses());
                        String idCategoriaSTR = String.valueOf(prod.getIdCategoria());

                        table.addCell(idProductoSTR);
                        table.addCell(unidadesDisponiblesSTR);
                        table.addCell(prod.getNombreProducto());
                        table.addCell(precioVentaSTR);
                        table.addCell(prod.getDescripcion());  
                        table.addCell(serialSTR);    
                        table.addCell(garantiaEntradaSTR);    
                        table.addCell(garantiaSalidaSTR);    
                        table.addCell(idCategoriaSTR);    

                    }

                document.add(table);
                }else{
                    PdfPTable tableError = new PdfPTable(1);
                    tableError.addCell(new Phrase("No se encontraron productos"));
                    document.add(tableError);
                }
                document.close();
            } catch (DocumentException e) {
                e.printStackTrace();
            }

        break;

        // Producto filtrado
        case "product_filter":
            System.out.println("Entro al caso product_cilter");
        try {
                // Configura la respuesta HTTP para PDF
                res.setContentType("application/pdf");
                res.setHeader("Content-Disposition", "inline; filename=informe.pdf");

                // Crea un nuevo documento PDF
                Document document = new Document(PageSize.A4.rotate());
                PdfWriter.getInstance(document, res.getOutputStream());

                document.open();
                document.add(new Paragraph("Informe productos filtrados."));
                document.add(new Paragraph(" "));

                
                // Crear variable que llame el campo IdCategoria
                 String IdCategorySTR= req.getParameter("idCategory");
                 int IdCategory = Integer.parseInt(IdCategorySTR);      

                List<ProductoVo> prodsFilters = null;
                    try {
                        prodsFilters = new ProductoDao().listarPorCate(IdCategory);
                    } catch (Exception e) {
                    e.printStackTrace();
                    }
                    
                if (prodsFilters != null && !prodsFilters.isEmpty()) {
                    PdfPTable table = new PdfPTable(9);
                    table.getDefaultCell().setPadding(8);
                        

                    table.addCell(new Phrase("Id producto"));
                    table.addCell(new Phrase("unidades disponibles"));
                    table.addCell(new Phrase("Nombre del producto"));
                    table.addCell(new Phrase("Precio venta"));
                    table.addCell(new Phrase("Descripción"));
                    table.addCell(new Phrase("Serial"));
                    table.addCell(new Phrase("Garantia de entrada (meses)"));
                    table.addCell(new Phrase("Garantia de salida (meses)"));
                    table.addCell(new Phrase("Id categoria"));
                    

                    for(ProductoVo prod: prodsFilters){
                        String idProductoSTR= String.valueOf(prod.getIdProducto());
                        String unidadesDisponiblesSTR= String.valueOf(prod.getUnidadesDisponibles());
                        String precioVentaSTR= String.valueOf(prod.getPrecioVenta());
                        String serialSTR= String.valueOf(prod.getSerial());
                        String garantiaEntradaSTR = String.valueOf(prod.getGarantiaEntradaMeses());
                        String garantiaSalidaSTR = String.valueOf(prod.getGarantiaVentaMeses());
                        String idCategoriaSTR = String.valueOf(prod.getIdCategoria());

                        table.addCell(idProductoSTR);
                        table.addCell(unidadesDisponiblesSTR);
                        table.addCell(prod.getNombreProducto());
                        table.addCell(precioVentaSTR);
                        table.addCell(prod.getDescripcion());  
                        table.addCell(serialSTR);    
                        table.addCell(garantiaEntradaSTR);    
                        table.addCell(garantiaSalidaSTR);    
                        table.addCell(idCategoriaSTR);    

                    }

                document.add(table);
                }else{
                    PdfPTable tableError = new PdfPTable(1);
                    tableError.addCell(new Phrase("No se encontraron productos"));
                    document.add(tableError);
                }
                document.close();
            } catch (DocumentException e) {
                e.printStackTrace();
            }

        break;

        default:
        break;
    }

}
}
