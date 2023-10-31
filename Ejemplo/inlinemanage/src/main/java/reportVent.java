

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;

import model.CategoriaVo;
import model.Conexion;
import model.DetalleVentDao;
import model.DetalleVentVo;
import model.VentaDao;
import model.VentaVo;

public class reportVent extends HttpServlet {


    // private void listDeve(HttpServletRequest req, HttpServletResponse resp) {
    //     try {
    //         List<DetalleVentVo> detalleVentVo = DeveVentDao.listar();
    //         req.setAttribute("Deve", detalleVentVo);
    //         System.out.println("Datos listados correctamente despues de la venta eliminada");
    //     } catch (Exception e) {
    //         System.out.println("Hay problemas al listar los datos en el metodo listVentdelete" + e.getMessage().toString());
    //     }
    // }


protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
        // Configura la respuesta HTTP para PDF
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "inline; filename=informe.pdf");

        // Crea un nuevo documento PDF
        Document document = new Document();
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        document.add(new Paragraph("Este es un informe en tiempo real generado con iText en Java."));

        List<DetalleVentVo> deves = null;
            try {
                deves = new DetalleVentDao().listar();
            } catch (Exception e) {
            e.printStackTrace();
        }
        
        if (deves != null && !deves.isEmpty()) {
            PdfPTable table = new PdfPTable(5);
            table.addCell(new Phrase("Id detalle de venta"));
            table.addCell(new Phrase("Id producto"));
            table.addCell(new Phrase("Id venta"));
            table.addCell(new Phrase("Precio"));
            table.addCell(new Phrase("Cantidad"));

            for(DetalleVentVo deve: deves){
                String idDetalleVentaSTR= String.valueOf(deve.getIdDetalleVenta());
                String idProductoSTR= String.valueOf(deve.getIdProducto());
                String idVentaSTR= String.valueOf(deve.getIdVenta());
                String precioSTR = String.valueOf(deve.getPrecioProducto());
                String cantidadSTR = String.valueOf(deve.getCantidad());

                table.addCell(idDetalleVentaSTR);
                table.addCell(idProductoSTR);
                table.addCell(idVentaSTR);
                table.addCell(precioSTR);
                table.addCell(cantidadSTR);


                document.add(table);

            }


        }else{
            PdfPTable tableError = new PdfPTable(1);
            tableError.addCell(new Phrase("No se encontraron detalles de venta"));
            document.add(tableError);
        }

        

        document.close();
    } catch (DocumentException e) {
        e.printStackTrace();
    }
}
}
