package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DetalleVentDao;
import model.DetalleVentVo;
import model.VentaDao;
import model.VentaVo;

public class Vent extends HttpServlet{

    
    VentaVo VentVo=new VentaVo();
    VentaDao VentDao=new VentaDao();
    DetalleVentDao DeveDao= new DetalleVentDao();
    DetalleVentVo DeveVo= new DetalleVentVo();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String enviar = req.getParameter("enviar");
        switch (enviar) {
        
            case "vent":
                req.getRequestDispatcher("FormsVent/indexVent.jsp").forward(req, resp);
            break;

            case "registerVent":
                req.getRequestDispatcher("FormsVent/registerVent.jsp").forward(req, resp);
            break;

            case "consultsVent":
                req.getRequestDispatcher("FormsVent/consultsVent.jsp").forward(req, resp);
            break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String enviar = req.getParameter("enviar");
        switch (enviar) {
            //Ventas
            case"registerVent":
                System.out.println("Se entro al caso 'registerVent, en el metodo registerVent()'");
                registerVentController(req, resp);
            break;
        }
    }


    //CRUD VENTA
    private void registerVentController(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        // Obtener el ID del usuario de la sesión
    HttpSession session = req.getSession();
    int idUsuario = (int) session.getAttribute("idUsuario");
    System.out.println("Se entro al metodo registerVentController");
    System.out.println(idUsuario);



    if(req.getParameter("idProducto")!=null){
        DeveVo.setIdProducto(Integer.parseInt(req.getParameter("idProducto")));
    } 
    if(req.getParameter("precioProducto")!=null){
        DeveVo.setPrecioProducto(Float.parseFloat(req.getParameter("precioProducto")));
    }          
    if(req.getParameter("Cantidad")!=null){
        DeveVo.setCantidad(Integer.parseInt(req.getParameter("Cantidad")));
    }
    else{
        System.out.println("Ha habido un error al tratar de registrar los datos de la venta en el metodo registerVentController");
    }
    try {
        DeveDao.registerDetailVent(DeveVo, idUsuario);
        System.out.println("Registro insertado correctamente en controllerInLine");
        //Redireccionamiento
        req.getRequestDispatcher("FormsVent/registerVent.jsp").forward(req, resp);
    } catch (Exception e) {
        System.out.println("Error al registrar los datos de la venta en ControllerInline en el metodo registerVentController");
    }
}





//     //Actualizar Venta
// private void updateVentController(HttpServletRequest req, HttpServletResponse resp) {

//     if (req.getParameter("dateVent") != null) {
//         String fechaDate = req.getParameter("dateVent");
//         Date fechaVentaParsedDate = Date.valueOf(fechaDate);
//         VentVo.setFechaVenta(fechaVentaParsedDate);
//     }
//     if(req.getParameter("idUsuario")!=null){
//         String idUsuString=req.getParameter("idUsuario");
//         int idUsuParsed=Integer.parseInt(idUsuString);
//         VentVo.setIdUsuario(idUsuParsed);
//     }    
//         try {
//             VentDao.actualizar(VentVo);
//             System.out.println("Venta actualizado correctamente");

//             //NOTA: Redireccionamiento preventivo.       
//             req.getRequestDispatcher("FormsVent/indexVent.jsp").forward(req, resp);

//         } catch (Exception e) {
//             System.out.println("Error en la actualizacion de la venta "+e.getMessage().toString());
//         }
//     }
    
    
// private void listVentDelete(HttpServletRequest req, HttpServletResponse resp) {
//         try {
//             List<VentaVo> venta = VentDao.listar();
//             req.setAttribute("Venta", venta);
//             req.getRequestDispatcher("FormsVent/indexVent.jsp").forward(req, resp);
//             System.out.println("Datos listados correctamente despues de la venta eliminada");
//         } catch (Exception e) {
//             System.out.println("Hay problemas al listar los datos en el metodo listVentdelete" + e.getMessage().toString());
//         }
//     }

}
